package com.abs.wfs.workman.interfaces.rest.query;

import com.abs.wfs.workman.query.tool.service.ToolQueryServiceImpl;
import com.abs.wfs.workman.query.tool.vo.QueryEqpVo;
import com.abs.wfs.workman.query.tool.vo.QueryPortVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/tool/query")
@RequiredArgsConstructor
@Slf4j
public class QueryToolController {

    @Autowired
    private ToolQueryServiceImpl toolQueryService;

    @GetMapping("/condition/eqp")
    public QueryEqpVo queryEqpCondition(@RequestBody QueryEqpVo vo){
        log.info(vo.toString());
        return toolQueryService.queryEqpCondition(vo);
    }

    @GetMapping("/condition/port")
    public QueryPortVo queryPortCondition(@RequestBody QueryPortVo vo){
        log.info(vo.toString());
        return toolQueryService.queryPortCondition(vo);
    }

}
