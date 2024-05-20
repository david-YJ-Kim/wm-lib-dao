package com.abs.wfs.lib.dao.query.eqp.vo;

import lombok.Data;

@Data
public class TnPosPort {
    private String objId;
    private String siteId;
    private String eqpId;
    private String portId;
    private String acesModeCd;
    private String statCd;
    private String prevStatCd;
    private String trsfStatCd;
    private String carrId;
    private String evntNm;
    private String prevEvntNm;
    private String cstmEvntNm;
    private String prevCstmEvntNm;
    private String useStatCd;
    private String rsnCd;
    private String trnsCm;
    private String crtUserId;
    private String crtDt;
    private String mdfyUserId;
    private String mdfyDt;
    private String fnlEvntDt;
    private String tid;
    private String ctrlModeCd;

    private String pSiteId;
    private String pEqpId;
    private String pPortId;
    private String pUseStatCd;
}
