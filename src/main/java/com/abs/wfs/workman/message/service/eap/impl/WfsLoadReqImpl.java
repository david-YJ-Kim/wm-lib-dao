package com.abs.wfs.workman.message.service.eap.impl;

import com.abs.wfs.workman.config.ApPropertyObject;
import com.abs.wfs.workman.query.tool.service.ToolQueryServiceImpl;
import com.abs.wfs.workman.query.tool.vo.QueryEqpVo;
import com.abs.wfs.workman.query.tool.vo.QueryPortVo;
import com.abs.wfs.workman.util.code.*;
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
    private String cid;

    private WfsLoadReqVo.WfsLoadReqBody wfsLoadReqBody;
    private long executeStartTime;

    private QueryPortVo queryPortVo;
    private QueryEqpVo queryEqpVo;

    private ExecutorService executorService;

    @Override
    public void init(String cid, Object messageObj) {
        this.cid = cid;
        this.wfsLoadReqBody = ((WfsLoadReqVo) messageObj).getBody();
        this.executeStartTime = System.currentTimeMillis();
    }

    @Override
    public ApMessageResultVo execute(String messageId) throws Exception {

        // Query
        this.executeQueryTasks();

        // Validation - state rule
        this.executeValidationTasks();


        // Validation - others
        if((this.queryPortVo.getCarrTyp().trim()).equals(ApEnumConstant.CA.name())){
            throw new Exception("CARR TPYE MISMACH");
        }


        // Validation each Scenario
        this.scenarioDispatch(messageId);

        // TODO send message or db update


        ApMessageResultVo apMessageResultVo = ApMessageResultVo.builder()
                .cid(cid)
                .messageKey(messageId)
                .elapsedMilliSecond(System.currentTimeMillis() - executeStartTime)
                .executeSuccessYn(UseYn.Y)
                .build();
        return apMessageResultVo;
    }


    public void scenarioDispatch(String messageId){
        String eqpId = wfsLoadReqBody.getEqpId();
        String scenarioType = WorkManCommonUtil.getScenarioType(eqpId);

        switch (scenarioType){
            case WorkManScenarioList.SORTER:
                // TODO Sorter 특화 이벤트 로직

                break;

            default:

                // TODO Get message send resource.
                // TODO generate payload

                // Message send based on Port Type.
                switch (this.queryPortVo.getPortTyp()){
                    case ApStringConstant.BP:
                        break;
                    case ApStringConstant.OP:
                        break;
                    case ApStringConstant.IP:
                        break;

                    default:
                        break;

                }
                break;
        }

    }


    private void executeQueryTasks() {
        List<Runnable> tasks = Arrays.asList(
                this::queryEqp,
                this::queryPort
        );
        executeTasks(tasks);
    }

    private void executeValidationTasks() {
        List<Runnable> validateTasks = Arrays.asList(
                () -> validateStateRule(StateRuleList.ValidEqp),
                () -> validateStateRule(StateRuleList.ValidPort),
                () -> validateStateRule(StateRuleList.FullAutoPort),
                () -> validateStateRule(StateRuleList.FullAutoEqp)
        );
        executeTasks(validateTasks);
    }

    private void executeTasks(List<Runnable> tasks) {
        executorService = Executors.newFixedThreadPool(tasks.size());
        CompletableFuture.allOf(tasks.stream()
                .map(task -> CompletableFuture.runAsync(task, executorService))
                .toArray(CompletableFuture[]::new)).join();
        executorService.shutdown();
    }


    private void queryEqp() {
        queryEqpVo = toolQueryService.queryEqpCondition(
                QueryEqpVo.builder()
                        .siteId(wfsLoadReqBody.getSiteId())
                        .useStatCd(UseStatCd.Usable.name())
                        .eqpId(wfsLoadReqBody.getEqpId())
                        .build()
        );
    }

    private void queryPort() {
        queryPortVo = toolQueryService.queryPortCondition(
                QueryPortVo.builder()
                        .siteId(wfsLoadReqBody.getSiteId())
                        .useStatCd(UseStatCd.Usable.name())
                        .eqpId(wfsLoadReqBody.getEqpId())
                        .portId(wfsLoadReqBody.getPortId())
                        .build()
        );
    }

    private void validateStateRule(String validationType) {
        try {
            switch (validationType) {
                case StateRuleList.ValidEqp:
                    stateRuleManager.validEqp(siteId, wfsLoadReqBody.getEqpId(), queryEqpVo);
                    break;
                case StateRuleList.ValidPort:
                    stateRuleManager.validPort(siteId, wfsLoadReqBody.getEqpId(),
                            wfsLoadReqBody.getPortId(), queryPortVo);
                    break;
                case StateRuleList.FullAutoPort:
                    stateRuleManager.fullAutoPort(siteId, wfsLoadReqBody.getEqpId(),
                            wfsLoadReqBody.getPortId(), queryPortVo);
                    break;
                case StateRuleList.FullAutoEqp:
                    stateRuleManager.fullAutoEqp(siteId, wfsLoadReqBody.getEqpId(), queryEqpVo);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid validation type: " + validationType);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
