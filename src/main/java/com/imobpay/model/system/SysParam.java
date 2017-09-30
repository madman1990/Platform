/** 
 * 包名: package com.imobpay.model.system; <br/> 
 * 添加时间: 2017年5月24日 下午6:17:27 <br/> 
 */
package com.imobpay.model.system;

import com.imobpay.model.BaseModel;

/**
 * 类名: SysParam1 <br/>
 * 作用：TODO(简单一句话描述)<br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月24日 下午6:17:27 <br/>
 */
@SuppressWarnings("serial")
public class SysParam extends BaseModel {

    /** 参数编码 */
    private String paramCode;
    /** 参数类型 */
    private String paramType;
    /** 参数名称 */
    private String paramName;
    /** 参数值1 */
    private String paramValue1;
    /** 参数值2 */
    private String paramValue2;
    /** 备注 */
    private String memo;

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return paramCode .<br/>
     */
    public String getParamCode() {
        return paramCode;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return paramType .<br/>
     */
    public String getParamType() {
        return paramType;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return paramName .<br/>
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return paramValue1 .<br/>
     */
    public String getParamValue1() {
        return paramValue1;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return paramValue2 .<br/>
     */
    public String getParamValue2() {
        return paramValue2;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return memo .<br/>
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月24日 下午6:16:19 <br/>
     * 参数: @param paramCode 设置值. <br/>
     */
    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月24日 下午6:16:19 <br/>
     * 参数: @param paramType 设置值. <br/>
     */
    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月24日 下午6:16:19 <br/>
     * 参数: @param paramName 设置值. <br/>
     */
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月24日 下午6:16:19 <br/>
     * 参数: @param paramValue1 设置值. <br/>
     */
    public void setParamValue1(String paramValue1) {
        this.paramValue1 = paramValue1;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月24日 下午6:16:19 <br/>
     * 参数: @param paramValue2 设置值. <br/>
     */
    public void setParamValue2(String paramValue2) {
        this.paramValue2 = paramValue2;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月24日 下午6:16:19 <br/>
     * 参数: @param memo 设置值. <br/>
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

}
