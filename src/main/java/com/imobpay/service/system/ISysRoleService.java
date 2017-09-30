/** 
 * 包名: package com.imobpay.service.system.impl; <br/> 
 * 添加时间: 2017年5月19日 下午1:49:05 <br/> 
 */
package com.imobpay.service.system;

import java.util.List;
import java.util.Map;

import com.imobpay.commons.result.PageInfo;
import com.imobpay.model.system.SysRole;

/**
 * 类名: ISysRoleService <br/>
 * 作用：角色Service<br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月19日 下午1:49:05 <br/>
 */
public interface ISysRoleService {

    /**
     * 
     * 【方法名】 : 依据用户ID查询角色信息. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月19日 下午3:44:48 .<br/>
     * 【参数】： .<br/>
     * 
     * @param userId
     *            userId
     * @return .<br/>
     */
    public List<SysRole> selectRolesByUserId(String userId);

    /**
     * 
     * 【方法名】 : 查询角色表列表 . <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:18:35 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysRole
     *            SysRole
     * @return .<br/>
     */
    public PageInfo selectRoleList(SysRole sysRole);

    /**
     * 
     * 【方法名】 : 修改角色. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月24日 下午7:12:17 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysRole
     *            SysRole
     * @return .<br/>
     */
    public int updateRole(SysRole sysRole);

    /**
     * 
     * 【方法名】 : 删除角色. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月15日 上午9:58:23 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysRole
     *            SysRole
     * @return .<br/>
     */
    public int deleteRole(SysRole sysRole);

    /**
     * 
     * 【方法名】 : (这里用一句话描述这个方法的作用). <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月15日 上午10:17:19 .<br/>
     * 【参数】： .<br/>
     * 
     * @return .<br/>
     */
    public List<SysRole> selectSysRoleList();

    /**
     * 
     * 【方法名】 : 查询角色使用数量 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月15日 上午10:33:30 .<br/>
     * 【参数】： .<br/>
     * 
     * @param roleId
     *            角色ID
     * @return .<br/>
     */
    public Map<String, Object> selectUserExistByRoleId(String roleId);

    /**
     * 
     * 【方法名】 :插入角色 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月15日 上午10:42:53 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysRole
     *            SysRole
     * @return .<br/>
     */
    public int insertRole(SysRole sysRole);
    
    public int selectRoleListCount(SysRole sysRole);
}
