/** 
 * 包名: package com.imobpay.service.system; <br/> 
 * 添加时间: 2017年5月22日 上午11:30:46 <br/> 
 */
package com.imobpay.service.system;

import java.util.List;

import com.imobpay.commons.result.PageInfo;
import com.imobpay.model.system.SysMenu;

/**
 * 类名: ISysMenuService <br/>
 * 作用：菜单 <br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月22日 上午11:30:46 <br/>
 */
public interface ISysMenuService {

    /**
     * 
     * 【方法名】 : 依据用户ID查菜单 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:18:11 .<br/>
     * 【参数】： .<br/>
     * 
     * @param userId
     *            userId
     * @return .<br/>
     */
    public List<SysMenu> selectMenuByUserId(String userId);

    /**
     * 
     * 【方法名】 :列表 查询 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月16日 下午5:41:58 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysMenu
     *            SysMenu
     * @return .<br/>
     */
    public PageInfo selectMenuList(SysMenu sysMenu);

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
     * 【方法名】 : 修改角色菜单. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月19日 下午2:10:20 .<br/>
     * 【参数】： .<br/>
     * 
     * @param roleId
     *            roleId
     * @param list
     *            SysMenu
     * @return .<br/>
     */
    public int updateRoleMenu(String roleId, List<SysMenu> list);

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
     * 【方法名】 : (这里用一句话描述这个方法的作用). <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年9月22日 上午9:43:45 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysMenu SysMenu
     * @return .<br/>
     */
    public int selectMenuCount(SysMenu sysMenu);

}
