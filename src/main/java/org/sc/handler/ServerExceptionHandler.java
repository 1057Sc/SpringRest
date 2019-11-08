package org.sc.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ServerExceptionHandler {

    @ExceptionHandler(value = ServerException.class)
    public Map exeption(ServerException exception){
        exception.printStackTrace();
        return new HashMap();
    }
}
