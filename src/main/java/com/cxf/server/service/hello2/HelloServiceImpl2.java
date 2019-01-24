
package com.cxf.server.service.hello2;


import com.cxf.server.service.HelloService;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Service("helloService")
public class HelloServiceImpl2 implements HelloService {
    @Override
    public String sayHello(String a) {
        return "Hello2 " + a + ", Welcome to CXF RS Spring Boot World!!!";
    }
}
