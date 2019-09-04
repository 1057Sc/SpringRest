package org.sc.listener;

import org.sc.filter.LangFilter;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
@Component
public class SessionListener implements HttpSessionListener {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(HttpSessionListener.class);

    public SessionListener() {
        System.out.println("SessionListener  =========  init");
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        String authcode = (String) httpSessionEvent.getSession().getAttribute("authcode");
        logger.info("session被创建======>>>>>");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        String authcode = (String) httpSessionEvent.getSession().getAttribute("authcode");
        logger.info("session被销毁=====>>>>>" + authcode);
    }


}
