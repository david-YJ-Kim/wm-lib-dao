package com.abs.wfs.workman.message.vo.receive.eap;

import com.abs.wfs.workman.message.vo.ApMsgCommonVo;
import com.abs.wfs.workman.message.vo.common.ApMsgBody;
import com.abs.wfs.workman.message.vo.receive.common.EqpStatusVo;
import com.abs.wfs.workman.message.vo.receive.common.MaterialListVo;
import com.abs.wfs.workman.message.vo.receive.common.MsgReasonVo;
import lombok.Data;

@Data
public class WfsToolCondRepVo extends ApMsgCommonVo {

    WfsToolCondRepBody body;

    @Data
    public static class WfsToolCondRepBody extends ApMsgBody {
        String eqpId;
        MaterialListVo materialList;
        EqpStatusVo status;
        MsgReasonVo reason;
    }




}
