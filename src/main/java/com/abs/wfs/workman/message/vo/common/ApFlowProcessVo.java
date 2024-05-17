package com.abs.wfs.workman.message.vo.common;


import com.abs.wfs.workman.message.vo.ApMsgCommonVo;
import com.abs.wfs.workman.query.lot.vo.QueryLotVo;
import com.abs.wfs.workman.query.tool.vo.QueryEqpVo;
import com.abs.wfs.workman.query.tool.vo.QueryPortVo;
import lombok.Data;

@Data
public class ApFlowProcessVo {

    private String trackingKey; // 하나의 메시지를 처리하는 데 관통하는 키 ㄱ밧
    private String eventName;

    private ApScenarioTypeCode apScenarioTypeCode;
    private ApMsgCommonVo apMsgCommonVo;

    private ApDefaultQueryVo apDefaultQueryVo;

    private long executeStartTime;
    private long executeEndTime;


}



