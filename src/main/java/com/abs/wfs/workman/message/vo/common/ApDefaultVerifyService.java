package com.abs.wfs.workman.util.service;

import com.abs.wfs.workman.message.vo.common.ApFlowProcessVo;
import com.abs.wfs.workman.util.code.StateRuleList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Slf4j
public class ApDefaultVerifyService {

    @Autowired
    StateRuleManager stateRuleManager;

    public void verify(ApFlowProcessVo apFlowProcessVo){

    }

    private void executeValidationTasks() {
        List<Runnable> validateTasks = Arrays.asList(
                () -> validateStateRule(StateRuleList.ValidEqp),
                () -> validateStateRule(StateRuleList.ValidPort),
                () -> validateStateRule(StateRuleList.FullAutoPort),
                () -> validateStateRule(StateRuleList.FullAutoEqp)
        );
        executeTasks(validateTasks);
    }


    private void executeTasks(List<Runnable> tasks) {
        ExecutorService executorService = Executors.newFixedThreadPool(tasks.size());
        CompletableFuture.allOf(tasks.stream()
                .map(task -> CompletableFuture.runAsync(task, executorService))
                .toArray(CompletableFuture[]::new)).join();
        executorService.shutdown();
    }



    private void validateStateRule(String validationType) {
        try {
            switch (validationType) {
                case StateRuleList.ValidEqp:
                    stateRuleManager.validEqp(siteId, wfsLoadReqBody.getEqpId(), queryEqpVo);
                    break;
                case StateRuleList.ValidPort:
                    stateRuleManager.validPort(siteId, wfsLoadReqBody.getEqpId(),
                            wfsLoadReqBody.getPortId(), queryPortVo);
                    break;
                case StateRuleList.FullAutoPort:
                    stateRuleManager.fullAutoPort(siteId, wfsLoadReqBody.getEqpId(),
                            wfsLoadReqBody.getPortId(), queryPortVo);
                    break;
                case StateRuleList.FullAutoEqp:
                    stateRuleManager.fullAutoEqp(siteId, wfsLoadReqBody.getEqpId(), queryEqpVo);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid validation type: " + validationType);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
