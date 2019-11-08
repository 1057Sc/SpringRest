package org.sc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ExecpetionHandler {

    @ExceptionHandler(value = ServerExecpetion.class)
    public Map exeption(ServerExecpetion execpetion){
        return new HashMap();
    }
}
