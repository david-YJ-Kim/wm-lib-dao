package com.abs.wfs.workman.message.service.eap.impl;

import com.abs.wfs.workman.config.ApPropertyObject;
import com.abs.wfs.workman.config.ApSharedVariable;
import com.abs.wfs.workman.message.vo.ApMsgCommonVo;
import com.abs.wfs.workman.message.vo.common.ApDefaultQueryRequestVo;
import com.abs.wfs.workman.message.vo.common.ApDefaultQueryVo;
import com.abs.wfs.workman.message.vo.common.ApFlowProcessVo;
import com.abs.wfs.workman.query.tool.service.ToolQueryServiceImpl;
import com.abs.wfs.workman.query.tool.vo.QueryEqpVo;
import com.abs.wfs.workman.query.tool.vo.QueryPortVo;
import com.abs.wfs.workman.util.code.*;
import com.abs.wfs.workman.message.service.eap.WfsLoadReq;
import com.abs.wfs.workman.message.util.WorkManCommonUtil;
import com.abs.wfs.workman.message.vo.common.ApMessageResultVo;
import com.abs.wfs.workman.message.vo.receive.eap.WfsLoadReqVo;
import com.abs.wfs.workman.util.code.ApScenarioTypeCode;
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


    private static final String siteId = ApPropertyObject.getInstance().getSiteName();
    private String cid;

    private WfsLoadReqVo.WfsLoadReqBody wfsLoadReqBody;
    private long executeStartTime;



    @Override
    public ApFlowProcessVo initialize(String cid, ApScenarioTypeCode apScenarioTypeCode, ApMsgCommonVo apMsgCommonVo) {
        ApFlowProcessVo apFlowProcessVo = new ApFlowProcessVo();
        apFlowProcessVo.setEventName(cid);
        apFlowProcessVo.setApMsgCommonVo(apMsgCommonVo);
        apFlowProcessVo.setExecuteStartTime(System.currentTimeMillis());
        return apFlowProcessVo;
    }

    @Override
    public ApMessageResultVo execute(ApFlowProcessVo apFlowProcessVo) throws Exception {
        return null;
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
                switch (queryPortVo.getPortTyp()){
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

}
