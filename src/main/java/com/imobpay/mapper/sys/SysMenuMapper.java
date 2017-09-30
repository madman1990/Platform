/** 
 * 包名: package com.imobpay.mapper.sys; <br/> 
 * 添加时间: 2017年5月22日 上午11:59:14 <br/> 
 */
package com.imobpay.mapper.sys;

import java.util.List;

import com.imobpay.model.system.SysMenu;

/**
 * 类名: SysMenuMapper <br/>
 * 作用： 菜单 <br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月22日 上午11:59:14 <br/>
 */
public interface SysMenuMapper {

    /**
     * 
     * 【方法名】 : 依据用户ID查菜单 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:12:09 .<br/>
     * 【参数】： .<br/>
     * 
     * @param userId
     *            userId
     * @return .<br/>
     */
    public List<SysMenu> selectMenuByUserId(String userId);

    /**
     * 
     * 【方法名】 : 查询列表 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月16日 下午5:40:46 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysMenu
     *            SysMenu
     * @return .<br/>
     */
    public List<SysMenu> selectMenuList(SysMenu sysMenu);

    /**
     * 
     * 【方法名】 : 查询 总数 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月16日 下午5:40:49 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysMenu
     *            SysMenu
     * @return .<br/>
     */
    public int selectMenuCount(SysMenu sysMenu);

    /**
     * 
     * 【方法名】 : 查询一级菜单 (这里用一句话描述这个方法的作用). <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月19日 上午10:56:43 .<br/>
     * 【参数】： .<br/>
     * 
     * @return .<br/>
     */
    public List<SysMenu> selectUpMenu();

    /**
     * 
     * 【方法名】 : . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月19日 上午11:19:11 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysMenu
     *            SysMenu
     * @return .<br/>
     */
    public int insertMenu(SysMenu sysMenu);

    /**
     * 
     * 【方法名】 : (这里用一句话描述这个方法的作用). <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月19日 上午11:19:15 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysMenu
     *            SysMenu
     * @return .<br/>
     */
    public int updateMenu(SysMenu sysMenu);

    /**
     * 
     * 【方法名】 : 检查菜单使用情况 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月19日 上午11:31:12 .<br/>
     * 【参数】： .<br/>
     * 
     * @param menuCode
     *            menuCode
     * @return .<br/>
     */
    public int checkUsedMenu(String menuCode);

    /**
     * 
     * 【方法名】 : 查询角色菜单 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月19日 下午2:08:51 .<br/>
     * 【参数】： .<br/>
     * 
     * @param roleId
     *            roleId
     * @return .<br/>
     */
    public List<SysMenu> selectRoleMenu(String roleId);

    /**
     * 
     * 【方法名】 :依据角色Id查询菜单 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月19日 下午2:47:57 .<br/>
     * 【参数】： .<br/>
     * 
     * @param roleId
     *            roleId
     * @return .<br/>
     */
    public List<SysMenu> selectMenuByRoleId(String roleId);

    /**
     * 
     * 【方法名】 : 角色菜单. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月19日 下午2:08:54 .<br/>
     * 【参数】： .<br/>
     * 
     * @param list
     *            SysMenu
     * @return .<br/>
     */
    public int insertRoleMenu(List<SysMenu> list);

    /**
     * 
     * 【方法名】 : 角色菜单. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月19日 下午2:08:56 .<br/>
     * 【参数】： .<br/>
     * 
     * @param roleId
     *            roleId
     * @return .<br/>
     */
    public int deleteRoleMenu(String roleId);
}
