package com.abs.wm.lib.dao.query.lot.service;

import com.abs.wm.lib.dao.query.common.vo.TnPosCarrier;
import com.abs.wm.lib.dao.query.common.vo.WhErrorInfo;
import com.abs.wm.lib.dao.query.common.vo.WnMtrlUsageInfo;
import com.abs.wm.lib.dao.query.lot.mapper.LotQueryMapper;
import com.abs.wm.lib.dao.query.lot.vo.QueryLotVo;
import com.abs.wm.lib.dao.util.code.UseStatCd;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class LotQueryServiceImpl implements LotQueryService {

    @Autowired
    LotQueryMapper lotQueryMapper;

    public QueryLotVo queryLotCondition(QueryLotVo vo) {
        return lotQueryMapper.queryLotCondition(vo);
    }


    /**
     * TN_POS_CARRIER MOVE_STAT_CD Update
     * @param siteId
     * @param cid
     * @param tid
     * @param userId
     * @param carrId
     * @param moveStatCd
     * @return
     */
    public int updateCarrierMoveStatCd(String siteId, String cid, String tid, String userId, String carrId, String moveStatCd) throws Exception{
        int resultVal = -1;

        try {
            TnPosCarrier param = new TnPosCarrier();

            // SET
            param.setMdfyUserId(userId);
            param.setMoveStatCd(moveStatCd);
            param.setEvntNm(cid);
            param.setTid(tid);

            param.setSiteId(siteId);
            param.setUseStatCd(UseStatCd.Usable.name());
            param.setCarrId(carrId);

            resultVal = lotQueryMapper.updateTnPosCarrierMoveStatCd(param);

            if(resultVal > 0) {
                lotQueryMapper.insertThPosCarrier(param.getObjId());
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
        }

        return resultVal;
    }


    public Map<String, String> getLotInfo(String siteId, String lotId) throws Exception{
        Map<String, String> returnVal = null;

        try {
            Map<String, String> param = new HashMap<>();
            param.put("lotId", lotId);
            param.put("siteId", siteId);
            param.put("useStatCd", UseStatCd.Usable.name());

            returnVal = lotQueryMapper.selectLot(param);

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
        }
        return returnVal;
    }

    public QueryLotVo getQueryLot(String siteId, String lotId) throws Exception{

        QueryLotVo result = null;

        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("lotId", lotId);
            param.put("siteId", siteId);
            param.put("useStatCd", UseStatCd.Usable.name());

            result = lotQueryMapper.selectQueryLotVo(param);

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
        }
        return result;
    }

    public Map<String, String> getLotInfoByCarr(String siteId, String carrId) throws Exception{
        Map<String, String> returnVal = null;

        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("carrId", carrId);
            param.put("siteId", siteId);
            param.put("useStatCd", UseStatCd.Usable.name());

            returnVal = lotQueryMapper.selectLot(param);

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
        }
        return returnVal;
    }

    public Map<String, String> getCarrierInfo(String siteId, String carrId) throws Exception{
        Map<String, String> returnVal = null;

        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("carrId", carrId);
            param.put("siteId", siteId);
            param.put("useStatCd", UseStatCd.Usable.name());

            returnVal = lotQueryMapper.selectCarrier(param);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
        }
        return returnVal;

    }

    /**
     * insert WN_MTRL_USAGE_INFO
     * @param siteId
     * @param workId
     * @param eqpId
     * @param subEqpId
     * @param lotId
     * @param specId
     * @param specTyp
     * @param specUseCnt
     * @param specLimitCnt
     * @param cid
     * @param userId
     * @param tid
     * @return
     */
    public int insertWnMtrlUsageInfo(String siteId, String workId, String eqpId, String subEqpId, String lotId, String specId, String specTyp,
                                     String specUseCnt, String specLimitCnt, String cid, String userId, String tid) throws Exception{
        int resultVal = -1;

        try {
            WnMtrlUsageInfo param = new WnMtrlUsageInfo();
            param.setSiteId(siteId);
            param.setWorkId(workId);
            param.setEqpId(eqpId);
            param.setSubEqpId(subEqpId);
            param.setLotId(lotId);
            param.setSpecId(specId);
            param.setSpecTyp(specTyp);
            param.setSpecUseCnt(Double.valueOf(specUseCnt));
            param.setSpecLimitCnt(specLimitCnt);
            param.setEvntNm(cid);
            param.setPrevEvntNm("");
            param.setCstmEvntNm("");
            param.setPrevCstmEvntNm("");
            param.setRsnCd("");
            param.setTrnsCm("");
            param.setCrtUserId(userId);
            param.setMdfyUserId(userId);
            param.setUseStatCd("Usable");
            param.setTid(tid);

            resultVal = lotQueryMapper.insertWnMtrlUsageInfo(param);

            if(resultVal > 0) {
                lotQueryMapper.insertWhMtrlUsageInfo(param.getObjId());
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
     * insert WN_MTRL_USAGE_INFO
     * @param siteId
     * @param workId
     * @param eqpId
     * @param subEqpId
     * @param lotId
     * @param specId
     * @param specTyp
     * @param specUseCnt
     * @param specLimitCnt
     * @param cid
     * @param userId
     * @param tid
     * @return
     * @throws Exception
     */
    public int insertWnMtrlUsageInfoDicing(String siteId, String workId, String eqpId, String subEqpId, String lotId, String specId, String specTyp,
                                           String specUseCnt, String subSpecUseCnt, String specLimitCnt, String cid, String userId, String tid) throws Exception{
        int resultVal = -1;

        try {
            String[] useCntList = specUseCnt.split(",");
            String[] subSpecUseCntList = subSpecUseCnt.split(",");
            int posnId = 1;
            for(int i = 0 ; i < useCntList.length; i++) {
                WnMtrlUsageInfo param = new WnMtrlUsageInfo();
                param.setSiteId(siteId);
                param.setWorkId(workId);
                param.setEqpId(eqpId);
                param.setSubEqpId(subEqpId);
                param.setLotId(lotId);
                param.setSpecId(specId + "-" + String.valueOf(posnId));
                param.setSpecTyp(specTyp);
                param.setPosnId(String.valueOf(posnId));
                param.setSpecUseCnt(Double.valueOf(useCntList[i]));
                param.setSubSpecUseCnt(Double.valueOf(subSpecUseCntList[i]));
                param.setSpecLimitCnt(specLimitCnt);
                param.setEvntNm(cid);
                param.setPrevEvntNm("");
                param.setCstmEvntNm("");
                param.setPrevCstmEvntNm("");
                param.setRsnCd("");
                param.setTrnsCm("");
                param.setCrtUserId(userId);
                param.setMdfyUserId(userId);
                param.setUseStatCd("Usable");
                param.setTid(tid);

                resultVal = lotQueryMapper.insertWnMtrlUsageInfo(param);
                if(resultVal > 0) {
                    lotQueryMapper.insertWhMtrlUsageInfo(param.getObjId());
                }

                posnId++;
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
     * insert WH_ERROR_INFO
     * @param siteId
     * @param msgId
     * @param msgCtnsCm
     * @param workStatCd
     * @param lotId
     * @param carrId
     * @param eqpId
     * @param portId
     * @param errCd
     * @param errCm
     * @param cid
     * @param userId
     * @param tid
     * @return
     */
    public int insertWhErrorInfo(String siteId, String msgId, String msgCtnsCm, String workStatCd, String lotId, String carrId,
                                 String eqpId, String portId, String errCd, String errCm, String cid, String userId, String tid) throws Exception{
        int resultVal = -1;

        try {
            WhErrorInfo whErrorInfo = new WhErrorInfo();

            whErrorInfo.setSiteId(siteId);
            whErrorInfo.setMsgId(msgId);
            whErrorInfo.setMsgCtntsCm(msgCtnsCm);
            whErrorInfo.setWorkStatCd(workStatCd);
            whErrorInfo.setLotId(lotId);
            whErrorInfo.setCarrId(carrId);
            whErrorInfo.setEqpId(eqpId);
            whErrorInfo.setPortId(portId);
            whErrorInfo.setErrCd(errCd);
            whErrorInfo.setErrCm(errCm);
            whErrorInfo.setCrtUserId(userId);
            whErrorInfo.setMdfyUserId(userId);
            whErrorInfo.setEvntNm(cid);
            whErrorInfo.setTid(tid);

            resultVal = lotQueryMapper.insertWhErrorInfo(whErrorInfo);

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {

        }

        return resultVal;
    }

}
