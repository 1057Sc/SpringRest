package org.sc.config;

import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


/**
 *
 *  只需要对特定的操作做csrf防御，例如特别敏感的操作。
 *  丢到Spring security 即可使用
 */
public class CsrfSecurityRequestMatcher implements RequestMatcher {

    private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");

    @Override
    public boolean matches(HttpServletRequest request) {
        List<String> execludeUrls = new ArrayList<>();
        execludeUrls.add("sys/getSecCode.do");//允许post请求的url路径，这只是简单测试，具体要怎么设计这个csrf处理，看个人爱好

        if (execludeUrls != null && execludeUrls.size() > 0) {
            String servletPath = request.getServletPath();
            request.getParameter("");
            for (String url : execludeUrls) {
                if (servletPath.contains(url)) {
                    return false;
                }
            }
        }
        return !allowedMethods.matcher(request.getMethod()).matches();
    }
}