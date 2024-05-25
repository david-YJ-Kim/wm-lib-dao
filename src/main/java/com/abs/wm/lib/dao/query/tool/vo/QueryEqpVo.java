package com.abs.wm.lib.dao.query.tool.vo;

import lombok.*;

@NoArgsConstructor
@Data
public class QueryEqpVo {

    private String siteId;
    private String useStatCd;
    private String eqpId;
    private String eqpTyp;
    private String modelTyp;
    private String batchYn;
    private String inlineYn;
    private String eqpInlineSeq;
    private String eqpInlineId;
    private String statCd;
    private String procStatCd;
    private String ctrlModeCd;
    private String oprtnModeCd;
    private String sorterModeYn;
    private String autoDspYn;
    private String intlkYn;
    private String sorterModeAvailYn;





    @Override
    public String toString() {
        return "QueryEqpVo{" +
                "siteId='" + siteId + '\'' +
                ", useStatCd='" + useStatCd + '\'' +
                ", eqpId='" + eqpId + '\'' +
                ", eqpTyp='" + eqpTyp + '\'' +
                ", modelTyp='" + modelTyp + '\'' +
                ", batchYn='" + batchYn + '\'' +
                ", inlineYn='" + inlineYn + '\'' +
                ", eqpInlineSeq='" + eqpInlineSeq + '\'' +
                ", eqpInlineId='" + eqpInlineId + '\'' +
                ", statCd='" + statCd + '\'' +
                ", procStatCd='" + procStatCd + '\'' +
                ", ctrlModeCd='" + ctrlModeCd + '\'' +
                ", oprtnModeCd='" + oprtnModeCd + '\'' +
                ", sorterModeYn='" + sorterModeYn + '\'' +
                ", autoDspYn='" + autoDspYn + '\'' +
                ", intlkYn='" + intlkYn + '\'' +
                ", sorterModeAvailYn='" + sorterModeAvailYn + '\'' +
                '}';
    }
}
