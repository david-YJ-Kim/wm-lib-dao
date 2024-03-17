package com.abs.wfs.workman.query.lot.service;

import com.abs.wfs.workman.query.lot.mapper.LotQueryMapper;
import com.abs.wfs.workman.query.lot.vo.QueryLotVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LotQueryServiceImpl implements LotQueryService {

    @Autowired
    LotQueryMapper lotQueryMapper;

    public QueryLotVo queryLotCondition(QueryLotVo vo) {
        return lotQueryMapper.queryLotCondition(vo);
    }
}
