package org.sc.lazy;

import org.sc.util.SpringContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Demo {


    private Demo1 demo1;

    @Autowired
    public Demo (Demo1 demo1){
        this.demo1 = demo1;
        System.out.println("demo1 :::::::::::::::::::::::");
        System.out.println(demo1 == null);
    }
}
