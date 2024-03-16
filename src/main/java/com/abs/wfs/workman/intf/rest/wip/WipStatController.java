package com.abs.wfs.workman.intf.rest.wip;


import com.abs.wfs.workman.domain.wip.model.WnWipStat;
import com.abs.wfs.workman.domain.wip.service.WipStatServiceImpl;
import com.abs.wfs.workman.domain.wip.vo.WnWipStatSaveRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/wip")
@RequiredArgsConstructor
public class WipStatController {

    @Autowired
    private WipStatServiceImpl wipStatService;

    @GetMapping("/{objId}")
    public Optional<WnWipStat> getWipStat(@PathVariable String objId) {
        return wipStatService.getEntityByObjId(objId);
    }

    @PostMapping("/save")
    public WnWipStat saveWipStat(@RequestBody WnWipStatSaveRequestVo wnWipStatSaveRequestVo) {
        return wipStatService.saveEntity(wnWipStatSaveRequestVo);
    }

    @DeleteMapping("/{objId}")
    public void deleteWipStat(@PathVariable String objId) {
        wipStatService.deleteEntityByObjId(objId);
    }
}