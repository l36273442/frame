package com.example.tools.utils;

import javax.servlet.http.HttpServletRequest;

public class common {


    public static String getRealIp(HttpServletRequest request) {
        String realIp = null;
        try {
            realIp = request.getHeader("x-forwarded-for");
            if (realIp == null || realIp.length() == 0 || "unknown".equalsIgnoreCase(realIp)) {
                realIp = request.getHeader("Proxy-Client-IP");
            }
            if (realIp == null || realIp.length() == 0 || "unknown".equalsIgnoreCase(realIp)) {
                realIp = request.getHeader("WL-Proxy-Client-IP");
            }
            if (realIp == null || realIp.length() == 0 || "unknown".equalsIgnoreCase(realIp)) {
                realIp = request.getHeader("HTTP_CLIENT_IP");
            }
            if (realIp == null || realIp.length() == 0 || "unknown".equalsIgnoreCase(realIp)) {
                realIp = request.getHeader("X-Real-IP");
            }
            if (realIp == null || realIp.length() == 0 || "unknown".equalsIgnoreCase(realIp)) {
                realIp = request.getRemoteAddr();
            }
            if (realIp != null && realIp.length() > 15) { // "***.***.***.***".length()
                // = 15
                if (realIp.indexOf(",") > 0) {
                    realIp = realIp.substring(0, realIp.indexOf(","));
                }
            }

        } catch (Exception e) {
            realIp = "";
        }
        return realIp;
    }
}
