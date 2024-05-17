package com.abs.wfs.workman.message.service;

import com.abs.wfs.workman.message.vo.ApMsgCommonVo;
import com.abs.wfs.workman.message.vo.common.ApDefaultQueryRequestVo;
import com.abs.wfs.workman.message.vo.common.ApDefaultQueryVo;
import com.abs.wfs.workman.message.vo.common.ApFlowProcessVo;
import com.abs.wfs.workman.message.vo.common.ApMessageResultVo;
import com.abs.wfs.workman.util.code.ApScenarioTypeCode;
import com.abs.wfs.workman.util.code.ApStringConstant;
import com.abs.wfs.workman.util.code.WorkManScenarioList;

public interface WfsMessageService {

    ApFlowProcessVo initialize(String cid, ApScenarioTypeCode apScenarioTypeCode, ApMsgCommonVo apMsgCommonVo);

    ApMessageResultVo execute(ApFlowProcessVo apFlowProcessVo) throws Exception;


    default void dispatchScenario(ApFlowProcessVo apFlowProcessVo) {
        System.out.println("hellow");

    }
}
