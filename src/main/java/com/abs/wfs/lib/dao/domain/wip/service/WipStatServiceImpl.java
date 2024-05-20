package com.abs.wfs.lib.dao.domain.wip.service;

import com.abs.wfs.lib.dao.domain.wip.model.WnWipStat;
import com.abs.wfs.lib.dao.domain.wip.repository.WnWipStatRepository;
import com.abs.wfs.lib.dao.domain.wip.vo.WnWipStatSaveRequestVo;
import com.abs.wfs.lib.dao.util.code.UseStatCd;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
public class WipStatServiceImpl implements WipStatService {


    @Autowired
    private WnWipStatRepository wnWipStatRepository;




    public Optional<WnWipStat> getEntityByObjId(String objId){
        return Optional.of(this.wnWipStatRepository.findById(objId)).get();
    }

    public WnWipStat saveEntity(WnWipStatSaveRequestVo wnWipStatSaveRequestVo){
        log.info(wnWipStatSaveRequestVo.toString());
        try{
            WnWipStat entity = wnWipStatSaveRequestVo.toEntity();
            return this.wnWipStatRepository.save(entity);
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        }
    }

    public WnWipStat findByLotIdAndUseStatCdAndResvEqpIdAndResvPortId(String site, String lotId, String eqpId, String portId, UseStatCd useStatCd) {
        log.info("site:{}, LotId : {}, UseStatCd : {} , EqpId: {} , PortId : {}",site, lotId, useStatCd, eqpId, portId);
        return this.wnWipStatRepository.findByLotIdAndUseStatCdAndResvEqpPortAndEqpId(useStatCd, eqpId, portId);
    }

    public void deleteEntityByObjId(String objId){
        this.wnWipStatRepository.deleteById(objId);
    }

}
