package com.abs.wfs.workman.message.vo.receive.eap;

import com.abs.wfs.workman.message.vo.ApMsgCommonVo;
import com.abs.wfs.workman.message.vo.common.ApMsgBody;
import lombok.Data;

@Data
public class WfsCarrSlotmapReportReqVo extends ApMsgCommonVo {

    WfsCarrSlotmapReportReqBody body;

    @Data
    public static class WfsCarrSlotmapReportReqBody extends ApMsgBody {
        String eqpId;
        String portId;
        String portType;
        String carrId;
        String slotMap;
    }


    public static String getMessageSampleFormat(String eppId, String portId, String portType){
        return "";
    }


}
