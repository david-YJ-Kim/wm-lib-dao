package com.abs.wfs.workman.intf.rest.domain.staterule;


import com.abs.wfs.workman.domain.staterule.model.WnStateRuleInfo;
import com.abs.wfs.workman.domain.staterule.service.StateRuleInfoServiceImpl;
import com.abs.wfs.workman.domain.staterule.vo.WnStateRuleInfoRequestVo;
import com.abs.wfs.workman.util.code.UseStatCd;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/staterule")
@RequiredArgsConstructor
public class WnStateRuleInfoController {

    @Autowired
    private StateRuleInfoServiceImpl stateRuleInfoService;

    @GetMapping("/{objId}")
    public Optional<WnStateRuleInfo> getWnStateRule(@PathVariable String objId) {
        return stateRuleInfoService.getEntityByObjId(objId);
    }

    @GetMapping("/all")
    public List<WnStateRuleInfo> getAllWnStateRule(){
        return stateRuleInfoService.getAllEntities();
    }

    @GetMapping("/all/filter")
    public List<WnStateRuleInfo> findBySiteIdAndUseStatCd(@RequestParam String siteId, @RequestParam String useStatCd){
        return stateRuleInfoService.findBySiteIdAndUseStatCd(siteId, UseStatCd.valueOf(useStatCd));
    }


    @PostMapping("/save")
    public WnStateRuleInfo saveWnStateRule(@RequestBody WnStateRuleInfoRequestVo wnStateRuleInfoRequestVo) {
        return stateRuleInfoService.saveEntity(wnStateRuleInfoRequestVo);
    }

    @DeleteMapping("/{objId}")
    public void deleteWnStateRule(@PathVariable String objId) {
        stateRuleInfoService.deleteEntityByObjId(objId);
    }
}