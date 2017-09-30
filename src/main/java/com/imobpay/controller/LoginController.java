package com.imobpay.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.google.code.kaptcha.Constants;
import com.imobpay.commons.annotation.SystemLog;
import com.imobpay.commons.base.BaseController;
import com.imobpay.commons.log.LogPay;
import com.imobpay.constant.LoginConstant;

/**
 * @description：登录退出
 * @author：zhixuan.wang
 * @date：2015/10/1 14:51
 */
@Controller
public class LoginController extends BaseController {

    /**
     * 
     * 【方法名】 : 首页. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:45:03 .<br/>
     * 【参数】： .<br/>
     * 
     * @return .<br/>
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "redirect:/index";
    }

    /**
     * 
     * 【方法名】 : 首页. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:45:19 .<br/>
     * 【参数】： .<br/>
     * 
     * @param model
     *            model
     * @return .<br/>
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    /**
     * GET 登录
     * 
     * @return {String}
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        LogPay.info("GET请求登录");
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/index";
        }
        return "login";
    }

    /**
     * 
     * 【方法名】 : 登录 shiro . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:45:44 .<br/>
     * 【参数】： .<br/>
     * 
     * @param request
     *            request
     * @param userName
     *            用户名
     * @param password
     *            密码
     * @param captcha
     *            验证码
     * @param rememberMe
     *            rememberMe
     * @return .<br/>
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    @SystemLog(module = "用户管理", methods = "用户登陆")
    public Object loginPost(HttpServletRequest request, String userName, String password, String captcha, @RequestParam(value = "rememberMe", defaultValue = "0") Integer rememberMe) {
        LogPay.info("POST请求登录");
        if (StringUtils.isEmpty(userName)) {
            return renderError(LoginConstant.EMPTY_USERNAME);
        }
        if (StringUtils.isEmpty(password)) {
            return renderError(LoginConstant.EMPTY_PASSWORD);
        }

        if (StringUtils.isEmpty(captcha)) {
            return renderError(LoginConstant.EMPTY_CAPTCHA);
        }
        String kaptchaExpected = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (!captcha.equalsIgnoreCase(kaptchaExpected)) {
            return renderError(LoginConstant.ERR_CAPTCHA);
        }

        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(Boolean.FALSE);
        // 设置记住密码
        try {
            user.login(token);
            return renderSuccess(LoginConstant.SUCCESS);
        } catch (UnknownAccountException e) {
            LogPay.error(e.getMessage());
            return renderError(LoginConstant.NOT_EXISTS_USERNAME);
        } catch (DisabledAccountException e) {
            LogPay.error(e.getMessage());
            return renderError(LoginConstant.NOT_ENABLED_USERNAME);
        } catch (IncorrectCredentialsException e) {
            LogPay.error(e.getMessage());
            return renderError(LoginConstant.ERR_PASSWORD);
        } catch (Exception e) {
            LogPay.error(e.getMessage());
            return renderError(LoginConstant.ERR_UNKNOWN);
        }
    }

    /**
     * 未授权
     * 
     * @return {String}
     */
    @RequestMapping(value = "/unauth", method = RequestMethod.GET)
    public String unauth() {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            return "redirect:/login";
        }
        return "unauth";
    }

    /**
     * 退出
     * 
     * @return {Result}
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public Object logout() {
        LogPay.info("登出");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return renderSuccess();
    }

}
