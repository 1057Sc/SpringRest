package org.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Application{

    public static void main(String args[]){
        SpringApplication.run(Application.class,args);
    }

}
