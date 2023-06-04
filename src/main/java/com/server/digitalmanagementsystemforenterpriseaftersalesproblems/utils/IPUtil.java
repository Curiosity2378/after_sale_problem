package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.utils;

import javax.servlet.http.HttpServletRequest;

public class IPUtil {
    public static String getIpAddress(HttpServletRequest request){
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }
}
