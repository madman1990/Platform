/**
 *
 */
package com.imobpay.commons.shiro;

import java.io.Serializable;
import java.util.Set;

/**
 * 
 * <pre>
 * 【类型】: ShiroUser <br/> 
 * 【作用】: 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息. <br/>  
 * 【时间】：2017年5月23日 上午9:57:33 <br/> 
 * 【作者】：Ferry Chen <br/>
 * </pre>
 */
public class ShiroUser implements Serializable {
    /** */
    private static final long serialVersionUID = -1373760761780840081L;
    /** 用户ID */
    private String id;
    /** 登录名 */
    private final String loginName;
    /** 真实用户名 */
    private String name;
    /** 访问地址 */
    private Set<String> urlSet;
    /** 角色 */
    private Set<String> roles;

    /**
     * 
     * 【方法名】 : (这里用一句话描述这个方法的作用). <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午9:58:59 .<br/>
     * 【参数】： .<br/>
     * 
     * @param loginName
     *            .<br/>
     */
    public ShiroUser(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 
     * 【方法名】 : (这里用一句话描述这个方法的作用). <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午9:59:02 .<br/>
     * 【参数】： .<br/>
     * 
     * @param id 
     * @param loginName 
     * @param name 
     * @param urlSet 
     *            .<br/>
     */
    public ShiroUser(String id, String loginName, String name, Set<String> urlSet) {
        this.id = id;
        this.loginName = loginName;
        this.name = name;
        this.urlSet = urlSet;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return id .<br/>
     */
    public String getId() {
        return id;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return loginName .<br/>
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return name .<br/>
     */
    public String getName() {
        return name;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return urlSet .<br/>
     */
    public Set<String> getUrlSet() {
        return urlSet;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return roles .<br/>
     */
    public Set<String> getRoles() {
        return roles;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月23日 上午9:58:03 <br/>
     * 参数: @param id 设置值. <br/>
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月23日 上午9:58:03 <br/>
     * 参数: @param name 设置值. <br/>
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月23日 上午9:58:03 <br/>
     * 参数: @param urlSet 设置值. <br/>
     */
    public void setUrlSet(Set<String> urlSet) {
        this.urlSet = urlSet;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月23日 上午9:58:03 <br/>
     * 参数: @param roles 设置值. <br/>
     */
    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    
    @Override
    public String toString() {
        return loginName;
    }
}