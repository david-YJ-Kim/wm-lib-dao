package com.abs.wm.lib.dao.query.tool.mapper;

import com.abs.wm.lib.dao.query.eqp.vo.TnPosEqp;
import com.abs.wm.lib.dao.query.eqp.vo.TnPosPort;
import com.abs.wm.lib.dao.query.tool.vo.QueryEqpVo;
import com.abs.wm.lib.dao.query.tool.vo.QueryPortVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

// TODO EQP Mapper 로 통합


@Deprecated
@Mapper
public interface ToolQueryMapper {


    QueryEqpVo queryEqpCondition (QueryEqpVo vo);

    QueryPortVo queryPortCondition (QueryPortVo vo);

    int updateTnPosPort(TnPosPort tnPosPort);

    int createThPosPort(String objId);

    int updateTnPosEqp(TnPosEqp tnPosEqp);

    int createThPosEqp(String objId);

    Map<String, String> selectEqp(Map<String, String> map);
    Map<String, String> selectPort(Map<String, String> map);

}
