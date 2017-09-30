package com.imobpay.commons.scan;

import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imobpay.commons.annotation.SystemLog;
import com.imobpay.commons.base.BaseController;
import com.imobpay.commons.log.LogPay;
import com.imobpay.commons.result.Result;
import com.imobpay.commons.shiro.ShiroUser;
import com.imobpay.commons.utils.CommonUtil;
import com.imobpay.commons.utils.DateUtils;
import com.imobpay.commons.utils.StringUtils;
import com.imobpay.model.system.SysUserOperLog;
import com.imobpay.service.system.ISysUserOperLogService;

/**
 * 
 * <pre>
 * 【类型】: LogAopAction <br/> 
 * 【作用】: 日志 切点类 . <br/>  
 * 【时间】：2017年5月23日 上午9:43:20 <br/> 
 * 【作者】：Ferry Chen <br/>
 * </pre>
 */
@Aspect
@Component
public class LogAopAction extends BaseController {
    /** */
    @Autowired
    private ISysUserOperLogService sysUserOperLogService;

    /**
     * 
     * 【方法名】 : Controller层切点. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午9:43:50 .<br/>
     * 【参数】： .<br/>
     * .<br/>
     */
    @Pointcut("@annotation(com.imobpay.commons.annotation.SystemLog)")
    public void controllerAspect() {
    }

    /**
     * 
     * 【方法名】 :操作异常记录 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午9:44:21 .<br/>
     * 【参数】： .<br/>
     * 
     * @param point
     *            JoinPoint
     * @param e
     *            Throwable
     */
    @AfterThrowing(pointcut = "controllerAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint point, Throwable e) {
        HttpServletRequest request = CommonUtil.getHttpRequest();
        String methodName = point.getSignature().getName();
        String className = point.getTarget().getClass().getSimpleName();
        Object[] params = point.getArgs();
        SysUserOperLog operLog = new SysUserOperLog();
        Map<String, Object> map = null;
        String accountName = null;
        String ip = null;
        try {
            ip = CommonUtil.toIpAddr(request);
        } catch (Exception ee) {
            ip = "无法获取登录用户Ip";
        }
        try {
            // 登录名
            ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
            accountName = shiroUser.getId();
            if (StringUtils.isBlank(accountName)) {
                LogPay.info("无法获取登录用户信息！");
            }
        } catch (Exception e1) {
            LogPay.info("无法获取登录用户信息！");
        }
        StringBuffer bfParams = getParam(request, params);
        try {
            map = getControllerMethodDescription(point);
            operLog.setIpAddr(ip);
            operLog.setUserId(accountName);
            operLog.setModuleName(String.valueOf(map.get("module")));
            operLog.setOperType(String.valueOf(map.get("methods")));
            operLog.setActionTime("0");
            operLog.setOperTime(DateUtils.getCurrTime(DateUtils.YYYYMMDDHHMMSS));
            String content = bfParams.toString();
            if (content != null && content.length() > 250) {
                content = content.substring(0, 220);
            }
            operLog.setOperContent(content);
            operLog.setOperDesc("执行方法异常");
            sysUserOperLogService.insertOperLog(operLog);
            LogPay.info("请求方法:" + className + "." + methodName + "()");
        } catch (Exception e1) {
            LogPay.error("异常信息:{}" + e1.getMessage(), e1);
        } finally {
            bfParams = null;
            operLog = null;
        }

    }

    /**
     * 
     * 【方法名】 : 前置通知 用于拦截Controller层记录用户的操作. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午9:44:45 .<br/>
     * 【参数】： .<br/>
     * 
     * @param point
     *            ProceedingJoinPoint
     * @return .<br/>
     */
    @Around("controllerAspect()")
    public Object doController(ProceedingJoinPoint point) {
        HttpServletRequest request = CommonUtil.getHttpRequest();
        Object result = null;
        String methodName = point.getSignature().getName();
        String className = point.getTarget().getClass().getSimpleName();
        Object[] params = point.getArgs();
        StringBuffer bfParams = getParam(request, params);
        LogPay.info(bfParams.toString());
        SysUserOperLog operLog = new SysUserOperLog();
        Map<String, Object> map = null;
        String accountName = null;
        Long start = 0L;
        Long end = 0L;
        Long time = 0L;
        String ip = null;
        try {
            ip = CommonUtil.toIpAddr(request);
        } catch (Exception e) {
            ip = "无法获取登录用户Ip";
        }

        // 当前用户
        try {
            map = getControllerMethodDescription(point);
            // 执行方法所消耗的时间
            start = System.currentTimeMillis();
            result = point.proceed();
            end = System.currentTimeMillis();
            time = end - start;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        try {
            // 登录名
            ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
            accountName = shiroUser.getId();
            if (StringUtils.isBlank(accountName)) {
                LogPay.info("无法获取登录用户信息！");
            }

        } catch (Exception e) {
            LogPay.info("无法获取登录用户信息！");
        }
        try {
            operLog.setIpAddr(ip);
            operLog.setUserId(accountName);
            operLog.setModuleName(String.valueOf(map.get("module")));
            operLog.setOperType(String.valueOf(map.get("methods")));
            operLog.setActionTime(time.toString());
            operLog.setOperTime(DateUtils.getCurrTime(DateUtils.YYYYMMDDHHMMSS));
            String content = bfParams.toString();
            if (content != null && content.length() > 250) {
                content = content.substring(0, 220);
            }
            operLog.setOperContent(content);
            Result r = (Result) result;
            if (null != r) {
                operLog.setOperDesc(r.getMsg());
            }
            sysUserOperLogService.insertOperLog(operLog);

            LogPay.info("请求方法:" + className + "." + methodName + "()");

        } catch (Exception e) {
            LogPay.error("异常信息:" + e.getMessage(), e);
        } finally {
            bfParams = null;
            operLog = null;
        }
        return result;
    }

    /**
     * 
     * 【方法名】 : 获取注解中对方法的描述信息 用于Controller层注解. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午9:45:01 .<br/>
     * 【参数】： .<br/>
     * 
     * @param joinPoint
     *            JoinPoint
     * @return Map
     * @throws Exception .<br/>
     */
    @SuppressWarnings("rawtypes")
    public Map<String, Object> getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    map.put("module", method.getAnnotation(SystemLog.class).module());
                    map.put("methods", method.getAnnotation(SystemLog.class).methods());
                    String de = method.getAnnotation(SystemLog.class).description();
                    if (StringUtils.isEmpty(de)) {
                        de = "执行成功!";
                    }
                    map.put("description", de);
                    break;
                }
            }
        }
        return map;
    }

    /**
     * 
     * 【方法名】 : 获取参数 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午9:45:19 .<br/>
     * 【参数】： .<br/>
     * 
     * @param request
     *            request
     * @param params
     *            Object
     * @return .<br/>
     */
    private StringBuffer getParam(HttpServletRequest request, Object[] params) {
        StringBuffer bfParams = new StringBuffer();
        Enumeration<String> paraNames = null;
        if (params != null && params.length > 0) {
            paraNames = request.getParameterNames();
            String key;
            String value;
            while (paraNames.hasMoreElements()) {
                key = paraNames.nextElement();
                value = request.getParameter(key);
                if ("password".equals(key) || "pwd".equals(key) || "oldPwd".equals(key)) {
                    continue;
                }
                bfParams.append(key).append("=").append(value).append("&");
            }
            if (StringUtils.isBlank(bfParams)) {
                bfParams.append(request.getQueryString());
            }
        }
        return bfParams;
    }

}
