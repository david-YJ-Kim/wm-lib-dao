package com.abs.wfs.workman.message.vo.receive.mcs;

import com.abs.wfs.workman.message.vo.ApMsgCommonVo;
import com.abs.wfs.workman.message.vo.common.ApMsgBody;
import lombok.Data;

@Data
public class WfsCarrMoveRepVo extends ApMsgCommonVo {

    WfsCarrMoveRepBody body;

    @Data
    public static class WfsCarrMoveRepBody extends ApMsgBody{
        String eventUserId;
        String eventComment;
        String carrId;
        String commId;
        String srcEqpId;
        String srcPortId;
        String destEqpId;
        String destPortId;
        String prio;
        String resultCode;
    }
}
