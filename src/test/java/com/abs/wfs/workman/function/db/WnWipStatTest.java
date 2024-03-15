package com.abs.wfs.workman.function.db;

import com.abs.wfs.workman.domain.wip.model.WnWipStat;
import com.abs.wfs.workman.domain.wip.service.WipStatServiceImpl;
import com.abs.wfs.workman.domain.wip.vo.WnWipStatSaveRequestVo;
import com.abs.wfs.workman.util.code.UseYn;
import com.abs.wfs.workman.util.code.WorkStatCd;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
public class WnWipStatTest {


    @Autowired
    private WipStatServiceImpl wipStatService;


    @Test
    public void saveEntity(){
        String siteId = "SVM";
        String lotId = "S23C00010";
        String carrId = "-";
        String workStatCd = "Ready";
        String cstmEvntNm ="CreateWipStat";
        String evntNm ="CreateWipStat";
        String tid = "170982423839786399";
        String useStatCd = "Usable";
        String crntEqpId = "AP-LA-03-01";
        String crntPortId = "AP-LA-03-01-BP01";
        String crtUserId = "WFS";
        Timestamp crtDt = new Timestamp(System.currentTimeMillis());
        Timestamp mdfyDt = new Timestamp(System.currentTimeMillis());
        Timestamp fnlEvntDt = new Timestamp(System.currentTimeMillis());

        WnWipStatSaveRequestVo vo = WnWipStatSaveRequestVo.builder()
                .siteId(siteId)
                .lotId(lotId)
                .carrId(carrId)
                .workStatCd(workStatCd)
                .cstmEvntNm(cstmEvntNm)
                .evntNm(evntNm)
                .tid(tid)
                .useStatCd(useStatCd)
                .crntEqpId(crntEqpId)
                .crntPortId(crntPortId)
                .crtUserId(crtUserId)
                .crtDt(crtDt)
                .mdfyDt(mdfyDt)
                .fnlEvntDt(fnlEvntDt)
                .build();

        log.info(vo.toString());

        WnWipStat savedEntity = this.wipStatService.saveEntity(vo);
        String objId = savedEntity.getObjId();

        WnWipStat searchedEntity = this.wipStatService.getEntityByObjId(objId).get();


        // 저장된 값 비교
        assertEquals(searchedEntity.getLotId(), lotId);
        assertEquals(searchedEntity.getCarrId(), carrId);
        assertEquals(searchedEntity.getWorkStatCd(), WorkStatCd.valueOf(workStatCd));
    }
}
