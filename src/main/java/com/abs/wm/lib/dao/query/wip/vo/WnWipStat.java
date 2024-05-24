package com.abs.wm.lib.dao.query.wip.vo;

import lombok.Data;

@Data
public class WnWipStat {

    // Table Column
    private String objId;
    private String siteId;
    private String lotId;
    private String carrId;
    private String carrLctnNm;
    private String workStatCd;
    private String dtlWorkStatCd;
    private String mdfyUserId;
    private String mdfyDt;
    private String crtUserId;
    private String crtDt;
    private String cstmEvntNm;
    private String evntNm;
    private String fnlEvntDt;
    private String prevCstmEvntNm;
    private String prevEvntNm;
    private String rsnCd;
    private String tid;
    private String trnsCm;
    private String useStatCd;
    private String crntEqpId;
    private String crntPortId;
    private String batchId;
    private String resvEqpId;
    private String resvPortId;
    private String resvOutPortId;
    private String resvOutCarrId;
    private String eqpChkYn;
    private String rcpChkYn;
    private String trackInCnfmYn;
    private String resvGrpId;
    private String batchSeq;
    private String selfInspYn;
    private String selfInspInfoObjId;
    private Integer selfInspPanelCnt;
    private String smplLotYn;
    private String smplWorkTyp;
    private Integer smplQty;

    // Where Condition
    private String pObjId;
    private String pSiteId;
    private String pLotId;
    private String pCarrId;
    private String pWorkStatCd;
    private String pDtlWorkStatCd;
    private String pUseStatCd;

}
