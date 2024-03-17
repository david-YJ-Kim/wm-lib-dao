package com.abs.wfs.workman.message.service.eap.impl;

import com.abs.wfs.workman.config.ApPropertyObject;
import com.abs.wfs.workman.domain.staterule.service.StateRuleInfoServiceImpl;
import com.abs.wfs.workman.query.tool.service.ToolQueryServiceImpl;
import com.abs.wfs.workman.query.tool.vo.QueryEqpVo;
import com.abs.wfs.workman.query.tool.vo.QueryPortVo;
import com.abs.wfs.workman.util.code.UseStatCd;
import com.abs.wfs.workman.util.code.WorkManScenarioList;
import com.abs.wfs.workman.message.service.eap.WfsLoadReq;
import com.abs.wfs.workman.message.util.WorkManCommonUtil;
import com.abs.wfs.workman.message.vo.common.ApMessageResultVo;
import com.abs.wfs.workman.message.vo.receive.eap.WfsLoadReqVo;
import com.abs.wfs.workman.util.service.StateRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Service
public class WfsLoadReqImpl implements WfsLoadReq {

    @Autowired
    ToolQueryServiceImpl toolQueryService;

    @Autowired
    StateRuleManager stateRuleManager;

    private static final String siteId = ApPropertyObject.getInstance().getSiteName();

    private WfsLoadReqVo.WfsLoadReqBody wfsLoadReqBody;
    private long executeStartTime;

    private QueryPortVo queryPortVo;
    private QueryEqpVo queryEqpVo;

    private ExecutorService executorService;

    @Override
    public void init(WfsLoadReqVo wfsLoadReqVo) {
        this.executeStartTime = System.currentTimeMillis();
        this.wfsLoadReqBody = wfsLoadReqVo.getBody();
    }

    @Override
    public ApMessageResultVo execute(String messageId) throws Exception {

        // Query
        List<Runnable> tasks = Arrays.asList(
                () -> {
                    this.queryEqpVo = toolQueryService.queryEqpCondition(
                            QueryEqpVo.builder()
                                    .siteId(this.wfsLoadReqBody.getSiteId())
                                    .useStatCd(UseStatCd.Usable.name())
                                    .eqpId(this.wfsLoadReqBody.getEqpId())
                                    .build()
                    );
                },
                () -> {
                    this.queryPortVo = toolQueryService.queryPortCondition(
                            QueryPortVo.builder()
                                    .siteId(this.wfsLoadReqBody.getSiteId())
                                    .useStatCd(UseStatCd.Usable.name())
                                    .eqpId(this.wfsLoadReqBody.getEqpId())
                                    .portId(this.wfsLoadReqBody.getPortId())
                                    .build()
                    );

                }
        );
        this.executorService = Executors.newFixedThreadPool(tasks.size());
        CompletableFuture.allOf(tasks.stream()
                .map(task -> CompletableFuture.runAsync(task, this.executorService))
                .toArray(CompletableFuture[]::new)).join();
        this.executorService.shutdown();


        // Validation
        List<Runnable> validateTasks = Arrays.asList(
                () -> {
                    try {
                        this.stateRuleManager.validEqp(siteId, this.wfsLoadReqBody.getEqpId(), this.queryEqpVo);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },
                () -> {
                    try {
                        this.stateRuleManager.validPort(siteId, this.wfsLoadReqBody.getEqpId(),
                                                        this.wfsLoadReqBody.getPortId(), this.queryPortVo);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },
                () -> {
                    try {
                        this.stateRuleManager.FullAutoPort(siteId, this.wfsLoadReqBody.getEqpId(),
                                                    this.wfsLoadReqBody.getPortId(), this.queryPortVo);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },
                () -> {
                    try {
                        this.stateRuleManager.fullAutoEqp(siteId, this.wfsLoadReqBody.getEqpId(), this.queryEqpVo);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        this.executorService = Executors.newFixedThreadPool(validateTasks.size());
        CompletableFuture.allOf(validateTasks.stream()
                .map(task -> CompletableFuture.runAsync(task, this.executorService))
                .toArray(CompletableFuture[]::new)).join();
        this.executorService.shutdown();

        // TODO Get Data from query service
//        QueryEqpVo queryEqpVo = toolQueryService.queryEqpCondition(
//                                                        QueryEqpVo.builder()
//                                                        .siteId(this.wfsLoadReqBody.getSiteId())
//                                                        .useStatCd(UseStatCd.Usable.name())
//                                                        .eqpId(this.wfsLoadReqBody.getEqpId())
//                                                        .build()
//        );
//
//        QueryPortVo queryPortVo = toolQueryService.queryPortCondition(
//                                                    QueryPortVo.builder()
//                                                            .siteId(this.wfsLoadReqBody.getSiteId())
//                                                            .useStatCd(UseStatCd.Usable.name())
//                                                            .eqpId(this.wfsLoadReqBody.getEqpId())
//                                                            .portId(this.wfsLoadReqBody.getPortId())
//                                                            .build()
//        );


        // TODO DO Validation such as state rule.

        this.scenarioDispatch(messageId);
        ApMessageResultVo apMessageResultVo = ApMessageResultVo.builder()
                .elapsedMilliSecond(System.currentTimeMillis() - executeStartTime)
                .build();
        return apMessageResultVo;
    }



    private void scenarioDispatch(String messageId){
        String eqpId = wfsLoadReqBody.getEqpId();
        String scenarioType = WorkManCommonUtil.getScenarioType(eqpId);

        switch (scenarioType){
            case WorkManScenarioList.SORTER:
                // TODO Sorter 특화 이벤트 로직

                break;

            default:
                // TODO 기본 로직 수행
                break;
        }

    }
}
