package com.abs.wm.lib.dao.domain.staterule.repository;

import com.abs.wm.lib.dao.domain.staterule.model.WnStateRuleInfo;
import com.abs.wm.lib.dao.util.code.UseStatCd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WnStateRuleInfoRepository extends JpaRepository<WnStateRuleInfo, String> {

    List<WnStateRuleInfo> findBySiteIdAndUseStatCd(String siteId, UseStatCd useStatCd);
}
