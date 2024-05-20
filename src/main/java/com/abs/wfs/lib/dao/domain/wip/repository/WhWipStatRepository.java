package com.abs.wfs.lib.dao.domain.wip.repository;

import com.abs.wfs.lib.dao.domain.wip.model.WhWipStat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhWipStatRepository extends JpaRepository<WhWipStat, String> {
}
