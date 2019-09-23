package org.sc.controller;

import org.sc.filter.ChangeRequestWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Thread.sleep;

/**
 * Created by Sc on 9/4/2019.
 */

@RestController
public class PendRequest {


    private static List<HttpServletRequest> requestList  = new LinkedList<>();

    private boolean flag = false;

    @RequestMapping(value = "/pend")
    @ResponseBody
    public Map pendRequest(String reqId, HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException {

        requestList.add(request);
    /*    Thread.sleep(25000);

        if (reqId.equals("1")) {
            Thread.interrupted();
        }*/
        /*while (true){
            System.out.println(1);
            sleep(25000);
            if (flag){
                break;
            }
        }*/

        Map map = new HashMap();
        map.put("size",requestList.size());

        //response.getOutputStream().print("dsadsadasd");

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

    @RequestMapping(value = "/wait_test")
    public String waitTest(Integer time) throws InterruptedException {
        PendRequest pendRequest = new PendRequest();
        synchronized (pendRequest) {
              if (Objects.equals(time,10)) {
                  pendRequest.wait(10 * 1000);
              }
            System.out.println(11111);
              notify();
          }
        return "1111";
    }
}
