/** 
 * 包名: package com.imobpay.mapper.sys; <br/> 
 * 添加时间: 2017年5月19日 下午1:52:21 <br/> 
 */
package com.imobpay.mapper.sys;

import java.util.List;

import com.imobpay.model.system.SysUser;

/**
 * 类名: SysUserMapper <br/>
 * 作用：用户(简单一句话描述)<br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月19日 下午1:52:21 <br/>
 */
public interface SysUserMapper {

    /**
     * 
     * 【方法名】 : 查询用户信息 <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月19日 下午3:42:37 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysUser
     *            sysUser
     * @return .<br/>
     */
    public List<SysUser> selectUserList(SysUser sysUser);

    /**
     * 
     * 【方法名】 : 依据用户ID查询用户信息. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:14:12 .<br/>
     * 【参数】： .<br/>
     * 
     * @param userId
     *            userId
     * @return .<br/>
     */
    public SysUser selectUserById(String userId);

    /**
     * 
     * 【方法名】 : 依据用户信息. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:14:18 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysUser
     *            sysUser
     * @return .<br/>
     */
    public int updateByUserId(SysUser sysUser);

    /**
     * 
     * 【方法名】 : 插入用户. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月15日 上午10:19:00 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysUser
     *            SysUser
     * @return .<br/>
     */
    public int insertUser(SysUser sysUser);

    /**
     * 
     * 【方法名】 : 查询 用户列表 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月15日 上午10:19:28 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysUser
     *            SysUser
     * @return .<br/>
     */
    public List<SysUser> selectSysUserList(SysUser sysUser);

    /**
     * 
     * 【方法名】 : 查询 用户 总数. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月15日 上午10:19:31 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysUser
     *            SysUser
     * @return .<br/>
     */
    public int selectSysUserCount(SysUser sysUser);
    
    /**
     * 
     * 【方法名】    : 获取用户ID . <br/> 
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月15日 上午10:38:53 .<br/>
     * 【参数】： .<br/>
     * @return .<br/>
     */
    public int getUserId();
    
    /**
     * 
     * 【方法名】    : 新增用户角色. <br/> 
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月16日 下午3:32:39 .<br/>
     * 【参数】： .<br/>
     * @param sysUser SysUser
     * @return .<br/>
     */
    public int insertUserRole(SysUser sysUser);
    
    /**
     * 
     * 【方法名】    : 删除用户角色. <br/> 
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月16日 下午3:32:43 .<br/>
     * 【参数】： .<br/>
     * @param sysUser SysUser
     * @return .<br/>
     */
    public int deleteUserRole(SysUser sysUser);

}
