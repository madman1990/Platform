package com.imobpay.commons.result;

import java.io.Serializable;

/**
 * 
 * <pre>
 * 【类型】: Result <br/> 
 * 【作用】: 操作结果集. <br/>  
 * 【时间】：2017年5月23日 上午9:49:24 <br/> 
 * 【作者】：Ferry Chen <br/>
 * </pre>
 */
public class Result implements Serializable {

    /** */
    private static final long serialVersionUID = 5576237395711742681L;
    /** 结束类型 */
    private boolean success = false;
    /** 消息 */
    private String msg = "";
    /** 返回对象 */
    private Object obj = null;

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return success .<br/>
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return msg .<br/>
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return obj .<br/>
     */
    public Object getObj() {
        return obj;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月23日 上午9:49:43 <br/>
     * 参数: @param success 设置值. <br/>
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月23日 上午9:49:43 <br/>
     * 参数: @param msg 设置值. <br/>
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月23日 上午9:49:43 <br/>
     * 参数: @param obj 设置值. <br/>
     */
    public void setObj(Object obj) {
        this.obj = obj;
    }

}
