/** 
 * 包名: package com.imobpay.model.system; <br/> 
 * 添加时间: 2017年5月22日 下午3:39:55 <br/> 
 */
package com.imobpay.model.system;

import com.imobpay.model.BaseModel;

/**
 * 类名: SysUserOperLog <br/>
 * 作用：用户操作日志<br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月22日 下午3:39:55 <br/>
 */
@SuppressWarnings("serial")
public class SysUserOperLog extends BaseModel {

    /** 操作ID */
    private String operId;
    /** 用户ID */
    private String userId;
    /** 操作类型 */
    private String operType;
    /** 操作描述 */
    private String operDesc;
    /** 操作时间 */
    private String operTime;
    /** 模块名 */
    private String moduleName;
    /** Ip地址 */
    private String ipAddr;
    /** 执行时间 */
    private String actionTime;
    /** 操作内容 */
    private String operContent;

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return operId .<br/>
     */
    public String getOperId() {
        return operId;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return userId .<br/>
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return operType .<br/>
     */
    public String getOperType() {
        return operType;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return operDesc .<br/>
     */
    public String getOperDesc() {
        return operDesc;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return operTime .<br/>
     */
    public String getOperTime() {
        return operTime;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return moduleName .<br/>
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return ipAddr .<br/>
     */
    public String getIpAddr() {
        return ipAddr;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return actionTime .<br/>
     */
    public String getActionTime() {
        return actionTime;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月22日 下午3:42:33 <br/>
     * 参数: @param operId 设置值. <br/>
     */
    public void setOperId(String operId) {
        this.operId = operId;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月22日 下午3:42:33 <br/>
     * 参数: @param userId 设置值. <br/>
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月22日 下午3:42:33 <br/>
     * 参数: @param operType 设置值. <br/>
     */
    public void setOperType(String operType) {
        this.operType = operType;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月22日 下午3:42:33 <br/>
     * 参数: @param operDesc 设置值. <br/>
     */
    public void setOperDesc(String operDesc) {
        this.operDesc = operDesc;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月22日 下午3:42:33 <br/>
     * 参数: @param operTime 设置值. <br/>
     */
    public void setOperTime(String operTime) {
        this.operTime = operTime;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月22日 下午3:42:33 <br/>
     * 参数: @param moduleName 设置值. <br/>
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月22日 下午3:42:33 <br/>
     * 参数: @param ipAddr 设置值. <br/>
     */
    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月22日 下午3:42:33 <br/>
     * 参数: @param actionTime 设置值. <br/>
     */
    public void setActionTime(String actionTime) {
        this.actionTime = actionTime;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return operContent .<br/>
     */
    public String getOperContent() {
        return operContent;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月22日 下午4:35:10 <br/>
     * 参数: @param operContent 设置值. <br/>
     */
    public void setOperContent(String operContent) {
        this.operContent = operContent;
    }

}
