package com.abs.wfs.workman.config;

import com.abs.wfs.workman.intf.solace.InterfaceSolacePub;
import com.abs.wfs.workman.intf.solace.InterfaceSolaceSub;
import com.abs.wfs.workman.util.FisCommonUtil;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Getter
@Component
public class ApPropertyObject {


    Environment env;
    @Value("${ap.info.group}")
    private String groupName;
    @Value("${ap.info.site}")
    private String siteName;
    @Value("${ap.info.env}")
    private String envType;
    @Value("${ap.info.sequence}")
    private String processSeq;

    private String clientName;

    @Value("${ap.interface.destination.receive.queue}")
    private String receiveQueueName;
    @Value("${ap.interface.destination.receive.init}")
    private String receiveInitTopic;
    @Value("${ap.interface.destination.send.topic}")
    private String sendTopicName;

    @Value("${ap.query.batchSize}")
    private Integer batchSize;
    @Value("${ap.query.table-name.insp}")
    private String tableNameInsp;
    @Value("${ap.query.table-name.meas}")
    private String tableNameMeas;

    @Value("${ap.query.insert-template}")
    private String insertBatchTemplate;
    @Value("${ap.query.del-template}")
    private String deleteBatchTemplate;
    @Value("${ap.query.getDelList}")
    private String getDeleteListSql;
    @Value("${ap.query.deleteCnWork}")
    private String deleteCnWork;
    @Value("${ap.query.insertWorkHistory}")
    private String insertWorkHistory;

    @Value("${ap.query.rule.parsing}")
    private String selectParsingRuleDataSql;

    @Value("${ap.query.rule.mapping}")
    private String selectMappingRuleDataSql;

    @Value("${ap.shutdown.force.timeout.ms}")
    private int apShutdownForceTimeoutMs;

    @Value("${ap.shutdown.polling.interval.ms}")
    private int apShutdownPollingIntervalMs;

    @Value("${ap.worker.pool-size.core}")
    private int corePoolSize;  // 기본 실행 대기하는 Thread 수

    @Value("${ap.worker.pool-size.max}")
    private int maxPoolSize;  // 동시 동작하는 최대 Thread 수

    @Value("${ap.worker.capacity}")
    private int queueCapacity;  // MaxPoolSize 초과 요청 시, 최대 Queue 저장 수

    @Value("${ap.worker.name.prefix}")
    private String threadPrefixName; // 생성되는 Thread 접두사 명



    private InterfaceSolaceSub interfaceSolaceSub;

    private InterfaceSolacePub interfaceSolacePub;



    private static ApPropertyObject instance;

    // Public method to get the Singleton instance
    public static ApPropertyObject createInstance(Environment env) {
        if (instance == null) {
            synchronized (ApPropertyObject.class) {
                // Double-check to ensure only one instance is created
                if (instance == null) {
                    instance = new ApPropertyObject(env);
                }
            }
        }

        if(instance.clientName == null){
            instance.clientName = FisCommonUtil.generateClientName(instance.groupName, instance.siteName, instance.envType, instance.processSeq);
        }


        return instance;
    }

    public static ApPropertyObject getInstance(){
        return instance;
    }
    public ApPropertyObject(Environment env) {
        this.env = env;
        instance = this;
    }

    public void setInterfaceSolaceSub(InterfaceSolaceSub interfaceSolaceSub) {
        this.interfaceSolaceSub = interfaceSolaceSub;
    }

    public void setInterfaceSolacePub(InterfaceSolacePub interfaceSolacePub) {
        this.interfaceSolacePub = interfaceSolacePub;
    }




}
