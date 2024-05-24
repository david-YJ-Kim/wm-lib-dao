package com.abs.wm.lib.dao.util.exception;

import lombok.Data;

@Data
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

    public ScenarioException() {super();}



}
