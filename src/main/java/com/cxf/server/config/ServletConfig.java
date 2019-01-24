package com.cxf.server.config;

import com.cxf.server.service.hello1.HelloServiceImpl1;
import com.cxf.server.service.hello2.HelloServiceImpl2;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;

/**
 * @author wanghongchao
 * @mail wanghongchao@sinosoft.com.cn
 * @time 2019/1/23
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.cxf.server.*")
public class ServletConfig {
    @Bean
    public Bus getBus(){
        return new SpringBus();
    }
    @Bean
    public Server rsServer() {
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(getBus());
        endpoint.setServiceBeans(Arrays.<Object>asList(new HelloServiceImpl1(), new HelloServiceImpl2()));
        endpoint.setAddress("/");
        return endpoint.create();
    }
}
