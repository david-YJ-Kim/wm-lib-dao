package com.abs.wfs.workman.message.vo.receive.eap.common;

import lombok.Data;

@Data
public class EapWorkVo {

    String jobSeqId;
    String scanYn;
    String inPortId;
    String inCarrierId;
    String outPortId;
    String outCarrierId;

    EapSlotMapVo slotMap;
}
