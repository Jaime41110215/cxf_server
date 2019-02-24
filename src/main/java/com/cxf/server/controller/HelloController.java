package com.cxf.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghongchao
 * @mail wanghongchao@sinosoft.com.cn
 * @time 2019/1/23
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/world")
    public String hello(){
        return "new world! i am wanghogncaho";
    }
}
