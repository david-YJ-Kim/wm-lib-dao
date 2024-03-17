package com.abs.wfs.workman.intf.rest.query;

import com.abs.wfs.workman.query.lot.service.LotQueryService;
import com.abs.wfs.workman.query.lot.service.LotQueryServiceImpl;
import com.abs.wfs.workman.query.lot.vo.QueryLotVo;
import com.abs.wfs.workman.query.tool.service.ToolQueryServiceImpl;
import com.abs.wfs.workman.query.tool.vo.QueryEqpVo;
import com.abs.wfs.workman.query.tool.vo.QueryPortVo;
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
