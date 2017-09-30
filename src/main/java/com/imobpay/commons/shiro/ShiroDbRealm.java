package com.imobpay.commons.shiro;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.imobpay.commons.log.LogPay;
import com.imobpay.constant.GlobalConstant;
import com.imobpay.model.system.SysMenu;
import com.imobpay.model.system.SysRole;
import com.imobpay.model.system.SysUser;
import com.imobpay.service.system.ISysMenuService;
import com.imobpay.service.system.ISysRoleService;
import com.imobpay.service.system.ISysUserService;

/**
 * 
 * <pre>
 * 【类型】: ShiroDbRealm <br/> 
 * 【作用】: shiro权限认证. <br/>  
 * 【时间】：2017年5月23日 上午9:52:24 <br/> 
 * 【作者】：Ferry Chen <br/>
 * </pre>
 */
public class ShiroDbRealm extends AuthorizingRealm {
    /** */
    @Autowired
    private ISysUserService sysUserService;
    /** */
    @Autowired
    private ISysRoleService sysRoleService;
    /** */
    @Autowired
    private ISysMenuService sysMenuSerive;

    /**
     * 
     * 【方法名】 : (这里用一句话描述这个方法的作用). <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午9:52:52 .<br/>
     * 【参数】： .<br/>
     * 
     * @param cacheManager 
     * @param matcher 
     *            .<br/>
     */
    public ShiroDbRealm(CacheManager cacheManager, CredentialsMatcher matcher) {
        super(cacheManager, matcher);
    }

     
    @SuppressWarnings("rawtypes")
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

        LogPay.info("Shiro开始登录认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        SysUser user = new SysUser();
        user.setLoginName(token.getUsername());
        List<SysUser> list = sysUserService.selectUserList(user);
        // 账号不存在
        if (list == null || list.isEmpty()) {
            return null;
        }
        SysUser loginUser = list.get(0);
        // 账号未启用
        if (loginUser.getStatus() == GlobalConstant.STATUS_VALID) {
            return null;
        }
        // 读取用户的url和角色
        List<SysRole> roleList = sysRoleService.selectRolesByUserId(loginUser.getUserId());

        Set<String> roleSet = new HashSet<String>();
        if (null != roleList && roleList.size() > 0) {
            for (Iterator iterator = roleList.iterator(); iterator.hasNext();) {
                SysRole sysRole = (SysRole) iterator.next();
                roleSet.add(sysRole.getRoleId());
            }
        }
        List<SysMenu> userMenuList = sysMenuSerive.selectMenuByUserId(loginUser.getUserId());

        Set<String> urlSet = new HashSet<String>();
        if (null != userMenuList && userMenuList.size() > 0) {
            for (Iterator iterator = userMenuList.iterator(); iterator.hasNext();) {
                SysMenu sysMenu = (SysMenu) iterator.next();
                urlSet.add(sysMenu.getMenuUrl());
            }
        }

        ShiroUser shiroUser = new ShiroUser(loginUser.getUserId(), loginUser.getLoginName(), loginUser.getRealName(), urlSet);
        shiroUser.setRoles(roleSet);
        roleSet = null;
        urlSet = null;
        // 认证缓存信息
        return new SimpleAuthenticationInfo(shiroUser, loginUser.getPassword().toCharArray(), getName());
    }

 
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(shiroUser.getRoles());
        info.addStringPermissions(shiroUser.getUrlSet());

        return info;
    }

    @Override
    public void onLogout(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        removeUserCache(shiroUser);
    }

    /**
     * 清除用户缓存
     * 
     * @param shiroUser 
     */
    public void removeUserCache(ShiroUser shiroUser) {
        removeUserCache(shiroUser.getLoginName());
    }

    /**
     * 清除用户缓存
     * 
     * @param loginName 
     */
    public void removeUserCache(String loginName) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection();
        principals.add(loginName, super.getName());
        super.clearCachedAuthenticationInfo(principals);
    }
}
