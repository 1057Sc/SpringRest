package org.sc.listener;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Enumeration;

@WebListener
public class SignListener implements HttpSessionListener {

    public static int online = 0;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

        String sessionid = httpSessionEvent.getSession().getId();
        System.out.println("established sessionid is"+sessionid);

        Enumeration em = httpSessionEvent.getSession().getAttributeNames();
        while(em.hasMoreElements()){
            System.out.println("来自sessionListener创建session:"+httpSessionEvent.getSession().getAttribute((String)em.nextElement()));
        }


    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        Enumeration em = httpSessionEvent.getSession().getAttributeNames();
        while(em.hasMoreElements()){
            System.out.println("来自sessionListener移除session:"+httpSessionEvent.getSession().getAttribute((String)em.nextElement()));
        }

        String sessionid = httpSessionEvent.getSession().getId();
        System.out.println("destory sessionid is"+sessionid);
    }
}
