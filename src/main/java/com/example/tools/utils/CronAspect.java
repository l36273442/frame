package com.example.tools.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.*;

@Aspect
@Component
public class CronAspect {
    @Value("${cron.ip}")
    private String cronIp;
    //private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.example.tools.task.*.*(..))")
    public void pointCut() {
    }

    @After("pointCut()")
    public void afterAction(JoinPoint joinPoint) throws Throwable {

    }

    @Around("pointCut()")
    public Object aroundAction(ProceedingJoinPoint pjp) throws Throwable {
        String serverIp = new String();
        try {
            List<Map<String, String>> listMap = new ArrayList<>();
            // 获取当前主机的所有网络接口，至少包含一个回环ip地址 127.0.0.1
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface anInterface = interfaces.nextElement();
                Enumeration<InetAddress> addresses = anInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress inetAddress = addresses.nextElement();
                    Map<String, String> map = new HashMap<>(3);
                    if (inetAddress.getHostAddress().equals(cronIp)) {
                        return pjp.proceed();
                    }
                }
            }
        } catch (Exception e) {
            serverIp = "";
        }
        return null;
    }
}

