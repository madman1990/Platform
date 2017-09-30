/** 
 * 包名: package com.imobpay.controller.sys; <br/> 
 * 添加时间: 2017年5月22日 上午11:27:46 <br/> 
 */
package com.imobpay.controller.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.imobpay.commons.base.BaseController;
import com.imobpay.commons.log.LogPay;
import com.imobpay.commons.result.PageInfo;
import com.imobpay.commons.utils.StringUtils;
import com.imobpay.model.system.SysMenu;
import com.imobpay.model.system.SysRole;
import com.imobpay.service.system.ISysMenuService;
import com.imobpay.service.system.ISysRoleService;

/**
 * 类名: SysMenucontroller <br/>
 * 作用：菜单 <br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月22日 上午11:27:46 <br/>
 */
@Controller
@RequestMapping("/menu")
public class SysMenucontroller extends BaseController {
    /** 菜单服务 */
    @Autowired
    private ISysMenuService sysMenuService;
    /** 角色服务 */
    @Autowired
    private ISysRoleService sysRoleService;

    /**
     * 
     * 【方法名】 : 获取用户菜单 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:08:28 .<br/>
     * 【参数】： .<br/>
     * 
     * @param request
     *            request
     * @return .<br/>
     */
    @RequestMapping(value = "/getMenuTree", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> getMenuTree(HttpServletRequest request) {
        List<SysMenu> userMenuList = sysMenuService.selectMenuByUserId(getUserId());
        return createMenuTree(userMenuList, null);
    }

    /**
     * 
     * 【方法名】 : 菜单转换成树. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:08:47 .<br/>
     * 【参数】： .<br/>
     * 
     * @param userMenuList
     *            userMenuList
     * @param parantCode
     *            parantCode
     * @return .<br/>
     */
    private List<Map<String, Object>> createMenuTree(List<SysMenu> userMenuList, String parantCode) {
        List<Map<String, Object>> aulist = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < userMenuList.size(); i++) {
            Map<String, Object> map = null;
            SysMenu menu = userMenuList.get(i);

            if ((null == parantCode && parantCode == menu.getUpMenuCode()) || (parantCode != null && parantCode.equals(menu.getUpMenuCode()))) {
                map = new HashMap<String, Object>();
                map.put("id", menu.getMenuCode());
                map.put("text", menu.getMenuName());
                Map<String, Object> z = new HashMap<String, Object>();
                List<Map<String, Object>> strlist = new ArrayList<Map<String, Object>>();
                z.put("url", menu.getMenuUrl());
                strlist.add(z);
                map.put("attributes", z);
                z = null;
                if ("0".equals(menu.getChildCode())) {
                    map.put("state", "open");
                } else {
                    map.put("state", "open");
                    map.put("children", createMenuTree(userMenuList, menu.getMenuCode()));

                }

            }
            if (map != null) {
                aulist.add(map);
            }
        }
        return aulist;
    }

    /**
     * 
     * 【方法名】 : 进入 页面. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月16日 上午9:55:28 .<br/>
     * 【参数】： .<br/>
     * 
     * @param req
     *            HttpServletRequest
     * @return .<br/>
     */
    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public ModelAndView manager(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sys/menu");
        mv.addObject("menu", sysMenuService.selectUpMenu());
        return mv;
    }

    /**
     * 
     * 【方法名】 : 列表 查询 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月15日 上午11:48:12 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysMenu
     *            sysMenu
     * @return .<br/>
     */
    @RequestMapping(value = "/selectList", method = RequestMethod.POST)
    @ResponseBody
    public PageInfo selectSysUserList(SysMenu sysMenu) {
        return sysMenuService.selectMenuList(sysMenu);
    }

    /**
     * 
     * 【方法名】 : 新增菜单 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月19日 上午11:25:38 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysMenu
     *            SysMenu
     * @return .<br/>
     */
    @RequestMapping(value = "/insertMenu", method = RequestMethod.POST)
    @ResponseBody
    public Object insertMenu(SysMenu sysMenu) {
        try {
            int count = sysMenuService.selectMenuCount(sysMenu);
            if (count > 0) {
                return renderError("菜单名称已被使用，请重新输入");
            }
            if (StringUtils.isBlank(sysMenu.getUpMenuCode())) {
                sysMenu.setMenuLevel("1");
            } else {
                sysMenu.setMenuLevel("2");
            }
            sysMenuService.insertMenu(sysMenu);
            return renderSuccess("新增成功");
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
            return renderError("新增失败");
        }
    }

    /**
     * 
     * 【方法名】 : 修改菜单 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月19日 上午11:25:42 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysMenu
     *            SysMenu
     * @return .<br/>
     */
    @RequestMapping(value = "/updateMenu", method = RequestMethod.POST)
    @ResponseBody
    public Object updateMenu(SysMenu sysMenu) {
        try {
            int count = sysMenuService.selectMenuCount(sysMenu);
            if (count > 0) {
                return renderError("菜单名称已被使用，请重新输入");
            }
            if (StringUtils.isBlank(sysMenu.getUpMenuCode())) {
                sysMenu.setMenuLevel("1");
            } else {
                sysMenu.setMenuLevel("2");
            }
            sysMenuService.updateMenu(sysMenu);
            return renderSuccess("修改成功");
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
            return renderError("修改失败");
        }
    }

