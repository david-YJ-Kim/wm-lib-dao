package com.abs.wfs.workman.message.service.eap;

import com.abs.wfs.workman.message.service.WfsMessageService;

public interface WfsLoadReq extends WfsMessageService {

    void scenarioDispatch(String messageId) throws Exception;
}
