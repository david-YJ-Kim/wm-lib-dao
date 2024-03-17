package com.abs.wfs.workman.message.service.rtd.impl;

import com.abs.wfs.workman.config.ApPropertyObject;
import com.abs.wfs.workman.message.service.rtd.WfsDspWorkRep;
import com.abs.wfs.workman.message.vo.common.ApMessageResultVo;
import com.abs.wfs.workman.message.vo.receive.rtd.WfsDspWorkRepVo;
import com.abs.wfs.workman.query.tool.service.ToolQueryServiceImpl;
import com.abs.wfs.workman.query.tool.vo.QueryEqpVo;
import com.abs.wfs.workman.query.tool.vo.QueryPortVo;
import com.abs.wfs.workman.util.code.UseYn;
import com.abs.wfs.workman.util.service.StateRuleManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutorService;

public class WfsDspWorkRepImpl implements WfsDspWorkRep {

    @Autowired
    ToolQueryServiceImpl toolQueryService;

    @Autowired
    StateRuleManager stateRuleManager;

    private static final String siteId = ApPropertyObject.getInstance().getSiteName();
    private String cid;

    private long executeStartTime;

    private WfsDspWorkRepVo.WfsDspWorkRepBody wfsDspWorkRepBody;

    private QueryPortVo queryPortVo;
    private QueryEqpVo queryEqpVo;

    private ExecutorService executorService;

    @Override
    public void init(String cid, Object messageObj) {
        this.cid = cid;
        this.wfsDspWorkRepBody = ((WfsDspWorkRepVo) messageObj ).getBody();
        this.executeStartTime = System.currentTimeMillis();

    }

    @Override
    public ApMessageResultVo execute(String messageId) throws Exception {


        ApMessageResultVo apMessageResultVo = ApMessageResultVo.builder()
                .cid(cid)
                .messageKey(messageId)
                .elapsedMilliSecond(System.currentTimeMillis() - executeStartTime)
                .executeSuccessYn(UseYn.Y)
                .build();
        return apMessageResultVo;
    }
}
