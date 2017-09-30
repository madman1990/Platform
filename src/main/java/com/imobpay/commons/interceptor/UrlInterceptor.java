/** 
 * 包名: package com.raising.system.interceptor; <br/> 
 * 添加时间: 2017年7月28日 下午3:29:00 <br/> 
 */
package com.imobpay.commons.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.imobpay.commons.log.LogPay;
import com.imobpay.commons.shiro.ShiroUser;

/**
 * 类名: LoginInterceptor <br/>
 * 作用：TODO(简单一句话描述)<br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年7月28日 下午3:29:00 <br/>
 */
public class UrlInterceptor implements HandlerInterceptor {

    private static List<String> URL_LIST = null;

    static {
        URL_LIST = new ArrayList<String>();
        URL_LIST.add("login");
        URL_LIST.add("home");
        URL_LIST.add("login_timeout");
        URL_LIST.add("welcome");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object paramObject) throws Exception {
        // 得到请求的url
        String url = request.getRequestURI();
        // 判断是否是公开 地址

        for (String openUrl : URL_LIST) {
            if (url.indexOf(openUrl) >= 0) {
                // 如果是公开 地址则放行
                return true;
            }
        }

        // 判断用户身份在session中是否存在
        Subject subject = SecurityUtils.getSubject();
        ShiroUser shiroUser = (ShiroUser) subject.getPrincipal();
        // 如果用户身份在session中存在放行

        String referrer = request.getHeader("referer");
        String basePath = request.getContextPath();

        if (referrer == null || referrer.equals("") || referrer.lastIndexOf(basePath) == -1) {
            if (shiroUser != null) {
                request.getRequestDispatcher("home").forward(request, response);
            } else {
                response.sendRedirect("login");
            }
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, Object paramObject, ModelAndView paramModelAndView) throws Exception {
        LogPay.info("HandlerInterceptor1...postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, Object paramObject, Exception paramException) throws Exception {

    }

}
