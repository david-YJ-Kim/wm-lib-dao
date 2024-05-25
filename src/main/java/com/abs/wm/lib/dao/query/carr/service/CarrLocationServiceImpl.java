package com.abs.wm.lib.dao.query.carr.service;

import com.abs.wm.lib.dao.query.carr.mapper.CarrMapper;
import com.abs.wm.lib.dao.query.carr.vo.CarrLocationVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CarrLocationServiceImpl {

    @Autowired
    CarrMapper carrMapper;


    public CarrLocationVo carrLocationQuery(CarrLocationVo carrLocationVo){
        return this.carrMapper.carrLocationQuery(carrLocationVo);
    }

}
