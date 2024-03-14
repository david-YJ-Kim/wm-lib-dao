package com.abs.wfs.workman.message.util;

import com.abs.wfs.workman.util.code.WorkManScenarioList;

public class WorkManCommonUtil {


    /**
     * EQP ID로 설정된 시나리오 타입 획득
     * @param eqpId
     * @return
     */
    public static String getScenarioType(String eqpId){

        // find scenario Type with eqpId
        return WorkManScenarioList.BP_SINGLE;
    }
}
