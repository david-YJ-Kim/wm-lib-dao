package com.abs.wfs.lib.dao.domain.wip.repository;

import com.abs.wfs.lib.dao.domain.wip.model.WnWipStat;
import com.abs.wfs.lib.dao.util.code.UseStatCd;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WnWipStatRepository extends JpaRepository<WnWipStat, String> {


        @Query("SELECT w FROM WN_WIP_STAT w WHERE w.lotId = '-' AND w.useStatCd = :useStatCd AND w.resvEqpId = :eqpId AND w.resvPortId = :portId")
        WnWipStat findByLotIdAndUseStatCdAndResvEqpPortAndEqpId(@Param("useStatCd") UseStatCd useStatCd, @Param("eqpId") String eqpId, @Param("portId") String portId);

//        WnWipStat findBySiteIdAndLotIdAndResvEqpIdAndResvPortIdAndUseStatCd(String siteId, String lotId, String resvEqpId, String resvPortId, UseStatCd useStatCd);

//        List<WnWipStat> findBySiteIdAndLotIdAndUseStatCdAndResvEqpIdAndResvPortId(
//                String siteId,
//                String lotId,
//                UseStatCd useStatCd,
//                String resvEqpId,
//                String resvPortId
//        );

}
