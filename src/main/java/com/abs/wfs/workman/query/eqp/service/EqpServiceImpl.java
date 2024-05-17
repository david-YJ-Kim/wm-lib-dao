package com.abs.wfs.workman.query.eqp.service;

import com.abs.wfs.workman.query.eqp.mapper.EqpMapper;
import com.abs.wfs.workman.query.eqp.vo.TnPosPort;
import com.abs.wfs.workman.query.tool.vo.QueryEqpVo;
import com.abs.wfs.workman.query.tool.vo.QueryPortVo;
import com.abs.wfs.workman.util.code.UseStatCd;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class EqpServiceImpl implements EqpService{

    @Autowired
    EqpMapper eqpMapper;

    /**
     * UNLOAD_COMPLETED
     * UPDATE TN_POS_PORT
     * @param siteId
     * @param cid
     * @param tid
     * @param userId
     * @param statCd
     * @param trsfStatCd
     * @param eqpId
     * @param portId
     * @return
     * @throws Exception
     */
    public int updateUnloadComplete(String siteId, String cid, String tid, String userId, String statCd, String trsfStatCd, String eqpId, String portId) throws Exception{


        //TODO Domain 대응 대상 메소드 - 단일 테이블 작업
        int resultVal = -1;

        try {
            TnPosPort param = new TnPosPort();

            //SET
            param.setMdfyUserId(userId);
            param.setTid(tid);
            param.setEvntNm(cid);

            param.setCarrId(""); //UNLOAD_COMP clear

            if(!"".equals(statCd)) param.setStatCd(statCd);
            if(!"".equals(trsfStatCd)) param.setTrsfStatCd(trsfStatCd);

            //WHERE
            param.setPUseStatCd(UseStatCd.Usable.name());
            param.setPSiteId(siteId);
            param.setPEqpId(eqpId);
            param.setPPortId(portId);

            resultVal = eqpMapper.updateTnPosPort(param);

            if(resultVal > 0) {
                eqpMapper.createThPosPort(param.getObjId());
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {

        }

        return resultVal;

    }


    /**
     * UPDATE TN_POS_PORT
     * CARR_ID
     * @param siteId
     * @param cid
     * @param tid
     * @param userId
     * @param carrierId
     * @param eqpId
     * @param portId
     * @return
     */
    public int updatePortCarrier(String siteId, String cid, String tid, String userId, String carrierId, String eqpId, String portId) throws Exception{

        int resultVal = -1;

        try {
            TnPosPort param = new TnPosPort();

            //SET
            param.setMdfyUserId(userId);
            param.setTid(tid);
            param.setEvntNm(cid);
            param.setCarrId(carrierId);

            //WHERE
            param.setPUseStatCd(UseStatCd.Usable.name());
            param.setPSiteId(siteId);
            param.setPEqpId(eqpId);
            param.setPPortId(portId);

            resultVal = eqpMapper.updateTnPosPort(param);

            if(resultVal > 0) {
                eqpMapper.createThPosPort(param.getObjId());
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {

        }

        return resultVal;

    }

    /**
     * UPDATE TN_POS_PORT
     * STAT_CD, CARR_ID
     * @param siteId
     * @param cid
     * @param tid
     * @param userId
     * @param statCd
     * @param trsfStatCd
     * @param acesModeCd
     * @param ctrlModeCd
     * @param carrId
     * @param eqpId
     * @param portId
     * @return
     * @throws Exception
     */
    public int updatePortStatAndCarrier(String siteId, String cid, String tid, String userId, String statCd, String trsfStatCd,
                                        String acesModeCd, String ctrlModeCd, String carrId, String eqpId, String portId) throws Exception{

        int resultVal = -1;

        try {
            TnPosPort param = new TnPosPort();

            //SET
            param.setMdfyUserId(userId);
            param.setTid(tid);
            param.setEvntNm(cid);

            if(!"".equals(statCd))param.setStatCd(statCd);
            if(!"".equals(trsfStatCd)) param.setTrsfStatCd(trsfStatCd);
            if(!"".equals(acesModeCd)) param.setAcesModeCd(acesModeCd);
            if(!"".equals(ctrlModeCd)) param.setCtrlModeCd(ctrlModeCd);
            if(!"".equals(carrId)) param.setCarrId(carrId);


            //WHERE
            param.setPUseStatCd(UseStatCd.Usable.name());
            param.setPSiteId(siteId);
            param.setPEqpId(eqpId);
            param.setPPortId(portId);

            resultVal = eqpMapper.updateTnPosPort(param);

            if(resultVal > 0) {
                eqpMapper.createThPosPort(param.getObjId());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {

        }

        return resultVal;

    }

    /**
     * UPDATE TN_POS_PORT
     * @param siteId
     * @param cid
     * @param tid
     * @param userId
     * @param statCd
     * @param trsfStatCd
     * @param acesModeCd
     * @param ctrlModeCd
     * @param eqpId
     * @param portId
     * @return
     */
    public int updatePortStatCd(String siteId, String cid, String tid, String userId, String statCd, String trsfStatCd,
                                String acesModeCd, String ctrlModeCd, String eqpId, String portId) throws Exception{

        int resultVal = -1;

        try {
            TnPosPort param = new TnPosPort();

            //SET
            param.setMdfyUserId(userId);
            param.setTid(tid);
            param.setEvntNm(cid);

            if(!"".equals(statCd))param.setStatCd(statCd);
            if(!"".equals(trsfStatCd)) param.setTrsfStatCd(trsfStatCd);
            if(!"".equals(acesModeCd)) param.setAcesModeCd(acesModeCd);
            if(!"".equals(ctrlModeCd)) param.setCtrlModeCd(ctrlModeCd);


            //WHERE
            param.setPUseStatCd(UseStatCd.Usable.name());
            param.setPSiteId(siteId);
            param.setPEqpId(eqpId);
            param.setPPortId(portId);

            resultVal = eqpMapper.updateTnPosPort(param);

            if(resultVal > 0) {
                eqpMapper.createThPosPort(param.getObjId());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {

        }

        return resultVal;

    }




    public Map<String, String> getEqp(String siteId, String eqpId) throws Exception{
        Map<String, String> returnVal = null;
        try {
            Map<String, String> param = new HashMap<>();
            param.put("eqpId", eqpId);
            param.put("siteId", siteId);
            param.put("useStatCd", UseStatCd.Usable.name());

            returnVal = eqpMapper.selectEqp(param);

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
        }
        return returnVal;
    }

    public QueryEqpVo getQueryEqp(String siteId, String eqpId) throws Exception{

        QueryEqpVo result = null;

        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("eqpId", eqpId);
            param.put("siteId", siteId);
            param.put("useStatCd", UseStatCd.Usable.name());
            result = eqpMapper.selectQueryEqpVO(param);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
        }

        return result;
    }

    public Map<String, String> getPort(String siteId, String eqpId, String portId) throws Exception{
        Map<String, String> returnVal = null;
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("eqpId", eqpId);
            param.put("portId", portId);
            param.put("siteId", siteId);
            param.put("useStatCd", UseStatCd.Usable.name());

            returnVal = eqpMapper.selectPort(param);

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
        }
        return returnVal;
    }

    public QueryPortVo getQueryPort(String siteId, String eqpId, String portId) throws Exception{

        QueryPortVo result = null;

        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("eqpId", eqpId);
            param.put("portId", portId);
            param.put("siteId", siteId);
            param.put("useStatCd", UseStatCd.Usable.name());

            result = eqpMapper.selectQueryPortVO(param);

            log.info("QueryPort Result: {}", result.toString());

        } catch (Exception e) {
            log.error("Exception: {}", e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
        }
        return result;
    }

}
