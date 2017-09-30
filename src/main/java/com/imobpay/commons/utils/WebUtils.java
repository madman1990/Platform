package com.imobpay.commons.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;

/**
 * 
 * <pre>
 * 【类型】: WebUtils <br/> 
 * 【作用】: Miscellaneous utilities for web applications. <br/>  
 * 【时间】：2017年5月23日 上午10:01:26 <br/> 
 * 【作者】：Ferry Chen <br/>
 * </pre>
 */
public class WebUtils extends org.springframework.web.util.WebUtils {
    /**
     * 判断是否ajax请求 spring ajax 返回含有 ResponseBody 或者 RestController注解
     * 
     * @param handlerMethod
     *            HandlerMethod
     * @return 是否ajax请求
     */
    public static boolean isAjax(HandlerMethod handlerMethod) {
        ResponseBody responseBody = handlerMethod.getMethodAnnotation(ResponseBody.class);
        if (null != responseBody) {
            return true;
        }
        RestController restAnnotation = handlerMethod.getBeanType().getAnnotation(RestController.class);
        if (null != restAnnotation) {
            return true;
        }
        return false;
    }

    /**
     * 读取cookie
     * 
     * @param request
     *            request
     * @param name
     *            name
     * @return .<br/>
     */
    public static String getCookieValue(HttpServletRequest request, String name) {
        Cookie cookie = getCookie(request, name);
        return cookie != null ? cookie.getValue() : null;
    }

    /**
     * 清除 某个指定的cookie
     * 
     * @param response
     *            response
     * @param key
     *            key
     */
    public static void removeCookie(HttpServletResponse response, String key) {
        setCookie(response, key, null, 0);
    }

    /**
     * 设置cookie
     * 
     * @param response
     *            response
     * @param name
     *            name
     * @param value
     *            value
     * @param maxAgeInSeconds
     *            maxAgeInSeconds
     */
    public static void setCookie(HttpServletResponse response, String name, String value, int maxAgeInSeconds) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAgeInSeconds);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }
}
