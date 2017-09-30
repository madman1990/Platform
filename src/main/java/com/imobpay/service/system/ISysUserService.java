/** 
 * 包名: package com.imobpay.service.system; <br/> 
 * 添加时间: 2017年5月19日 下午1:47:52 <br/> 
 */
package com.imobpay.service.system;

import java.util.List;

import com.imobpay.commons.result.PageInfo;
import com.imobpay.model.system.SysUser;

/**
 * 类名: ISysUserService <br/>
 * 作用：用户Service<br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月19日 下午1:47:52 <br/>
 */
public interface ISysUserService {

    /**
     * 
     * 【方法名】 : 查询用户信息 <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月19日 下午3:42:37 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysUser
     *            SysUser
     * @return .<br/>
     */
    public List<SysUser> selectUserList(SysUser sysUser);

    /**
     * 
     * 【方法名】 : 依据用户ID查询 用户信息. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:19:40 .<br/>
     * 【参数】： .<br/>
     * 
     * @param userId
     *            userId
     * @return .<br/>
     */
    public SysUser selectById(String userId);

    /**
     * 
     * 【方法名】 : 修改用户信息 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:19:43 .<br/>
     * 【参数】： .<br/>
     * 
     * @param userId
     *            userId
     * @param password
     *            password
     * @return .<br/>
     */
    public int updatePwdByUserId(String userId, String password);

    /**
     * 
     * 【方法名】 : 插入用户信息. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月15日 上午10:23:16 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysUser
     *            SysUser
     * @return .<br/>
     */
    public int insertUser(SysUser sysUser);

    /**
     * 
     * 【方法名】 : 查询用户列表 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月15日 上午10:23:32 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysUser
     *            SysUser
     * @return .<br/>
     */
    public PageInfo selectSysUserList(SysUser sysUser);

    /**
     * 
     * 【方法名】 : 修改用户. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月16日 下午3:24:19 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysUser
     *            SysUser
     * @return .<br/>
     */
    public int updateUser(SysUser sysUser);

    /**
     * 
     * 【方法名】 : 删除角色. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月16日 下午4:20:05 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysUser
     *            SysUser
     * @return .<br/>
     */
    public int deleteUser(SysUser sysUser);

}
