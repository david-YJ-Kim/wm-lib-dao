package com.abs.wfs.workman.query.lot.mapper;

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

/**
 * WfsMapper.java in BW util
 */
@Mapper
public interface LotQueryMapper {

    QueryLotVo queryLotCondition(QueryLotVo vo);

    List<TnPosProducedMaterial> selectTnPosProducedMaterialByLotId(String lotId);

    int updateTnPosCarrierMoveStatCd(TnPosCarrier tnPosCarrier);

    int insertThPosCarrier(String objId);


    Map<String, String> selectLot(Map<String, String> map);

    QueryLotVo selectQueryLotVo(Map<String, String> map);

    Map<String, String> selectCarrier(Map<String, String> map);

    int insertWnMtrlUsageInfo(WnMtrlUsageInfo wnMtrlUsageInfo);

    int insertWhMtrlUsageInfo(String objId);

    int insertWhErrorInfo(WhErrorInfo wnErrorInfo);

    List<Map<String,String>> selectBatchLotList(Map<String, String> map);

    Map<String,String> selectEcoLotInfo(Map<String, String> map);

    List<Map<String,String>> selectProdMtrlList(Map<String, String> map);
}
