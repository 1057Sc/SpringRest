package org.sc.controller;

import org.sc.filter.ChangeRequestWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by duizhuang on 9/4/2019.
 */

@RestController
public class PendRequest {


    private static List<ChangeRequestWrapper> requestList  = new LinkedList<>();

    private boolean flag = false;

    @RequestMapping(value = "/pend")
    @ResponseBody
    public Map pendRequest(String reqId, ChangeRequestWrapper request, HttpServletResponse response) throws IOException {

        requestList.add(request);

        while (true){
            System.out.println(1);
            if (flag){
                break;
            }
        }

        Map map = new HashMap();
        map.put("size",requestList.size());

        response.getOutputStream().print("dsadsadasd");

        return map;
    }

    @RequestMapping(value = "/hello")
    public String change(){
        flag = true;

        return "1111";
    }

    @RequestMapping(value = "/change")
    public String changefalse(){
        flag = false;

        return "1111";
    }
}
