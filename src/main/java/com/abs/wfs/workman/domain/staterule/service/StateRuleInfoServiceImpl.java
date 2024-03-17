package com.abs.wfs.workman.domain.staterule.service;

import com.abs.wfs.workman.domain.staterule.model.WnStateRuleInfo;
import com.abs.wfs.workman.domain.staterule.repository.WnStateRuleInfoRepository;
import com.abs.wfs.workman.domain.staterule.vo.WnStateRuleInfoRequestVo;
import com.abs.wfs.workman.util.code.UseStatCd;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StateRuleInfoServiceImpl {

    @Autowired
    private WnStateRuleInfoRepository wnStateRuleInfoRepository;

    public Optional<WnStateRuleInfo> getEntityByObjId(String objId){
        return Optional.of(this.wnStateRuleInfoRepository.findById(objId)).get();
    }

    public List<WnStateRuleInfo> findBySiteIdAndUseStatCd(String site, UseStatCd useStatCd){
        return this.wnStateRuleInfoRepository.findBySiteIdAndUseStatCd(site, useStatCd);
    }

    public List<WnStateRuleInfo> getAllEntities(){
        return this.wnStateRuleInfoRepository.findAll();
    }

    public WnStateRuleInfo saveEntity(WnStateRuleInfoRequestVo wnStateRuleInfoRequestVo){
        log.info(wnStateRuleInfoRequestVo.toString());
        try{
            WnStateRuleInfo entity = wnStateRuleInfoRequestVo.toEntity();
            return this.wnStateRuleInfoRepository.save(entity);
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        }
    }

    public void deleteEntityByObjId(String objId){
        this.wnStateRuleInfoRepository.deleteById(objId);
    }
}
