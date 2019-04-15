package org.sc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sc on 2019/2/14.
 *
 * @Description:
 */
@RestController
public class FirstController {

    @RequestMapping("demo")
    public void demo(){
        System.out.println("demo");
    }

}
