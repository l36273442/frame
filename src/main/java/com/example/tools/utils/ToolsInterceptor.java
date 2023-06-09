package com.example.tools.utils;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;


public class ToolsInterceptor implements HandlerInterceptor {
    Logger logRunning = LoggerFactory.getLogger("toolsRunning");
    private Long startTime;
    //@Resource
    //Environment environment;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        startTime = System.currentTimeMillis();
        request.getSession();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        linkedHashMap.put("startTime", sdf2.format(startTime));
        linkedHashMap.put("startTimestamp", startTime);
        Long endTime = System.currentTimeMillis();
        linkedHashMap.put("costTime", endTime.doubleValue() / 1000 - (startTime.doubleValue() / 1000));
        linkedHashMap.put("thread", Thread.currentThread().getName());
        linkedHashMap.put("url", request.getRequestURL());
        linkedHashMap.put("referer", request.getHeader("Referer"));

        String realIp = common.getRealIp(request);

        linkedHashMap.put("x-forwarded-for", request.getHeader("x-forwarded-for"));
        linkedHashMap.put("proxy-client-ip", request.getHeader("Proxy-Client-IP"));
        linkedHashMap.put("wl-proxy-client-ip", request.getHeader("WL-Proxy-Client-IP"));
        linkedHashMap.put("http_client_ip", request.getHeader("HTTP_CLIENT_IP"));
        linkedHashMap.put("x-real-ip", request.getHeader("X-Real-IP"));
        linkedHashMap.put("ip", request.getRemoteAddr());
        linkedHashMap.put("realIp", realIp);
        linkedHashMap.put("url", request.getRequestURL());
        try {
            InetAddress address = InetAddress.getLocalHost();
            linkedHashMap.put("serverIp", address.getHostAddress());
        } catch (Exception e) {
            linkedHashMap.put("serverIp", "");
        }
        //try{
            //TraceContext traceContext = (TraceContext) request.getAttribute(TraceContext.class.getName());
            //String traceId = traceContext.traceId();
            //String spanId = traceContext.spanId();
            //linkedHashMap.put("traceId",traceId);
            //linkedHashMap.put("spanId",spanId);
        //}catch (Exception e){
            //linkedHashMap.put("traceId","");
            //linkedHashMap.put("spanId","");
        //}
        linkedHashMap.put("sessionId", request.getSession().getId());
        linkedHashMap.put("cookie", request.getCookies());
        linkedHashMap.put("userAgent", request.getHeader("User-Agent"));
        linkedHashMap.put("host", request.getHeader("Host"));
        if (request.getAttribute("threadData") != null) {
            HashMap<String,Object> threadData = (HashMap<String,Object>)request.getAttribute("threadData");
            if (!threadData.isEmpty()) {
                for (String key : threadData.keySet()) {
                    linkedHashMap.put(key, threadData.get(key));
                }
            }
        }
        logRunning.info(JSON.toJSONString(linkedHashMap));
    }
}










