package com.abs.wfs.workman.query.tool.service;

import com.abs.wfs.workman.query.tool.mapper.ToolQueryMapper;
import com.abs.wfs.workman.query.tool.vo.QueryEqpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolQueryServiceImpl implements ToolQueryService{

    @Autowired
    ToolQueryMapper toolQueryMapper;


    public QueryEqpVo queryEqpCondition(QueryEqpVo vo) {

        return toolQueryMapper.queryEqpCondition(vo);
    }
}
