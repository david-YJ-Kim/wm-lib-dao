package com.abs.wfs.workman.intf.rest.query;

import com.abs.wfs.workman.query.tool.service.ToolQueryServiceImpl;
import com.abs.wfs.workman.query.tool.vo.QueryEqpVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/query")
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


}
