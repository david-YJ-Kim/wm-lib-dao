package com.abs.wfs.workman.message.vo.receive.rtd;

import com.abs.wfs.workman.message.vo.ApMsgCommonVo;
import com.abs.wfs.workman.message.vo.common.ApMsgBody;
import lombok.Data;

@Data
public class WfsDspWorkRepVo extends ApMsgCommonVo {

    WfsDspWorkRepBody body;

    @Data
    public static class WfsDspWorkRepBody extends ApMsgBody{
        String dspType;
        String lotId;
        String eqpId;
        String portId;
        String carrId;
        String prodDefId;
        String procDefId;
        String rsltCm;
        String rsnCd;
        String evntCm;
        String evntUserId;
    }
}
