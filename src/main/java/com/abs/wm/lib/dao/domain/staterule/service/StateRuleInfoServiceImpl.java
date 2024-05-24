package com.abs.wm.lib.dao.domain.staterule.service;

import com.abs.wm.lib.dao.domain.staterule.model.WnStateRuleInfo;
import com.abs.wm.lib.dao.domain.staterule.repository.WnStateRuleInfoRepository;
import com.abs.wm.lib.dao.domain.staterule.vo.WnStateRuleInfoRequestVo;
import com.abs.wm.lib.dao.util.code.UseStatCd;
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
