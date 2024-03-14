package com.abs.wfs.workman.message.service.eap.impl;

import com.abs.wfs.workman.message.WorkManMessageList;
import com.abs.wfs.workman.util.code.WorkManScenarioList;
import com.abs.wfs.workman.message.service.eap.WfsLoadReq;
import com.abs.wfs.workman.message.util.WorkManCommonUtil;
import com.abs.wfs.workman.message.vo.common.ApMessageResultVo;
import com.abs.wfs.workman.message.vo.receive.eap.WfsLoadReqVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WFsLoadReqImpl implements WfsLoadReq {

    private WfsLoadReqVo.WfsLoadReqBody wfsLoadReqBody;
    private long executeStartTime;

    @Override
    public void init(WfsLoadReqVo wfsLoadReqVo) {
        this.executeStartTime = System.currentTimeMillis();
        this.wfsLoadReqBody = wfsLoadReqVo.getBody();
    }

    @Override
    public ApMessageResultVo execute(String messageId) throws Exception {

        // TODO Get Data from query service

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
