package com.imobpay.commons.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import com.imobpay.commons.result.Result;
import com.imobpay.commons.shiro.ShiroUser;
import com.imobpay.commons.utils.BeanUtils;
import com.imobpay.commons.utils.StringEscapeEditor;
import com.imobpay.constant.GlobalConstant;

/**
 * 
 * <pre>
 * 【类型】: BaseController <br/> 
 * 【作用】: 基础 controller. <br/>  
 * 【时间】：2017年5月19日 下午4:09:30 <br/> 
 * 【作者】：Ferry Chen <br/>
 * </pre>
 */
public abstract class BaseController {

    /**
     * 
     * 【方法名】 : init. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:22:05 .<br/>
     * 【参数】： .<br/>
     * 
     * @param binder
     *            .<br/>
     */
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        /**
         * 自动转换日期类型的字段格式
         */
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
        /**
         * 防止XSS攻击
         */
        binder.registerCustomEditor(String.class, new StringEscapeEditor());
    }

    /**
     * 获取当前登录用户对象
     * 
     * @return {ShiroUser}
     */
    public ShiroUser getShiroUser() {
        return (ShiroUser) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 获取当前登录用户id
     * 
     * @return {Long}
     */
    public String getUserId() {
        return this.getShiroUser().getId();
    }

    /**
     * 获取当前登录用户名
     * 
     * @return {String}
     */
    public String getLoginName() {
        return this.getShiroUser().getLoginName();
    }

    /**
     * 获取当前真实用户名
     * 
     * @return {String}
     */
    public String getStaffName() {
        return this.getShiroUser().getName();
    }

    /**
     * ajax失败
     * 
     * @param msg
     *            失败的消息
     * @return {Object}
     */
    public Object renderError(String msg) {
        Result result = new Result();
        result.setMsg(msg);
        ModelAndView view = new ModelAndView();
        view.addObject(BeanUtils.toMap(result));
        return result;
    }

    /**
     * ajax成功
     * 
     * @return {Object}
     */
    public Object renderSuccess() {
        Result result = new Result();
        result.setSuccess(true);
        return result;
    }

    /**
     * ajax成功
     * 
     * @param msg
     *            消息
     * @return {Object}
     */
    public Object renderSuccess(String msg) {
        Result result = new Result();
        result.setSuccess(true);
        result.setMsg(msg);
        return result;
    }

    /**
     * ajax成功
     * 
     * @param obj
     *            成功时的对象
     * @return {Object}
     */
    public Object renderSuccess(Object obj) {
        Result result = new Result();
        result.setMsg(GlobalConstant.EXECU_SUCCESS);
        result.setSuccess(true);
        result.setObj(obj);
        return result;
    }

}
