/** 
 * 包名: package com.imobpay.model.system; <br/> 
 * 添加时间: 2017年5月19日 下午3:23:11 <br/> 
 */
package com.imobpay.model.system;

import com.imobpay.model.BaseModel;

/**
 * 类名: SysMenu <br/>
 * 作用：菜单<br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月19日 下午3:23:11 <br/>
 */
@SuppressWarnings("serial")
public class SysMenu extends BaseModel {

    /** 菜单ID */
    private String menuCode;
    /** 菜单名称 */
    private String menuName;
    /** 菜单描述 */
    private String menuDesc;
    /** 菜单URL */
    private String menuUrl;
    /** 上级菜单ID */
    private String upMenuCode;
    /** 菜单级别 */
    private String menuLevel;
    /** 状态 1--有效，0--无效 */
    private String status;
    /** 是否有子节点，1 有，0 没有 */
    private String childCode;
    /** 上级菜单 */
    private String upMenuName;
    /** 角色ID */
    private String roleId;

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return menuCode .<br/>
     */
    public String getMenuCode() {
        return menuCode;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return menuName .<br/>
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return menuDesc .<br/>
     */
    public String getMenuDesc() {
        return menuDesc;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return menuUrl .<br/>
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return menuLevel .<br/>
     */
    public String getMenuLevel() {
        return menuLevel;
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
     * 创建时间：2017年5月19日 下午3:31:51 <br/>
     * 参数: @param menuCode 设置值. <br/>
     */
    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月19日 下午3:31:51 <br/>
     * 参数: @param menuName 设置值. <br/>
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月19日 下午3:31:51 <br/>
     * 参数: @param menuDesc 设置值. <br/>
     */
    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月19日 下午3:31:51 <br/>
     * 参数: @param menuUrl 设置值. <br/>
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月19日 下午3:31:51 <br/>
     * 参数: @param menuLevel 设置值. <br/>
     */
    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月19日 下午3:31:51 <br/>
     * 参数: @param status 设置值. <br/>
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return childCode .<br/>
     */
    public String getChildCode() {
        return childCode;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月22日 上午11:56:14 <br/>
     * 参数: @param childCode 设置值. <br/>
     */
    public void setChildCode(String childCode) {
        this.childCode = childCode;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return upMenuCode .<br/>
     */
    public String getUpMenuCode() {
        return upMenuCode;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月22日 下午3:04:05 <br/>
     * 参数: @param upMenuCode 设置值. <br/>
     */
    public void setUpMenuCode(String upMenuCode) {
        this.upMenuCode = upMenuCode;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return upMenuName .<br/>
     */
    public String getUpMenuName() {
        return upMenuName;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年6月16日 下午5:38:06 <br/>
     * 参数: @param upMenuName 设置值. <br/>
     */
    public void setUpMenuName(String upMenuName) {
        this.upMenuName = upMenuName;
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
     * 创建时间：2017年6月19日 下午3:33:57 <br/>
     * 参数: @param roleId 设置值. <br/>
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}
