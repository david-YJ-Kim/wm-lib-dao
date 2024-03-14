package com.abs.wfs.workman.domain.wip.repository;

import com.abs.wfs.workman.domain.wip.model.WnWipStat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WnWipStatRepository extends JpaRepository<WnWipStat, String> {
}
