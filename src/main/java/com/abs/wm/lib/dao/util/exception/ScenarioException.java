package com.abs.wm.lib.dao.util.exception;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

// TODO 공통 lib로 이동 필요
@Data
@Builder
public class ScenarioException  extends RuntimeException{

    String messageKey;
    String scenarioType;
    String eventName;
    String siteId;
    String workStateCode;
    String workId;
    String lotId;
    String carrId;
    String eqpId;
    String portId;
    String errorCode;
    String errorComment;

    public ScenarioException( String messageKey,  String scenarioType,String eventName,String siteId,
                              String workStateCode,String workId,String lotId,String carrId,String eqpId,String portId,
                              String errorCode,String errorComment) {
        super();
    }



}
