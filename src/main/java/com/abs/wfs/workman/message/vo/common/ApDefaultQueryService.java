package com.abs.wfs.workman.util.service;

import com.abs.wfs.workman.message.vo.common.ApDefaultQueryRequestVo;
import com.abs.wfs.workman.message.vo.common.ApDefaultQueryVo;
import com.abs.wfs.workman.query.lot.service.LotQueryService;
import com.abs.wfs.workman.query.lot.service.LotQueryServiceImpl;
import com.abs.wfs.workman.query.lot.vo.QueryLotVo;
import com.abs.wfs.workman.query.tool.service.ToolQueryService;
import com.abs.wfs.workman.query.tool.service.ToolQueryServiceImpl;
import com.abs.wfs.workman.query.tool.vo.QueryEqpVo;
import com.abs.wfs.workman.query.tool.vo.QueryPortVo;
import com.abs.wfs.workman.util.code.UseStatCd;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ApDefaultQueryService {

    @Autowired
    ToolQueryServiceImpl toolQueryService;

    @Autowired
    LotQueryServiceImpl lotQueryService;

    public ApDefaultQueryVo query(ApDefaultQueryRequestVo apDefaultQueryRequestVo){

        // 각 메시지 처리 시 마다, 동일한 쿼리 조회가 될듯.
        ApDefaultQueryVo apDefaultQueryVo = new ApDefaultQueryVo();

        // Eqp Query
        apDefaultQueryVo.setQueryEqpVo(
                (apDefaultQueryRequestVo.getEqpId() != null) ? this.toolQueryService.queryEqpCondition(
                        QueryEqpVo.builder()
                                .siteId("SVM") // TODO 메시지에 있는 siteID로 조회? or Constant로 설정?
                                .useStatCd(UseStatCd.Usable.name())
                                .eqpId(apDefaultQueryRequestVo.getEqpId())
                                .build()
                ) : null
        );

        // Eqp Query
        apDefaultQueryVo.setQueryPortVo(
                (apDefaultQueryRequestVo.getEqpId() != null) ?this. toolQueryService.queryPortCondition(
                        QueryPortVo.builder()
                                .siteId("SVM")
                                .useStatCd(UseStatCd.Usable.name())
                                .eqpId(apDefaultQueryRequestVo.getEqpId())
                                .portId(apDefaultQueryRequestVo.getPortId())
                                .build()
                ) : null
        );

        // Lot Query
        apDefaultQueryVo.setQueryLotVo(
                (apDefaultQueryRequestVo.getLotId() != null) ? this.lotQueryService.queryLotCondition(
                        QueryLotVo.builder()
                                .siteId("SVM")
                                .useStatCd(UseStatCd.Usable.name())
                                .lotId(apDefaultQueryRequestVo.getLotId())
                                .build()
                ) : null
        );

        return apDefaultQueryVo;
    }
}
