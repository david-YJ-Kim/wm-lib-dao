package com.abs.wfs.workman.domain.wip.service;

import com.abs.wfs.workman.domain.wip.model.WnWipStat;
import com.abs.wfs.workman.domain.wip.repository.WhWipStatRepository;
import com.abs.wfs.workman.domain.wip.repository.WnWipStatRepository;
import com.abs.wfs.workman.domain.wip.vo.WnWipStatSaveRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class WipStatServiceImpl implements WipStatService {


    @Autowired
    private WnWipStatRepository wnWipStatRepository;


    @Autowired
    private WhWipStatRepository whWipStatRepository;


    public WnWipStat saveEntity(WnWipStatSaveRequestVo wnWipStatSaveRequestVo){
        try{
            WnWipStat entity = wnWipStatSaveRequestVo.toEntity();
            return this.wnWipStatRepository.save(entity);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public Optional<WnWipStat> getEntityByObjId(String objId){
        return Optional.of(this.wnWipStatRepository.findById(objId)).get();
    }

    public void deleteEntityByObjId(String objId){
        this.wnWipStatRepository.deleteById(objId);
    }
}
