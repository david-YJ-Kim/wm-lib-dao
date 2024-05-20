package com.abs.wfs.lib.dao.query.work.service;

import com.abs.wfs.lib.dao.query.wip.mapper.WipStatMapper;
import com.abs.wfs.lib.dao.query.work.mapper.WorkMapper;
import com.abs.wfs.lib.dao.query.work.vo.WnWorkStat;
import com.abs.wfs.lib.dao.util.code.UseStatCd;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class WorkService {

    @Autowired
    WorkMapper workMapper;

    @Autowired
    WipStatMapper wipStatMapper;



    /**
     * UPDATE WN_WORK_STAT
     * @param siteId
     * @param cid
     * @param tid
     * @param workId
     * @param userId
     * @param inlineStatCd
     * @return
     */
    public int updateWorkStat(String siteId, String cid, String tid, String workId, String userId, String inlineStatCd) throws Exception{


        int resultCnt = -1;

        try {
            WnWorkStat param = new WnWorkStat();
            //SET
            param.setEvntNm(cid);
            param.setMdfyUserId(userId);
            param.setTid(tid);
            if(!"".equals(inlineStatCd)) param.setInlineStatCd(inlineStatCd);


            //WHERE
            param.setUseStatCd(UseStatCd.Usable.name());
            param.setSiteId(siteId);
            param.setWorkId(workId);


            //update WN_WORK_STAT
            resultCnt = this.workMapper.updateWnWorkStat(param);

            if(resultCnt > 0) {
                // insert WH_WORK_STAT
                this.workMapper.createWhWorkStat(param.getObjId());
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {

        }

        return resultCnt;
    }


    /**
     * SELECT WN_WORK_STAT By LOT_ID
     * @param siteId
     * @param workId
     * @return
     */
    public List<WnWorkStat> getWorkStatByWorkId(String siteId, String workId) throws Exception{


        List<WnWorkStat> wnWorkStatList = null;

        try {
            WnWorkStat param = new WnWorkStat();
            param.setUseStatCd(UseStatCd.Usable.name());
            param.setSiteId(siteId);
            param.setWorkId(workId);

            wnWorkStatList = this.workMapper.selectWnWorkStat(param);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }

        return wnWorkStatList;
    }

}
