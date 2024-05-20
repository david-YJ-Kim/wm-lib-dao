package com.abs.wfs.lib.dao.query.work.service;

import com.abs.wfs.lib.dao.query.wip.mapper.WipStatMapper;
import com.abs.wfs.lib.dao.query.wip.service.WipStatServiceImpl;
import com.abs.wfs.lib.dao.query.work.mapper.WorkMapper;
import com.abs.wfs.lib.dao.query.work.vo.WnDspWorkInfo;
import com.abs.wfs.lib.dao.query.work.vo.WnWorkJob;
import com.abs.wfs.lib.dao.query.work.vo.WnWorkJobSlotInfo;
import com.abs.wfs.lib.dao.query.work.vo.WnWorkStat;
import com.abs.wfs.lib.dao.util.code.StatCd;
import com.abs.wfs.lib.dao.util.code.UseStatCd;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WorkServiceImpl {

    @Autowired
    WorkMapper workMapper;

    @Autowired
    WipStatMapper wipStatMapper;

    @Autowired
    WipStatServiceImpl wipStatService;



    /**
     * INSERT WN_WORK_STAT
     * @param siteId
     * @param cid
     * @param tid
     * @param userId
     * @param workId
     * @param eqpId
     * @param batchYn
     * @param inlineYn
     * @param eqpInlineId
     * @param inlineStatCd
     * @param dspWorkId
     * @return
     */
    private int createWorkStat(String siteId, String cid, String tid, String userId, String workId,
                               String eqpId, String batchYn, String inlineYn, String eqpInlineId, String inlineStatCd, String dspWorkId) throws Exception{

        int resultCnt = -1;

        try {
            WnWorkStat wnWorkStat = new WnWorkStat();
            wnWorkStat.setSiteId(siteId);
            wnWorkStat.setEvntNm(cid);
            wnWorkStat.setCrtUserId(userId);
            wnWorkStat.setMdfyUserId(userId);
            wnWorkStat.setTid(tid);
            wnWorkStat.setWorkId(workId);
            wnWorkStat.setEqpId(eqpId);
            wnWorkStat.setWorkStatCd(StatCd.Active.name());
            wnWorkStat.setUseStatCd(UseStatCd.Usable.name());
            wnWorkStat.setBatchYn(batchYn);
            wnWorkStat.setInlineYn(inlineYn);
            wnWorkStat.setEqpInlineId(eqpInlineId);
            wnWorkStat.setInlineStatCd(inlineStatCd);
            wnWorkStat.setDspWorkId(dspWorkId);

            resultCnt = workMapper.createWnWorkStat(wnWorkStat);

            if(resultCnt > 0) {
                // insert WH_WORK_STAT
                workMapper.createWhWorkStat(wnWorkStat.getObjId());
            }


        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return resultCnt;
    }




    /**
     * INSERT WN_WORK_JOB
     * @param siteId
     * @param cid
     * @param tid
     * @param workId
     * @param jobSeqId
     * @param batchId
     * @param lotId
     * @param qty
     * @param inPortId
     * @param inCarrId
     * @param inCarrTyp
     * @param outPortId
     * @param outCarrId
     * @param outCarrTyp
     * @param prodDefId
     * @param procDefId
     * @param procSgmtId
     * @param rcpDefId
     * @param rcpReadyYn
     * @param userId
     * @return
     */
    private int createWorkJob(String siteId, String cid, String tid, String workId, String jobSeqId, String batchId, String lotId, String qty,
                              String inPortId, String inCarrId, String inCarrTyp, String outPortId, String outCarrId, String outCarrTyp,
                              String prodDefId, String procDefId, String procSgmtId, String rcpDefId, String rcpReadyYn, String workFaceCd, String userId) throws Exception{


        int resultCnt = -1;

        try {
            WnWorkJob param = new WnWorkJob();
            param.setSiteId(siteId);
            param.setEvntNm(cid);
            param.setTid(tid);
            param.setMdfyUserId(userId);
            param.setCrtUserId(userId);
            param.setUseStatCd(UseStatCd.Usable.name());
            param.setWorkId(workId);
            param.setJobSeqId(jobSeqId);
            param.setBatchId(batchId);
            param.setLotId(lotId);
            param.setInPortId(inPortId);
            param.setInCarrId(inCarrId);
            param.setInCarrTyp(inCarrTyp);
            param.setOutPortId(outPortId);
            param.setOutCarrId(outCarrId);
            param.setOutCarrTyp(outCarrTyp);
            param.setJobQty(qty);
            param.setProdDefId(prodDefId);
            param.setProcDefId(procDefId);
            param.setProcSgmtId(procSgmtId);
            param.setRcpDefId(rcpDefId);
            param.setRcpReadyYn(rcpReadyYn);
            param.setMdfyUserId(userId);
            param.setCrtUserId(userId);
            param.setJobStatCd(StatCd.Active.name());
            param.setWorkFaceCd(workFaceCd);


//			log.info("WN_WORK_JOB @@@@@@@@@@@@@@@@@@@@@");
//			log.info(param.getSiteId());
//			log.info(param.getWorkId());
//			log.info(param.getJobSeqId());
            resultCnt = workMapper.createWnWorkJob(param);
            if(resultCnt > 0) {
                workMapper.createWhWorkJob(param.getObjId());
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }

        return resultCnt;
    }



    /**
     * INSERT WN_WORK_JOB_SLOT_INFO
     * @param siteId
     * @param cid
     * @param tid
     * @param workId
     * @param jobSeqId
     * @param lotId
     * @param slotNo
     * @param prodMtrlId
     * @param selfInspYn
     * @param mtrlFaceCd
     * @param userId
     * @return
     */
    private int createWorkJobSlotInfo(String siteId, String cid, String tid, String workId,
                                      String jobSeqId, String lotId, String slotNo, String prodMtrlId, String selfInspYn, String mtrlFaceCd, String userId) throws Exception{


        int resultCnt = -1;

        try {
            WnWorkJobSlotInfo param = new WnWorkJobSlotInfo();
            // SET
            param.setSiteId(siteId);
            param.setEvntNm(cid);
            param.setTid(tid);
            param.setCrtUserId(userId);
            param.setMdfyUserId(userId);
            param.setUseStatCd(UseStatCd.Usable.name());
            param.setWorkId(workId);
            param.setJobSeqId(jobSeqId);
            param.setLotId(lotId);
            param.setSlotNo(slotNo);
            param.setProdMtrlId(prodMtrlId);
            param.setSelfInspYn(selfInspYn);
            param.setMtrlFaceCd(mtrlFaceCd);



//			log.info("WN_WORK_JOB_SLOT_INFO @@@@@@@@@@@@@@@@@@@@@");
//			log.info(param.getSiteId());
//			log.info(param.getWorkId());
//			log.info(param.getJobSeqId());
//			log.info(param.getSlotNo());



            resultCnt = workMapper.createWnWorkJobSlotInfo(param);
            if(resultCnt > 0) {
                workMapper.createWhWorkJobSlotInfo(param.getObjId());
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }

        return resultCnt;
    }



    public int updateWnWorkJobEvent(String siteId, String cid, String tid, String userId, String workId, String jobSeqId) throws Exception{

        int resultCnt = -1;

        try {
            WnWorkJob param = new WnWorkJob();

            //SET
            param.setEvntNm(cid);
            param.setTid(tid);
            param.setMdfyUserId(userId);

            //WHERE
            param.setPSiteId(siteId);
            param.setPWorkId(workId);
            param.setPJobSeqId(jobSeqId);
            param.setPUseStatCd(UseStatCd.Usable.name());
            param.setPJobStatCd(StatCd.Active.name());

            resultCnt = workMapper.updateWnWorkJob(param);

            if(resultCnt > 0) {
                workMapper.createWhWorkJob(param.getObjId());
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
        }

        return resultCnt;
    }

    public int updateWnWorkJobSlotInfoForEndTm(String siteId, String cid, String tid, String userId,
                                               String workId, String jobSeqId, String prodMtrlId, String slotNo ) throws Exception{

        int resultCnt = -1;

        try {
            WnWorkJobSlotInfo param = new WnWorkJobSlotInfo();

            //SET
            param.setEvntNm(cid);
            param.setTid(tid);
            param.setMdfyUserId(userId);
            param.setProdMtrlEndTm("END"); //SYADATE

            //WHERE
            param.setPSiteId(siteId);
            param.setPWorkId(workId);
            param.setPJobSeqId(jobSeqId);
            param.setPProdMtrlId(prodMtrlId);
            param.setPSlotNo(slotNo);
            param.setPUseStatCd(UseStatCd.Usable.name());

            resultCnt = workMapper.updateWnWorkJobSlotInfo(param);

            if(resultCnt > 0) {
                workMapper.createWhWorkJobSlotInfo(param.getObjId());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
        }


        return resultCnt;
    }

    public int updateWnWorkJobSlotInfoForStartTm(String siteId, String cid, String tid, String userId, String workId, String jobSeqId, String prodMtrlId, String slotNo ) throws Exception{

        int resultCnt = -1;

        try {
            WnWorkJobSlotInfo param = new WnWorkJobSlotInfo();

            //SET
            param.setEvntNm(cid);
            param.setTid(tid);
            param.setMdfyUserId(userId);
            param.setProdMtrlStrtTm("STRT"); //SYADATE

            //WHERE
            param.setPSiteId(siteId);
            param.setPWorkId(workId);
            param.setPJobSeqId(jobSeqId);
            param.setPProdMtrlId(prodMtrlId);
            param.setPSlotNo(slotNo);
            param.setPUseStatCd(UseStatCd.Usable.name());

            resultCnt = workMapper.updateWnWorkJobSlotInfo(param);

            if(resultCnt > 0) {
                workMapper.createWhWorkJobSlotInfo(param.getObjId());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
        }


        return resultCnt;
    }

    public int updateWnWorkJobSlotInfoForScrap(String siteId, String cid, String tid, String userId, String workId, String jobSeqId, String prodMtrlId, String slotNo ) throws Exception{

        int resultCnt = -1;

        try {
            WnWorkJobSlotInfo param = new WnWorkJobSlotInfo();

            //SET
            param.setEvntNm(cid);
            param.setTid(tid);
            param.setMdfyUserId(userId);
            //param.setProdMtrlStrtTm("STRT"); //SYADATE

            //WHERE
            param.setPSiteId(siteId);
            param.setPWorkId(workId);
            param.setPJobSeqId(jobSeqId);
            param.setPProdMtrlId(prodMtrlId);
            param.setPSlotNo(slotNo);
            param.setPUseStatCd(UseStatCd.Usable.name());

            resultCnt = workMapper.updateWnWorkJobSlotInfo(param);

            if(resultCnt > 0) {
                workMapper.createWhWorkJobSlotInfo(param.getObjId());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
        }


        return resultCnt;
    }

    public int updateWnWorkJobSlotInfoForPanelIdScan(String siteId, String cid, String tid, String userId, String workId, String jobSeqId, String scanProdMtrlId, String slotNo ) throws Exception{

        int resultCnt = -1;

        try {
            WnWorkJobSlotInfo param = new WnWorkJobSlotInfo();

            //SET
            param.setEvntNm(cid);
            param.setTid(tid);
            param.setMdfyUserId(userId);
            param.setScanProdMtrlId(scanProdMtrlId);

            //WHERE
            param.setPSiteId(siteId);
            param.setPWorkId(workId);
            param.setPJobSeqId(jobSeqId);
//			param.setpProdMtrlId(prodMtrlId);
            param.setPSlotNo(slotNo);
            param.setPUseStatCd(UseStatCd.Usable.name());

            resultCnt = workMapper.updateWnWorkJobSlotInfo(param);

            if(resultCnt > 0) {
                workMapper.createWhWorkJobSlotInfo(param.getObjId());
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
     * Finish Work By WORK_ID
     * WORK_ENDED
     * @param siteId
     * @param cid
     * @param tid
     * @param userId
     * @param workId
     * @return
     */
    public int workEnded(String siteId, String cid, String tid, String userId, String workId) throws Exception{

        int resultCnt = -1;

        try {

            WnWorkStat workStatParam = new WnWorkStat();
            //SET
            workStatParam.setEvntNm(cid);
            workStatParam.setTid(tid);
            workStatParam.setMdfyUserId(userId);
            workStatParam.setWorkStatCd(StatCd.Finished.name());
            workStatParam.setUseStatCd(UseStatCd.UnUsable.name());

            //WHERE
            workStatParam.setPSiteId(siteId);
            workStatParam.setPWorkId(workId);
            workStatParam.setPWorkStatCd(StatCd.Active.name());
            workStatParam.setPUseStatCd(UseStatCd.Usable.name());

            // UPDATE WN_WORK_STAT
            resultCnt = workMapper.updateWnWorkStat(workStatParam);

            if(resultCnt > 0) {
                // Create History WH_WORK_STAT
                workMapper.createWhWorkStat(workStatParam.getObjId());

                // DELETE WN_WORK_STAT
                workMapper.deleteWnWorkStat(workStatParam.getObjId());

                // Select WorkJob List
                WnWorkJob workJobParam = new WnWorkJob();
                workJobParam.setPSiteId(siteId);
                workJobParam.setPWorkId(workId);
                workJobParam.setPJobStatCd(StatCd.Active.name());
                workJobParam.setPUseStatCd(UseStatCd.Usable.name());



                List<WnWorkJob> workJobList = workMapper.selectWnWorkJob(workJobParam);

                for(WnWorkJob j: workJobList) {

                    WnWorkJob workJobUpdateParam = new WnWorkJob();
                    // UPDATE WN_WORK_JOB
                    //SET
                    workJobUpdateParam.setEvntNm(cid);
                    workJobUpdateParam.setTid(tid);
                    workJobUpdateParam.setMdfyUserId(userId);
                    workJobUpdateParam.setJobStatCd(StatCd.Finished.name());
                    workJobUpdateParam.setUseStatCd(UseStatCd.UnUsable.name());

                    //WHERE
                    workJobUpdateParam.setPObjId(j.getObjId());

                    // UPDATE WN_WORK_JOB
                    int updateWorkJobCnt = workMapper.updateWnWorkJob(workJobUpdateParam);

                    if(updateWorkJobCnt > 0) {

                        // WORK_JOB ===================

                        // Create History WH_WORK_JOB
                        workMapper.createWhWorkJob(j.getObjId());

                        // DELETE WN_WORK_JOB
                        workMapper.deleteWnWorkJob(j.getObjId());

                        //SLOT_INFO ===================
                        WnWorkJobSlotInfo slotInfoParam = new WnWorkJobSlotInfo();

                        //SET
                        slotInfoParam.setEvntNm(cid);
                        slotInfoParam.setTid(tid);
                        slotInfoParam.setMdfyUserId(userId);
                        slotInfoParam.setUseStatCd(UseStatCd.UnUsable.name());
                        slotInfoParam.setJobStatCd(StatCd.Finished.name());

                        //WHERE
                        slotInfoParam.setPSiteId(siteId);
                        slotInfoParam.setPWorkId(workId);
                        slotInfoParam.setPJobSeqId(j.getJobSeqId());

                        //UPDATE WN_WORK_SLOT_INFO
                        if(workMapper.updateWnWorkJobSlotInfo(slotInfoParam) > 0) {
                            //Create History WH_WORK_SLOT_INFO
                            workMapper.createWhWorkJobSlotInfoAllSlot(slotInfoParam);

                            //DELETE WN_WORK_SLOT_INFO
                            workMapper.deleteWnWorkJobSlotInfoALLSlot(slotInfoParam);
                        }
                    }
                }
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
     * WORK_ABORTED
     * @param siteId
     * @param cid
     * @param tid
     * @param userId
     * @param workId
     * @return
     * @throws Exception
     */
    public int workAborted(String siteId, String cid, String tid, String userId, String workId) throws Exception{

        int resultCnt = -1;

        try {

            WnWorkStat workStatParam = new WnWorkStat();
            //SET
            workStatParam.setEvntNm(cid);
            workStatParam.setTid(tid);
            workStatParam.setMdfyUserId(userId);
            workStatParam.setWorkStatCd(StatCd.Aborted.name());
            workStatParam.setUseStatCd(UseStatCd.UnUsable.name());

            //WHERE
            workStatParam.setPSiteId(siteId);
            workStatParam.setPWorkId(workId);
            workStatParam.setPWorkStatCd(StatCd.Active.name());
            workStatParam.setPUseStatCd(UseStatCd.Usable.name());

            // UPDATE WN_WORK_STAT
            resultCnt = workMapper.updateWnWorkStat(workStatParam);

            if(resultCnt > 0) {
                // Create History WH_WORK_STAT
                workMapper.createWhWorkStat(workStatParam.getObjId());

                // DELETE WN_WORK_STAT
                // deleteWnWorkStat(workStatParam.getObjId());

                // Select WorkJob List
                WnWorkJob workJobParam = new WnWorkJob();
                workJobParam.setPSiteId(siteId);
                workJobParam.setPWorkId(workId);
                workJobParam.setPJobStatCd(StatCd.Active.name());
                workJobParam.setPUseStatCd(UseStatCd.Usable.name());



                List<WnWorkJob> workJobList = workMapper.selectWnWorkJob(workJobParam);

                for(WnWorkJob j: workJobList) {

                    WnWorkJob workJobUpdateParam = new WnWorkJob();
                    // UPDATE WN_WORK_JOB
                    //SET
                    workJobUpdateParam.setEvntNm(cid);
                    workJobUpdateParam.setTid(tid);
                    workJobUpdateParam.setMdfyUserId(userId);
                    workJobUpdateParam.setJobStatCd(StatCd.Aborted.name());
                    workJobUpdateParam.setUseStatCd(UseStatCd.UnUsable.name());

                    //WHERE
                    workJobUpdateParam.setPObjId(j.getObjId());

                    // UPDATE WN_WORK_JOB
                    int updateWorkJobCnt = workMapper.updateWnWorkJob(workJobUpdateParam);

                    if(updateWorkJobCnt > 0) {

                        // WORK_JOB ===================

                        // Create History WH_WORK_JOB
                        workMapper.createWhWorkJob(j.getObjId());

                        // DELETE WN_WORK_JOB
                        workMapper.deleteWnWorkJob(j.getObjId());

                        //SLOT_INFO ===================
                        WnWorkJobSlotInfo slotInfoParam = new WnWorkJobSlotInfo();

                        //SET
                        slotInfoParam.setEvntNm(cid);
                        slotInfoParam.setTid(tid);
                        slotInfoParam.setMdfyUserId(userId);
                        slotInfoParam.setUseStatCd(UseStatCd.UnUsable.name());
                        slotInfoParam.setJobStatCd(StatCd.Aborted.name());

                        //WHERE
                        slotInfoParam.setPSiteId(siteId);
                        slotInfoParam.setPWorkId(workId);
                        slotInfoParam.setPJobSeqId(j.getJobSeqId());

                        //UPDATE WN_WORK_SLOT_INFO
                        if(workMapper.updateWnWorkJobSlotInfo(slotInfoParam) > 0) {
                            //Create History WH_WORK_SLOT_INFO
                            workMapper.createWhWorkJobSlotInfoAllSlot(slotInfoParam);

                            //DELETE WN_WORK_SLOT_INFO
                            //mapper.deleteWnWorkJobSlotInfoALLSlot(slotInfoParam);
                        }
                    }
                }
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
     * WORK STARTED
     * @param siteId
     * @param cid
     * @param tid
     * @param userId
     * @param workId
     * @return
     */
    public int workStarted(String siteId, String cid, String tid, String userId, String workId) throws Exception{

        int resultCnt = -1;

        try {
            WnWorkStat workStatParam = new WnWorkStat();
            //SET
            workStatParam.setEvntNm(cid);
            workStatParam.setTid(tid);
            workStatParam.setMdfyUserId(userId);
            workStatParam.setWorkStartTm("START");	// SYSDATE


            //WHERE
            workStatParam.setPSiteId(siteId);
            workStatParam.setPWorkId(workId);
            workStatParam.setPUseStatCd(UseStatCd.Usable.name());

            // UPDATE WN_WORK_STAT
            resultCnt = workMapper.updateWnWorkStat(workStatParam);

            if(resultCnt > 0) {
                // Create History WH_WORK_STAT
                workMapper.createWhWorkStat(workStatParam.getObjId());

                // Select WorkJob List
                WnWorkJob workJobParam = new WnWorkJob();
                workJobParam.setPSiteId(siteId);
                workJobParam.setPWorkId(workId);
                workJobParam.setPJobStatCd(StatCd.Active.name());
                workJobParam.setPUseStatCd(UseStatCd.Usable.name());


                List<WnWorkJob> workJobList = workMapper.selectWnWorkJob(workJobParam);

                for(WnWorkJob j: workJobList) {
                    WnWorkJob workJobUpdateParam = new WnWorkJob();
                    // UPDATE WN_WORK_JOB
                    //SET
                    workJobUpdateParam.setEvntNm(cid);
                    workJobUpdateParam.setTid(tid);
                    workJobUpdateParam.setMdfyUserId(userId);

                    //WHERE
                    workJobUpdateParam.setPObjId(j.getObjId());

                    // UPDATE WN_WORK_JOB
                    int updateWorkJobCnt = workMapper.updateWnWorkJob(workJobUpdateParam);

                    if(updateWorkJobCnt > 0) {

                        // WORK_JOB ===================
                        // Create History WH_WORK_JOB
                        workMapper.createWhWorkJob(j.getObjId());
                    }
                }
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
     * WORK 삭제
     * @param siteId
     * @param cid
     * @param workId
     * @return
     */
    public int deleteWork(String siteId, String cid, String workId) throws Exception{


        int resultCnt = -1;
        try {
            WnWorkJob wParam = new WnWorkJob();

            wParam.setPWorkId(workId);
            List<WnWorkJob> selectWorkJobList = workMapper.selectWnWorkJob(wParam);

            for(WnWorkJob j : selectWorkJobList) {
                wipStatService.updateInitWipStat(siteId, j.getInCarrId(), cid);
            }

            //WN_WORK_STAT
            workMapper.deleteWnWorkStatByWorkId(workId);

            //WN_WORK_JOB
            workMapper.deleteWnWorkJobByWorkId(workId);

            //WN_WORK_JOB_SLOT_INFO
            workMapper.deleteWnWorkJobSlotInfoByWorkId(workId);

            //WN_WORK_JOB_CELL_INFO
            workMapper.deleteWnWorkJobCellInfoByWorkId(workId);

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
        }
        return resultCnt;
    }

    // SR INLINE / INLINE DICING
    public int createDspWorkInfo(String siteId, String cid, String tid, String userId, String dspWorkId, String eqpId, String portId, String lotId, String dspStatCd) throws Exception {

        int resultCnt = -1;
        try {

            WnDspWorkInfo param = new WnDspWorkInfo();

            param.setSiteId(siteId);
            param.setDspWorkId(dspWorkId);
            param.setEqpId(eqpId);
            param.setPortId(portId);
            param.setLotId(lotId);
            param.setDspStatCd(dspStatCd);
            param.setRcpId(eqpId);
            param.setEvntNm(cid);
            param.setTid(tid);
            param.setCrtUserId(userId);
            param.setMdfyUserId(userId);
            param.setUseStatCd(UseStatCd.Usable.name());


            if(workMapper.createWnDspWorkInfo(param) > 0)
                workMapper.createWhDspWorkInfo(param.getObjId());


        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
        }
        return resultCnt;

    }

    public int updateDspWorkInfo(String siteId, String cid, String tid, String userId, String dspWorkId, String dspStatCd, String rcpChkYn, String rcpId, String trackInCnfmYn, String eqpChkYn) throws Exception {

        int resultCnt = -1;
        try {

            WnDspWorkInfo param = new WnDspWorkInfo();


            param.setRcpChkYn(dspStatCd);
            param.setRcpId(rcpId);


            param.setEvntNm(cid);
            param.setMdfyUserId(userId);


            param.setPSiteId(siteId);
            param.setPDspWorkId(dspWorkId);


            if(workMapper.createWnDspWorkInfo(param) > 0)
                workMapper.createWhDspWorkInfo(param.getObjId());

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
        }
        return resultCnt;
    }


    public int deleteDspWorkInfo(String siteId, String cid, String dspWorkId) throws Exception {


        int resultCnt = -1;
        try {

            WnDspWorkInfo param = new WnDspWorkInfo();
            //WHERE
            param.setPSiteId(siteId);
            param.setPDspWorkId(dspWorkId);

            List<WnDspWorkInfo> wnDspWorkInfo = workMapper.selectWnDspWorkInfo(param);

            for(WnDspWorkInfo w : wnDspWorkInfo) {

                WnDspWorkInfo setParam = new WnDspWorkInfo();
                //SET
                setParam.setEvntNm(cid);

                //WHERE
                setParam.setPSiteId(siteId);
                setParam.setPObjId(w.getObjId());
                setParam.setPDspWorkId(dspWorkId);

                //Update & Insert History
                if( workMapper.updateWnDspWorkInfo(setParam) > 0) {
                    log.info(setParam.getObjId());
                    resultCnt ++;
                    workMapper.deleteWnDspWorkInfo(setParam.getObjId());
                }

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
