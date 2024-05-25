package com.abs.wm.lib.dao.query.carr.mapper;

import com.abs.wm.lib.dao.query.carr.vo.CarrLocationVo;
import org.mapstruct.Mapper;

@Mapper
public interface CarrMapper {

    CarrLocationVo carrLocationQuery(CarrLocationVo carrLocationVo);

}
