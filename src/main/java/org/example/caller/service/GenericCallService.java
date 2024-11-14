package org.example.caller.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.stereotype.Component;


/**
 * Created by chenjiacheng on 2024/11/15 00:09
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@Component
public class GenericCallService {


    public Object call(String nacos,String env,String interfaceName,String methodName,String[] parameterTypes,Object[] args){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("caller");
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("nacos://"+nacos+":8848"+env);
        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setInterface(interfaceName);
        applicationConfig.setRegistry(registryConfig);
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setGeneric("true");
        referenceConfig.setVersion("");
        referenceConfig.setAsync(true);
        referenceConfig.setTimeout(10*1000);

        RpcContext.getClientAttachment().setAttachment("ec", "ecv");

        GenericService genericService = referenceConfig.get();
        return genericService.$invoke(methodName, parameterTypes, args);
    }


}
