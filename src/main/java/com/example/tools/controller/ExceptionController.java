package com.example.tools.controller;

import com.example.tools.utils.BaseController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class ExceptionController extends BaseController {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map globalException(HttpServletRequest request, Exception e) {
        Map<String,Object> map = new HashMap<>();

        map.put("code",500);
        map.put("message",e.getMessage());
        logException(e);
        return map;
    }
    public void logException(Exception e){
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append("\tat ").append(stackTraceElement.getClassName()).append(".")
                    .append(stackTraceElement.getMethodName())
                    .append("(").append(stackTraceElement.getFileName()).append(":").append(stackTraceElement.getLineNumber())
                    .append(")\r\n");
        }
        log.error(sb.toString());
       // System.out.println(sb.toString());
    }
}
