package com.abs.wfs.workman.message.vo.common;

import lombok.Data;

import java.util.List;

@Data
public class ApMsgHead {

    String cid;
    String tid;
    String osrc;
    String otgt;
    String src;
    String srcEqp;
    String tgt;
    List<String> tgtEqp;
}
