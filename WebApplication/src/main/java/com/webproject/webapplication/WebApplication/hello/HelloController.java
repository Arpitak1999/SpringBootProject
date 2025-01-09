package com.webproject.webapplication.WebApplication.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Arpita";
    }

    @RequestMapping("say-hello-jsp")
    public String sayHellojsp(){
        return "hello";
    }
}
