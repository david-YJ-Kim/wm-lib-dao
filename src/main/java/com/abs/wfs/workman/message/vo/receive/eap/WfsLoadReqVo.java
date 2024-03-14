package com.abs.wfs.workman.message.vo.receive.eap;

import com.abs.wfs.workman.message.vo.ApMsgCommonVo;
import com.abs.wfs.workman.message.vo.common.ApMsgBody;
import lombok.Data;

@Data
public class WfsLoadReqVo extends ApMsgCommonVo {

    WfsLoadReqBody body;

    @Data
    public static class WfsLoadReqBody extends ApMsgBody {
        String eqpId;
        String portId;
        String portType;
    }
}
