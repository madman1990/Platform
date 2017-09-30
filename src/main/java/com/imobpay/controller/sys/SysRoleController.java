/** 
 * 包名: package com.imobpay.controller.sys; <br/> 
 * 添加时间: 2017年5月22日 下午4:56:44 <br/> 
 */
package com.imobpay.controller.sys;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imobpay.commons.base.BaseController;
import com.imobpay.model.system.SysRole;
import com.imobpay.service.system.ISysRoleService;

/**
 * 类名: SysRoleController <br/>
 * 作用：角色<br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月22日 下午4:56:44 <br/>
 */
@Controller
@RequestMapping("/role")
public class SysRoleController extends BaseController {
    /** 角色服务 */
    @Autowired
    private ISysRoleService sysRoleService;

    /**
     * 
     * 【方法名】 : 进入角色页面. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:09:36 .<br/>
     * 【参数】： .<br/>
     * 
     * @return .<br/>
     */
    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public String manager() {
        return "/sys/role";
    }

    /**
     * 
     * 【方法名】 : 角色列表 . <br/>
     * 【时间】： 2017年5月23日 上午10:10:00 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysRole
     *            sysRole
     * @return .<br/>
     */
    @RequestMapping(value = "/rolelist", method = RequestMethod.POST)
    @ResponseBody
    public Object selectRoleList(SysRole sysRole) {
        return sysRoleService.selectRoleList(sysRole);
    }

    /**
     * 
     * 【方法名】 : 修改角色 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月24日 下午7:11:20 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysRole
     *            SysRole
     * @return .<br/>
     */
    @RequestMapping(value = "/updateRole", method = RequestMethod.POST)
    @ResponseBody
    public Object updateRole(SysRole sysRole) {
        int exists = sysRoleService.selectRoleListCount(sysRole);
        if (exists > 0) {
            return renderError("角色名已被使用，请重新输入");
        }
        int result = sysRoleService.updateRole(sysRole);
        if (result > 0) {
            return renderSuccess("更新成功");
        }
        return renderError("更新失败");
    }

    /**
     * 
     * 【方法名】 : 插入角色. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月15日 上午10:50:49 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysRole
     *            SysRole
     * @return .<br/>
     */
    @RequestMapping(value = "/insertRole", method = RequestMethod.POST)
    @ResponseBody
    public Object insertRole(SysRole sysRole) {
        int exists = sysRoleService.selectRoleListCount(sysRole);
        if (exists > 0) {
            return renderError("角色名已被使用，请重新输入");
        }
        int result = sysRoleService.insertRole(sysRole);
        if (result > 0) {
            return renderSuccess("插入成功");
        }
        return renderError("插入失败");
    }

    /**
     * 
     * 【方法名】 : 检查角色作用 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月15日 上午10:50:53 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysRole
     *            SysRole
     * @return .<br/>
     */
    @RequestMapping(value = "/checkExist", method = RequestMethod.POST)
    @ResponseBody
    public Object checkExist(SysRole sysRole) {
        Map<String, Object> result = sysRoleService.selectUserExistByRoleId(sysRole.getRoleId());
        return renderSuccess(result);
    }

    /**
     * 
     * 【方法名】 : 删除角色. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月15日 上午10:50:56 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysRole
     *            SysRole
     * @return .<br/>
     */
    @RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteRole(SysRole sysRole) {
        int result = sysRoleService.deleteRole(sysRole);
        if (result > 0) {
            return renderSuccess("删除成功");
        }
        return renderError("删除失败");
    }

}
