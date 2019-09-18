package org.sc.controller;

import org.sc.util.verify.AuthCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sc on 8/28/2019.
 */
@Controller
@RequestMapping(value = "/authorization_login")
public class AuthCodeController {


    @RequestMapping(value = "/image")
    public void getAuthCode(@RequestParam(required = false) String name, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO Auto-generated method stub
        // response.setContentType("text/html");
        System.out.println(request.getSession().getId());
        response.setContentType("image/png");
        response.setCharacterEncoding("utf-8");
        String authCode = AuthCodeUtil.getAuthCode();
        request.getSession().setAttribute("authcode", authCode.toLowerCase());
        request.getSession().setMaxInactiveInterval(10);
        //Write the image to the response
        ImageIO.write(AuthCodeUtil.getAuthImg(authCode), "png", response.getOutputStream());
    }

    public void valicode(){

    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public Map test(@RequestParam String name){
        Map map = new HashMap();
        map.put("name",name);
        return map;
    }


    @RequestMapping(value = "/jid")
    @ResponseBody
    public String sessionId(HttpServletRequest request){
        System.out.println(request.getSession().getId());
        return request.getSession().getId();
    }
}