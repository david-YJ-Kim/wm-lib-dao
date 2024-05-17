package com.abs.wfs.workman.message.service.eap;

import com.abs.wfs.workman.message.service.WfsMessageService;
import com.abs.wfs.workman.message.vo.common.ApFlowProcessVo;
import com.abs.wfs.workman.message.vo.receive.eap.WfsLoadReqVo;

public interface WfsLoadReq extends WfsMessageService {

    void scenarioDispatch(WfsLoadReqVo messageVo) throws Exception;
}
