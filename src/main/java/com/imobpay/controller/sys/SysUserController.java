package com.imobpay.controller.sys;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.imobpay.commons.annotation.SystemLog;
import com.imobpay.commons.base.BaseController;
import com.imobpay.commons.log.LogPay;
import com.imobpay.commons.result.PageInfo;
import com.imobpay.model.system.SysRole;
import com.imobpay.model.system.SysUser;
import com.imobpay.service.system.ISysRoleService;
import com.imobpay.service.system.ISysUserService;

/**
 * 
 * <pre>
 * 【类型】: SysUserController <br/> 
 * 【作用】: 用户. <br/>  
 * 【时间】：2017年5月23日 上午10:10:28 <br/> 
 * 【作者】：Ferry Chen <br/>
 * </pre>
 */
@Controller
@RequestMapping("/user")
public class SysUserController extends BaseController {
    /** 用户服务 */
    @Autowired
    private ISysUserService sysUserService;
    /** 角色服务 */
    @Autowired
    private ISysRoleService sysRoleService;

    /**
     * 
     * 【方法名】 : 修改密码 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月22日 下午4:55:06 .<br/>
     * 【参数】： .<br/>
     * 
     * @param oldPwd
     *            旧密码
     * @param pwd
     *            新密码
     * @return .<br/>
     */
    @RequestMapping(value = "/editUserPwd", method = RequestMethod.POST)
    @ResponseBody
    @SystemLog(module = "首页", methods = "修改密码")
    public Object editUserPwd(String oldPwd, String pwd) {
        SysUser user = sysUserService.selectById(getUserId());
        if (!user.getPassword().equals(oldPwd)) {
            return renderError("老密码不正确!");
        }
        sysUserService.updatePwdByUserId(getUserId(), pwd);
        return renderSuccess("密码修改成功！");
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
        mv.setViewName("sys/user");
        List<SysRole> rList = sysRoleService.selectSysRoleList();
        mv.addObject("ROLES", rList);
        return mv;
    }

    /**
     * 
     * 【方法名】 : 列表 查询 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月15日 上午11:48:12 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysUser
     *            SysUser
     * @return .<br/>
     */
    @RequestMapping(value = "/selectList", method = RequestMethod.POST)
    @ResponseBody
    public PageInfo selectSysUserList(SysUser sysUser) {
        return sysUserService.selectSysUserList(sysUser);
    }

    /**
     * 
     * 【方法名】 : 新增用户. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月16日 下午3:22:43 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysUser
     *            SysUser
     * @return .<br/>
     */
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    @ResponseBody
    @SystemLog(module = "用户管理", methods = "新增用户 ")
    public Object insertUser(SysUser sysUser) {
        try {
            sysUserService.insertUser(sysUser);
            return renderSuccess("新增成功");
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
            return renderError("新增失败");
        }
    }

    /**
     * 
     * 【方法名】 : 修改用户信息. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月16日 下午3:35:31 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysUser
     *            SysUser
     * @return .<br/>
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    @SystemLog(module = "用户管理", methods = "修改用户 ")
    public Object updateUser(SysUser sysUser) {
        try {
            sysUserService.updateUser(sysUser);
            return renderSuccess("修改成功");
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
            return renderError("修改失败");
        }
    }

    /**
     * 
     * 【方法名】 : 修改密码 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月22日 下午4:55:06 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysUser
     *            sysUser
     * @return .<br/>
     */
    @RequestMapping(value = "/updateUserPwd", method = RequestMethod.POST)
    @ResponseBody
    @SystemLog(module = "用户管理", methods = "修改密码")
    public Object updateUserPwd(SysUser sysUser) {
        sysUserService.updatePwdByUserId(sysUser.getUserId(), sysUser.getPassword());
        return renderSuccess("密码修改成功！");
    }

    /**
     * 
     * 【方法名】 : 修改密码 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月22日 下午4:55:06 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysUser
     *            sysUser
     * @return .<br/>
     */
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    @ResponseBody
    @SystemLog(module = "用户管理", methods = "删除用户 ")
    public Object deleteUser(SysUser sysUser) {
        if (getUserId().equals(sysUser.getUserId())) {
            return renderError("不能删除当前登录用户");
        }
        sysUserService.deleteUser(sysUser);
        return renderSuccess("删除成功！");
    }

    /**
     * 
     * 【方法名】 : (这里用一句话描述这个方法的作用). <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月16日 下午5:06:21 .<br/>
     * 【参数】： .<br/>
     * 
     * @param sysUser
     *            SysUser
     * @return .<br/>
     */
    @RequestMapping(value = "/checkUserName", method = RequestMethod.POST)
    @ResponseBody
    public Object checkUserName(SysUser sysUser) {
        List<SysUser> list = sysUserService.selectUserList(sysUser);
        if (null != list && list.size() > 1) {
            return renderError("登录名重复");
        } else if (null != list && list.size() == 1) {
            if (!list.get(0).getUserId().equals(sysUser.getUserId())) {
                return renderError("登录名重复");
            }
        }
        return renderSuccess();
    }
}
