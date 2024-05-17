package com.abs.wfs.workman.message.vo.common;

import com.abs.wfs.workman.query.lot.vo.QueryLotVo;
import com.abs.wfs.workman.query.tool.vo.QueryEqpVo;
import com.abs.wfs.workman.query.tool.vo.QueryPortVo;
import lombok.Data;

@Data
public class ApDefaultQueryVo {

    private QueryLotVo queryLotVo;
    private QueryEqpVo queryEqpVo;
    private QueryPortVo queryPortVo;
}
