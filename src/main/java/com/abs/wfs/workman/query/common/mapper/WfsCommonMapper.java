package com.abs.wfs.workman.query.common.mapper;

import com.abs.wfs.workman.domain.staterule.model.WnStateRuleInfo;
import com.abs.wfs.workman.domain.staterule.service.StateRuleInfoService;
import com.abs.wfs.workman.query.common.vo.TnPosCarrier;
import com.abs.wfs.workman.query.common.vo.TnPosProducedMaterial;
import com.abs.wfs.workman.query.common.vo.WhErrorInfo;
import com.abs.wfs.workman.query.common.vo.WnMtrlUsageInfo;
import com.abs.wfs.workman.query.lot.vo.QueryLotVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface WfsCommonMapper {

    // ID Generator
    String getID(String name);


}
