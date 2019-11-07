package org.sc.filter;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sc on 8/26/2019.
 */
// @Component
@WebFilter(urlPatterns = "/*", filterName = "LangFilter")
public class LangFilter implements Filter {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(LangFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LangFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        ChangeRequestWrapper changeRequestWrapper = new ChangeRequestWrapper((HttpServletRequest) servletRequest);

        Map<String, String[]> parameterMap = new HashMap<>(changeRequestWrapper.getParameterMap());

        Set<String> keys = parameterMap.keySet();

        for (String key : keys) {
            String[] values = parameterMap.get(key);

            if (values == null || values.length == 0) {
                continue;
            }

            String[] newValues = new String[values.length];

            for (int i = 0; i < values.length; i++) {
                newValues[i] = StringEscapeUtils.escapeHtml4(values[i]);
            }

            parameterMap.put(key, newValues);
        }

        changeRequestWrapper.setParameterMap(parameterMap);

        filterChain.doFilter(changeRequestWrapper, servletResponse);
    }

    @Override
    public void destroy() {

    }
}