package com.imobpay.commons.scan;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.imobpay.commons.log.LogPay;
import com.imobpay.commons.result.Result;
import com.imobpay.commons.utils.BeanUtils;
import com.imobpay.commons.utils.WebUtils;

/**
 * 
 * <pre>
 * 【类型】: ExceptionResolver <br/> 
 * 【作用】: 异常处理，对ajax类型的异常返回ajax错误，避免页面问题. <br/>  
 * 【时间】：2017年5月23日 上午9:50:51 <br/> 
 * 【作者】：Ferry Chen <br/>
 * </pre>
 */
@Component
@SuppressWarnings("unchecked")
public class ExceptionResolver implements HandlerExceptionResolver {
    /** */
    @Autowired
    private JacksonObjectMapper jacksonObjectMapper;

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        // log记录异常
        LogPay.error(e.getMessage(), e);
        // 非控制器请求照成的异常
        if (!(handler instanceof HandlerMethod)) {
            return new ModelAndView("error/500");
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        if (WebUtils.isAjax(handlerMethod)) {
            Result result = new Result();
            result.setMsg("系统处理处理异常");
            MappingJackson2JsonView view = new MappingJackson2JsonView();
            view.setObjectMapper(jacksonObjectMapper);
            view.setContentType("text/html;charset=UTF-8");
            ModelAndView vi = new ModelAndView(view, BeanUtils.toMap(result));
            return vi;
        }

        // 页面指定状态为500，便于上层的resion或者nginx的500页面跳转，由于error/500不适合对用户展示
        return new ModelAndView("error/500").addObject("error", "系统处理异常");
    }

}