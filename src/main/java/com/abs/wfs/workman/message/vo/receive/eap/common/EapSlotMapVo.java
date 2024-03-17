package com.abs.wfs.workman.message.vo.receive.eap.common;

import lombok.Data;

@Data
public class EapSlotMapVo {
    String inCarrierSlotNo;
    String outCarrierSlortNo;
    String ppid;
    String lotId;
    String prodMtrlId;
    String slotStatus;
    String mtrlFace;
    String manualInsp;
}
