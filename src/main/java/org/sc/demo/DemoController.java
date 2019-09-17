package org.sc.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DemoController {

    @RequestMapping(value = "get_demo")
    public void demo(HttpServletRequest request) {
        String servletPath = request.getServletPath();
        String requestURI = request.getRequestURI();
        System.out.println("......................");
    }
}
