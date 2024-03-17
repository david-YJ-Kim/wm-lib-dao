package com.abs.wfs.workman.query.lot.mapper;

import com.abs.wfs.workman.query.lot.vo.QueryLotVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LotQueryMapper {

    QueryLotVo queryLotCondition(QueryLotVo vo);
}
