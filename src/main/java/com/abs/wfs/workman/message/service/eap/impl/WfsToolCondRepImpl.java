package com.abs.wfs.workman.message.service.eap.impl;

import com.abs.wfs.workman.config.ApPropertyObject;
import com.abs.wfs.workman.message.service.eap.WfsToolCondRep;
import com.abs.wfs.workman.message.vo.common.ApMessageResultVo;
import com.abs.wfs.workman.message.vo.receive.eap.WfsLoadReqVo;
import com.abs.wfs.workman.message.vo.receive.eap.WfsToolCondRepVo;
import com.abs.wfs.workman.query.tool.service.ToolQueryServiceImpl;
import com.abs.wfs.workman.query.tool.vo.QueryEqpVo;
import com.abs.wfs.workman.query.tool.vo.QueryPortVo;
import com.abs.wfs.workman.util.code.UseStatCd;
import com.abs.wfs.workman.util.service.StateRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

@Slf4j
@Service
public class WfsToolCondRepImpl implements WfsToolCondRep {

    @Autowired
    ToolQueryServiceImpl toolQueryService;

    @Autowired
    StateRuleManager stateRuleManager;

    private String cid;

    private WfsToolCondRepVo.WfsToolCondRepBody wfsToolCondRepBody;
    private long executeStartTime;

    private QueryPortVo queryPortVo;
    private QueryEqpVo queryEqpVo;

    @Override
    public void init(String cid, Object messageObj) {
        this.cid = cid;
        this.wfsToolCondRepBody = ((WfsToolCondRepVo) messageObj ).getBody();
        this.executeStartTime = System.currentTimeMillis();

    }

    @Override
    public ApMessageResultVo execute(String messageId) throws Exception {

        // query
        this.queryEqpVo = this.toolQueryService.queryEqpCondition(
                            QueryEqpVo.builder()
                                    .siteId(wfsToolCondRepBody.getSiteId())
                                    .useStatCd(UseStatCd.Usable.name())
                                    .eqpId(wfsToolCondRepBody.getEqpId())
                                    .build()
        );

        this.queryPortVo = toolQueryService.queryPortCondition(
                            QueryPortVo.builder()
                                    .siteId(wfsToolCondRepBody.getSiteId())
                                    .useStatCd(UseStatCd.Usable.name())
                                    .eqpId(wfsToolCondRepBody.getEqpId())
                                    .portId(wfsToolCondRepBody.getStatus().getInPortId())
                                    .build()
        );

        this.stateRuleManager.validEqp(wfsToolCondRepBody.getSiteId(), this.wfsToolCondRepBody.getEqpId(), queryEqpVo);
        this.stateRuleManager.autoPort(wfsToolCondRepBody.getSiteId(), this.wfsToolCondRepBody.getEqpId(),
                                        wfsToolCondRepBody.getStatus().getInPortId(), queryPortVo);


        // 1. reserve log query
        /**
         * SELECT OBJ_ID, LOT_ID, CARR_ID, WORK_STAT_CD, DTL_WORK_STAT_CD
         *   FROM WN_WIP_STAT
         *   WHERE LOT_ID <> '-' AND USE_STAT_CD = 'Usable' AND RESV_EQP_ID = ? AND RESV_PORT_ID = ?
         */

        return null;
    }

    @Override
    public void scenarioDispatch(String messageId) throws Exception {

    }
}
