package org.sc.util;

import org.junit.Test;
import org.springframework.util.AntPathMatcher;

import java.util.HashMap;
import java.util.Map;

public class PathMatch {

    static Map<String, String> url = new HashMap<String, String>() {{
        put("/open/**", "ROLE_ANONYMOUS");
        put("/health", "ROLE_ANONYMOUS");
        put("/restart", "ROLE_ADMIN");
        put("/demo", "ROLE_USER");
        put("/users/*/address", "ROLE_USER");
    }};


    @Test
    public void pathMatch() {
        AntPathMatcher antPathMatcher = new AntPathMatcher();

        // boolean match = antPathMatcher.match("/users/*/address", "/users/12213/address");
        // System.out.println(match);

        // boolean match1 = antPathMatcher.match("/users/*/address", "/users/12213/123123/address");
        // System.out.println(match1);


        boolean match3 = antPathMatcher.match("/v1/seller_staff_roles/1/permissions", "/v*/seller_staff_roles/*/permissions");
        boolean match4 = antPathMatcher.match("/v*/seller_staff_roles/*/permissions", "/v1/seller_staff_roles/1/permissions");
        System.out.println(match4);

        boolean match = antPathMatcher.match("/v*/login/**", "/v1/login/qr_code/actions/check");
        System.out.println(match);
    }
}
