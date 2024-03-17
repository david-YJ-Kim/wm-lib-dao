package com.abs.wfs.workman.message.vo.receive.rms;

import com.abs.wfs.workman.message.vo.ApMsgCommonVo;
import com.abs.wfs.workman.message.vo.common.ApMsgBody;
import lombok.Data;

@Data
public class WfsRecipeValidateRepVo extends ApMsgCommonVo {

    WfsDspWorkRepBody body;

    @Data
    public static class WfsDspWorkRepBody extends ApMsgBody{
        String dspType;
        String lotId;
        String eqpId;
        String prodDefId;
        String procDefId;
        String procSgmtId;
        RecipeList recipeList;
        String resultCode;
        String resultMessage;
    }
}
