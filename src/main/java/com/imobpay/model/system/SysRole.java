/** 
 * 包名: package com.imobpay.model.system; <br/> 
 * 添加时间: 2017年5月19日 下午1:39:19 <br/> 
 */
package com.imobpay.model.system;

import com.imobpay.model.BaseModel;

/**
 * 类名: SysRole <br/>
 * 作用：角色<br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月19日 下午1:39:19 <br/>
 */
public class SysRole extends BaseModel {

    /** (一句话描述) */
    private static final long serialVersionUID = 1L;
    
    /** 角色ID */
    private String roleId;
    /** 角色名称 */
    private String roleName;

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return roleId .<br/>
     */
    public String getRoleId() {
        return roleId;
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
     * 创建时间：2017年5月19日 下午1:47:13 <br/>
     * 参数: @param roleId 设置值. <br/>
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月19日 下午1:47:13 <br/>
     * 参数: @param roleName 设置值. <br/>
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
