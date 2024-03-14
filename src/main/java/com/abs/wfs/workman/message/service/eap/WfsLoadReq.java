package com.abs.wfs.workman.message.service.eap;

import com.abs.wfs.workman.message.vo.common.ApMessageResultVo;
import com.abs.wfs.workman.message.vo.receive.eap.WfsLoadReqVo;

public interface WfsLoadReq {

    void init(WfsLoadReqVo wfsLoadReqVo);
    ApMessageResultVo execute(String messageId) throws Exception;
}
