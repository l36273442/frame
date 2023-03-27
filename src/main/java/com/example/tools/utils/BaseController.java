package com.example.tools.utils;


import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.security.auth.message.callback.SecretKeyCallback;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;


public class BaseController {
    public HashMap<String, Object> h = new HashMap<>();
    private Logger log = LoggerFactory.getLogger("root");
    /*
    @PreDestroy
    public void preDestroy(){
        //logRunning.info("777777");
        log.warn("8888");
        log.error("999");
        System.out.println(m.toString());
    }
     */
}











