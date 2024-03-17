package com.abs.wfs.workman.message.vo.receive.eap;

import com.abs.wfs.workman.message.vo.ApMsgCommonVo;
import com.abs.wfs.workman.message.vo.common.ApMsgBody;
import lombok.Data;

@Data
public class WfsCarrIdReadVo extends ApMsgCommonVo {

    WfsCarrIdReadBody body;

    @Data
    public static class WfsCarrIdReadBody extends ApMsgBody {
        String eqpId;
        String portId;
        String portType;
        String carrId;
    }


    public static String getMessageSampleFormat(String eppId, String portId, String portType){
        return "";
    }


}
