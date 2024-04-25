package com.abs.wfs.workman.interfaces.rest.query;

import com.abs.wfs.workman.query.lot.service.LotQueryServiceImpl;
import com.abs.wfs.workman.query.lot.vo.QueryLotVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/lot/query")
@RequiredArgsConstructor
@Slf4j
public class QueryLotController {

    @Autowired
    private LotQueryServiceImpl lotQueryService;

    @GetMapping("/condition")
    public QueryLotVo queryEqpCondition(@RequestBody QueryLotVo vo){
        log.info(vo.toString());
        return lotQueryService.queryLotCondition(vo);
    }


}
