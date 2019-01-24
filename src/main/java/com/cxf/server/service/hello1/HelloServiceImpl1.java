
package com.cxf.server.service.hello1;


import com.cxf.server.service.HelloService;

public class HelloServiceImpl1 implements HelloService {

    public String sayHello(String a) {
        return "Hello " + a + ", Welcome to CXF RS Spring Boot World!!!";
    }

}
