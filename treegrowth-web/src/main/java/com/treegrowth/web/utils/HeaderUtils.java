package com.treegrowth.web.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static com.google.common.base.Splitter.on;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.Iterables.getFirst;

public class HeaderUtils {

    public static String getRequestRealIp(HttpServletRequest request) {
        // multi-tier
        String ip = request.getHeader("X-Forwarded-For");
        if (!isNullOrEmpty(ip)) {
            ip = getFirst(on(',').trimResults().omitEmptyStrings().split(ip), null);
        }
        if (!isResolved(ip)) {
            // single-tier
            ip = request.getHeader("X-Real-IP");
        }
        if (!isResolved(ip)) {
            ip = request.getRemoteAddr();
            if (ip.equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
                InetAddress inetAddress;
                try {
                    inetAddress = InetAddress.getLocalHost();
                    ip = inetAddress.getHostAddress();
                } catch (UnknownHostException ignored) {
                }
            }
        }

        return ip;
    }

    private static boolean isResolved(String ip) {
        return !isNullOrEmpty(ip) && !"unknown".equalsIgnoreCase(ip);
    }

    /** stack over */
//    private static final String[] HEADERS_TO_TRY = {
//            "X-Forwarded-For",
//            "Proxy-Client-IP",
//            "WL-Proxy-Client-IP",
//            "HTTP_X_FORWARDED_FOR",
//            "HTTP_X_FORWARDED",
//            "HTTP_X_CLUSTER_CLIENT_IP",
//            "HTTP_CLIENT_IP",
//            "HTTP_FORWARDED_FOR",
//            "HTTP_FORWARDED",
//            "HTTP_VIA",
//            "REMOTE_ADDR" };
//
//    public static String getClientIpAddress(HttpServletRequest request) {
//        for (String header : HEADERS_TO_TRY) {
//            String ip = request.getHeader(header);
//            if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
//                return ip;
//            }
//        }
//        return request.getRemoteAddr();
//    }

}
