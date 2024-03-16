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

    public void deleteEntityByObjId(String objId){
        this.wnWipStatRepository.deleteById(objId);
    }
}
