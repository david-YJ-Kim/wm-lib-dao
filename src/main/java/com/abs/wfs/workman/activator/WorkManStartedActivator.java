package com.abs.wfs.workman.activator;

import com.abs.cmn.fis.config.FisPropertyObject;
import com.abs.cmn.fis.config.SolaceSessionConfiguration;
import com.abs.cmn.fis.domain.rule.mng.CnFisIfRuleManager;
import com.abs.cmn.fis.intf.solace.InterfaceSolacePub;
import com.abs.cmn.fis.intf.solace.InterfaceSolaceSub;
import com.abs.cmn.fis.message.FisMessagePool;
import com.abs.wfs.workman.config.ApPropertyObject;
import com.abs.wfs.workman.config.SolaceSessionConfiguration;
import com.abs.wfs.workman.intf.solace.InterfaceSolacePub;
import com.abs.wfs.workman.intf.solace.InterfaceSolaceSub;
import com.abs.wfs.workman.message.ApMessagePool;
import com.solacesystems.jcsmp.JCSMPException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WorkManStartedActivator implements ApplicationRunner {

    @Autowired
    private Environment env;


    @Override
    public void run(ApplicationArguments args){


        this.initializeSolaceResources();
        log.info("Complete initialize solace resources.");

        ApMessagePool.getMessageManageMap();
        log.info("Initialize Message Pool. is null?: {}", ApMessagePool.getMessageManageMap() == null);


    }

    private void initializeSolaceResources(){

        SolaceSessionConfiguration sessionConfiguration = SolaceSessionConfiguration.createSessionConfiguration(env);

        try {
            InterfaceSolacePub interfaceSolacePub = InterfaceSolacePub.getInstance();
            interfaceSolacePub.init();
            ApPropertyObject.getInstance().setInterfaceSolacePub(interfaceSolacePub);

        } catch (JCSMPException e) {
            throw new RuntimeException(e);
        }

        try {
            InterfaceSolaceSub interfaceSolaceSub = new InterfaceSolaceSub();
            interfaceSolaceSub.run();
            ApPropertyObject.getInstance().setInterfaceSolaceSub(interfaceSolaceSub);

        } catch (JCSMPException e) {
            throw new RuntimeException(e);
        }

    }
}
