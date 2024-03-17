package com.abs.wfs.workman.message.vo.receive.eap;

import com.abs.wfs.workman.message.vo.ApMsgCommonVo;
import com.abs.wfs.workman.message.vo.common.ApMsgBody;
import com.abs.wfs.workman.message.vo.receive.common.MsgReasonVo;
import com.abs.wfs.workman.message.vo.receive.eap.common.EapWorkVo;
import lombok.Data;

@Data
public class WfsReadyToWorkVo extends ApMsgCommonVo {

    WfsWorkOrderRepBody body;

    @Data
    public static class WfsWorkOrderRepBody extends ApMsgBody {
        String eqpId;
        String workId;
        String portId;
        MsgReasonVo reason;
    }


    public static String getMessageSampleFormat(String eppId, String portId, String portType){
        return "";
    }


}
