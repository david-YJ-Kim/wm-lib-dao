package com.abs.wfs.lib.dao.query.transfer.vo;

import lombok.Data;

@Data
public class WnTransferJob {
    private String objId;
    private String siteId;
    private String jobId;
    private String carrId;
    private String crntEqpId;
    private String crntPortId;
    private String srcEqpId;
    private String srcPortId;
    private String destEqpId;
    private String destPortId;
    private String moveStatCd;
    private String prirtNo;
    private String fnlEvntNm;
    private String fnlEvntDt;
    private String mdfyUserId;
    private String mdfyDt;
    private String crtUserId;
    private String crtDt;
    private String cstmEvntNm;
    private String evntNm;
    private String prevCstmEvntNm;
    private String prevEvntNm;
    private String rsnCd;
    private String tid;
    private String trnsCm;
    private String useStatCd;

    private String pSiteId;
    private String pJobId;
    private String pCarrId;
    private String pMoveStatCd;
    private String pUseStatCd;

}
