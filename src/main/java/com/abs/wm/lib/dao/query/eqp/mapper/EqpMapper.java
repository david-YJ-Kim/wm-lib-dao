package com.abs.wm.lib.dao.query.eqp.mapper;

import com.abs.wm.lib.dao.query.eqp.vo.TnPosEqp;
import com.abs.wm.lib.dao.query.eqp.vo.TnPosPort;
import com.abs.wm.lib.dao.query.tool.vo.QueryEqpVo;
import com.abs.wm.lib.dao.query.tool.vo.QueryPortVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface EqpMapper {

    int updateTnPosPort(TnPosPort tnPosPort);

    int createThPosPort(String objId);

    int updateTnPosEqp(TnPosEqp tnPosEqp);

    int createThPosEqp(String objId);

    Map<String, String> selectEqp(Map<String, String> map);
    Map<String, String> selectPort(Map<String, String> map);

    QueryEqpVo selectQueryEqpVO(Map<String, String> map);
    QueryEqpVo selectQueryEqpVO(QueryEqpVo queryEqpVo);

    QueryPortVo selectQueryPortVO(Map<String, String> map);




}
