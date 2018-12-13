package org.sc.sign;


import org.springframework.stereotype.Controller;
import org.springframework.util.SocketUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Sc on 2018/12/13.
 */
@RestController
public class Signin{

    @RequestMapping(value="/loginDemo")
    public void signin(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{


        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.print("userName: " + userName + ";" + "passwored: " + password);
        HttpSession session = request.getSession();
        session.setAttribute("user",userName);
        String sessionId = session.getId();
        System.out.println("sessionid为"+sessionId);
        if(session.isNew()){
            System.out.println("sessionid new为"+sessionId);
        }
        Cookie cookie = new Cookie(userName,password);
        Enumeration em = request.getSession().getAttributeNames();
        while(em.hasMoreElements()){
            request.getSession().removeAttribute(em.nextElement().toString());
        }
        response.addCookie(cookie);

    }

    public void showSession(HttpServletRequest request,HttpServletResponse response){
        Enumeration em = request.getSession().getAttributeNames();
        while(em.hasMoreElements()){
            request.getSession().removeAttribute(em.nextElement().toString());
        }
    }
}