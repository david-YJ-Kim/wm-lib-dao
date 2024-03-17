package com.abs.wfs.workman.message.vo.receive.brs;

import com.abs.wfs.workman.message.vo.ApMsgCommonVo;
import com.abs.wfs.workman.message.vo.common.ApMsgBody;
import lombok.Data;

@Data
public class WfsLotTrackInCnfmRepVo extends ApMsgCommonVo {

    WfsLotTrackInCnfmRepBody body;

    @Data
    public static class WfsLotTrackInCnfmRepBody extends ApMsgBody {
        String lotId;
        String eqpId;
        String portId;
        String carrId;
        String selfInspYn;
        String selfInspPanelCnt;
        String selfInspMasterInfoObjId;
        String smplLotYn;
        String smplWorkTyp;
        String smplQty;
        String precedeYn;
        String resultCode;
        String resultComment;
    }


    public static String getMessageSampleFormat(String eppId, String portId, String portType){
        return "";
    }


}
