/** 
 * 包名: package com.imobpay.model.system; <br/> 
 * 添加时间: 2017年5月19日 下午1:38:48 <br/> 
 */
/**
 *  <pre>	
 *  Project Name:ScorePlatform .</br>
 *  File: SysUser.java .</br>
 *  Package Name:com.imobpay.model.system .</br>
 *  Date      Author       Changes .</br>
 *  2017年5月19日   Ferry Chen     Create  .</br>
 *  Description: .</br>
 *  Copyright 2014-2015 Ferry Chen  FINANCE Services Co.,Ltd. All rights reserved..</br>
 *  <pre>	
 */
package com.imobpay.model.system;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imobpay.model.BaseModel;

/**
 * 类名: SysUser <br/>
 * 作用：用户<br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月19日 下午1:38:48 <br/>
 */
public class SysUser extends BaseModel {

    /** (一句话描述) */
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private String userId;
    /** 登录名 */
    private String loginName;
    /** 登录密码 */
    private String password;
    /** 真实名称 */
    private String realName;
    /** 手机号码 */
    private String mobilNo;
    /** 邮箱 */
    private String mail;
    /** 注册日期 */
    private String regDate;
    /** 状态 1--有效，0--无效 */
    private String status;
    /** 角色ID */
    private String roleId;
    /** 角色名 */
    private String roleName;

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
     * 返回类型：@return logonName .<br/>
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return passWord .<br/>
     */
    public String getPassword() {
        return password;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return realName .<br/>
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return mobilNo .<br/>
     */
    public String getMobilNo() {
        return mobilNo;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return mail .<br/>
     */
    public String getMail() {
        return mail;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return regDate .<br/>
     */
    public String getRegDate() {
        return regDate;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return status .<br/>
     */
    public String getStatus() {
        return status;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月19日 下午1:44:26 <br/>
     * 参数: @param userId 设置值. <br/>
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月19日 下午1:44:26 <br/>
     * 参数: @param loginName 设置值. <br/>
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月19日 下午1:44:26 <br/>
     * 参数: @param password 设置值. <br/>
     */
    @JsonIgnore
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月19日 下午1:44:26 <br/>
     * 参数: @param realName 设置值. <br/>
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月19日 下午1:44:26 <br/>
     * 参数: @param mobilNo 设置值. <br/>
     */
    public void setMobilNo(String mobilNo) {
        this.mobilNo = mobilNo;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月19日 下午1:44:26 <br/>
     * 参数: @param mail 设置值. <br/>
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月19日 下午1:44:26 <br/>
     * 参数: @param regDate 设置值. <br/>
     */
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月19日 下午1:44:26 <br/>
     * 参数: @param status 设置值. <br/>
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return roleId .<br/>
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月19日 下午1:46:36 <br/>
     * 参数: @param roleId 设置值. <br/>
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return roleName .<br/>
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年6月15日 上午10:13:35 <br/>
     * 参数: @param  roleName 设置值.  <br/>
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
