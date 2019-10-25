package org.sc.config;

import org.sc.interceptor.PararmInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(pararmInterceptor())
                .addPathPatterns("/**");
    }


    @Bean
    public PararmInterceptor pararmInterceptor() {
        return new PararmInterceptor();
    }
}
