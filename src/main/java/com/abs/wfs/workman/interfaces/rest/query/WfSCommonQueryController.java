package com.abs.wfs.workman.interfaces.rest.query;

import com.abs.wfs.workman.query.common.service.WfsCommonServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/query/common")
@RequiredArgsConstructor
@Slf4j
public class WfSCommonQueryController {

    @Autowired
    WfsCommonServiceImpl wfsCommonService;
}
