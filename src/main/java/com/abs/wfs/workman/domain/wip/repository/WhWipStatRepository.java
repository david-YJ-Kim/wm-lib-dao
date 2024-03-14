package com.abs.wfs.workman.domain.wip.repository;

import com.abs.wfs.workman.domain.wip.model.WhWipStat;
import com.abs.wfs.workman.domain.wip.model.WnWipStat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhWipStatRepository extends JpaRepository<WhWipStat, String> {
}
