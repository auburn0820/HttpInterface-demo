package com.example.httpinterfacedemo;

import com.example.httpinterfacedemo.beans.SomeTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HttpinterfaceDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HttpinterfaceDemoApplication.class, args);

        SomeTest someTest = new SomeTest(context.getBean(TodoService.class));
        someTest.someTest();
    }

}
