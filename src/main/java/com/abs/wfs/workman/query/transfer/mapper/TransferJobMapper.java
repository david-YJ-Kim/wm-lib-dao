package com.abs.wfs.workman.query.transfer.mapper;

import com.abs.wfs.workman.query.transfer.vo.WnTransferJob;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TransferJobMapper {

    // select WN_TRANSFER_JOB Table
    List<WnTransferJob> selectWnTransferJob(WnTransferJob wnTransferJob);

    // update WN_TRANSFER_JOB Table
    int updateWnTransferJob(WnTransferJob wnTransferJob);

    // insert WN_TRANSFER_JOB Table
    int createWnTransferJob(WnTransferJob wnTransferJob);

    // insert WH_TRANSFER_JOB Table
    int createWhTransferJob(String objId);

    // delete WN_TRANSFER_JOB Table
    int deleteTransferJob(WnTransferJob wnTransferJob);
}
