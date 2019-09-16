package com.xj.springboot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Springboot01Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01Application.class, args);
    }

    //http://localhost:8080 + any
    @RequestMapping
    public String defaultPage(){
        return "Hello ,this is the defaultPage of spring boot";
    }

    //http://localhost:8080/hello
    @RequestMapping("/hello")
    public String hello(){
        return "Hello page of spring boot";
    }

    //http://localhost:8080/index
    @RequestMapping("/index")
    public String index(){
        return "The index of spring boot";
    }
}
