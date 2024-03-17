package com.abs.wfs.workman.message.service;

import com.abs.wfs.workman.message.vo.common.ApMessageResultVo;

public interface WfsMessageService {

    void init(String cid, Object messageObj);
//    void init(String cid, WfsLoadReqVo wfsLoadReqVo);
    ApMessageResultVo execute(String messageId) throws Exception;
}
