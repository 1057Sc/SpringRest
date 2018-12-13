package org.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages = {"org.sc.listener"})
@SpringBootApplication
public class Application {

    public static void main(String args[]){
        SpringApplication.run(Application.class,args);
    }
}
