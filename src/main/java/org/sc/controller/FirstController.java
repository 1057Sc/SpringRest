package org.sc.controller;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping(value = "/text")
    public Map deomo1(@RequestParam String lang){

        String text = " \"%20onclick=alert(1)%20accessKey=\"X\"%20\" ";
        System.out.println("Escape text _______" + StringEscapeUtils.escapeHtml4(text));

        System.out.println("request text _______"  + lang);
        Map m = new HashMap<>();
        m.put("name",lang);
        return m;
    }




}