    /**
     * 
     * 【方法名】 :删除菜单 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月19日 上午11:27:43 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysMenu
     *            SysMenu
     * @return .<br/>
     */
    @RequestMapping(value = "/deleteMenu", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteMenu(SysMenu sysMenu) {
        try {
            int total = sysMenuService.checkUsedMenu(sysMenu.getMenuCode());
            if (total > 0) {
                return renderError("菜单正被使用不能删除");
            }
            sysMenu.setStatus("3");
            sysMenuService.updateMenu(sysMenu);
            return renderSuccess("删除成功");
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
            return renderError("删除失败");
        }
    }

    /**
     * 
     * 【方法名】 : 权限管理. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月19日 下午2:29:31 .<br/>
     * 【参数】： .<br/>
     * 
     * @param req
     *            HttpServletRequest
     * @return .<br/>
     */
    @RequestMapping(value = "/authManager", method = RequestMethod.GET)
    public ModelAndView roleMenuManager(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sys/auth");
        List<SysRole> rList = sysRoleService.selectSysRoleList();
        mv.addObject("ROLES", rList);
        return mv;
    }

    /**
     * 
     * 【方法名】 : 获取角色菜单 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:08:28 .<br/>
     * 【参数】： .<br/>
     * 
     * @param roleId
     *            roleId
     * @return .<br/>
     */
    @RequestMapping(value = "/getRoleMenuTree", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> getRoleMenuTree(String roleId) {
        List<SysMenu> userMenuList = sysMenuService.selectRoleMenu(roleId);
        List<SysMenu> roleMenuList = null;
        if (StringUtils.isNotBlank(roleId)) {
            roleMenuList = sysMenuService.selectMenuByRoleId(roleId);
        }
        return creatRoleMenuTree(userMenuList, roleMenuList, null);
    }

    /**
     * 
     * 【方法名】 : 菜单转换成树. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:08:47 .<br/>
     * 【参数】： .<br/>
     * 
     * @param mnuList
     *            userMenuList
     * @param roleMenuList
     *            roleMenuList
     * @param parantCode
     *            parantCode
     * @return .<br/>
     */
    @SuppressWarnings("unused")
    private List<Map<String, Object>> creatRoleMenuTree(List<SysMenu> mnuList, List<SysMenu> roleMenuList, String parantCode) {
        List<Map<String, Object>> aulist = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < mnuList.size(); i++) {
            Map<String, Object> map = null;
            SysMenu menu = mnuList.get(i);

            if ((null == parantCode && parantCode == menu.getUpMenuCode()) || (parantCode != null && parantCode.equals(menu.getUpMenuCode()))) {
                map = new HashMap<String, Object>();
                map.put("id", menu.getMenuCode());
                map.put("text", menu.getMenuName());
                if (null != roleMenuList) {
                    Iterator<SysMenu> it = roleMenuList.iterator();
                    while (it.hasNext()) {
                        SysMenu m = it.next();
                        if (menu.getMenuCode().equals(m.getMenuCode())) {
                            map.put("checked", true);
                            it.remove();
                            break;
                        }
                    }
                }
                if ("0".equals(menu.getChildCode())) {
                    map.put("state", "open");
                } else {
                    map.put("state", "open");
                    map.put("children", creatRoleMenuTree(mnuList, roleMenuList, menu.getMenuCode()));
                }
            }
            if (map != null) {
                aulist.add(map);
            }
        }
        return aulist;
    }

    /**
     * 
     * 【方法名】 : (这里用一句话描述这个方法的作用). <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月19日 下午3:37:33 .<br/>
     * 【参数】： .<br/>
     * 
     * @param roleId
     *            roleId
     * @param powerIds
     *            powerIds
     * @return .<br/>
     */
    @RequestMapping(value = "/saveRoleMenu", method = RequestMethod.POST)
    @ResponseBody
    public Object saveRoleMenu(String roleId, String powerIds) {
        String[] menus = powerIds.split(",");
        List<SysMenu> mList = null;
        boolean authFlag = true;
        if (null != menus) {
            mList = new ArrayList<SysMenu>();
            for (int i = 0; i < menus.length; i++) {
                String menuCode = menus[i];
                if ("29".equals(menuCode)) {
                    authFlag = false;
                }
                SysMenu menu = new SysMenu();
                menu.setRoleId(roleId);
                menu.setMenuCode(menuCode);
                mList.add(menu);
            }

            if ("1".equals(roleId) && authFlag) {
                SysMenu menu = new SysMenu();
                menu.setRoleId(roleId);
                menu.setMenuCode("29");
                mList.add(menu);
            }
            try {
                sysMenuService.updateRoleMenu(roleId, mList);
                return renderSuccess("保存成功");
            } catch (Exception e) {
                return renderError("保存失败");
            }
        } else {
            return renderError("请选择菜单 ");
        }

    }

}
