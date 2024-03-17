package com.abs.wfs.workman.intf.rest.message.standby;


import com.abs.wfs.workman.message.service.eap.impl.WfsLoadReqImpl;
import com.abs.wfs.workman.message.vo.common.ApMessageResultVo;
import com.abs.wfs.workman.message.vo.receive.eap.WfsLoadReqVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/message/standby")
@RequiredArgsConstructor
public class StandbyMessageController {

    @Autowired
    WfsLoadReqImpl wfsLoadReqService;


    @PostMapping("/wfLoadReq")
    public ApMessageResultVo executeWfsLoadReq(@RequestBody WfsLoadReqVo wfsLoadReqVo) throws Exception {

        String messageId = Thread.currentThread().getName() + "_" + System.currentTimeMillis();
        this.wfsLoadReqService.init("WFS_LOAD_REQ", wfsLoadReqVo);
        ApMessageResultVo apMessageResultVo = this.wfsLoadReqService.execute(messageId);
        log.info(apMessageResultVo.toString());
        return apMessageResultVo;
    }

}