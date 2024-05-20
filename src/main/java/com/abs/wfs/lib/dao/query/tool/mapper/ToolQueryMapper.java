package com.abs.wfs.lib.dao.query.tool.mapper;

import com.abs.wfs.lib.dao.query.tool.vo.QueryEqpVo;
import com.abs.wfs.lib.dao.query.tool.vo.QueryPortVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ToolQueryMapper {


    QueryEqpVo queryEqpCondition (QueryEqpVo vo);

    QueryPortVo queryPortCondition (QueryPortVo vo);
}
