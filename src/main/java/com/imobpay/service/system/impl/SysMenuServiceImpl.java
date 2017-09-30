/** 
 * 包名: package com.imobpay.service.system.impl; <br/> 
 * 添加时间: 2017年5月22日 上午11:31:13 <br/> 
 */
package com.imobpay.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobpay.commons.result.PageInfo;
import com.imobpay.mapper.sys.SysMenuMapper;
import com.imobpay.model.system.SysMenu;
import com.imobpay.service.system.ISysMenuService;

/**
 * 类名: SysMenuServiceImpl <br/>
 * 作用： 菜单 <br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月22日 上午11:31:13 <br/>
 */
@Service
public class SysMenuServiceImpl implements ISysMenuService {

    /** */
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> selectMenuByUserId(String userId) {
        return sysMenuMapper.selectMenuByUserId(userId);
    }

    @Override
    public PageInfo selectMenuList(SysMenu sysMenu) {
        PageInfo pageInfo = new PageInfo();
        int total = sysMenuMapper.selectMenuCount(sysMenu);
        if (total < 1) {
            return pageInfo;
        }
        pageInfo.setTotal(total);
        pageInfo.setRows(sysMenuMapper.selectMenuList(sysMenu));
        return pageInfo;
    }

    @Override
    public List<SysMenu> selectUpMenu() {
        return sysMenuMapper.selectUpMenu();
    }

    @Override
    public int insertMenu(SysMenu sysMenu) {
        return sysMenuMapper.insertMenu(sysMenu);
    }

    @Override
    public int updateMenu(SysMenu sysMenu) {
        return sysMenuMapper.updateMenu(sysMenu);
    }

    @Override
    public int checkUsedMenu(String menuCode) {
        return sysMenuMapper.checkUsedMenu(menuCode);
    }

    @Override
    public List<SysMenu> selectRoleMenu(String roleId) {
        return sysMenuMapper.selectRoleMenu(roleId);
    }

    @Override
    public int updateRoleMenu(String roleId, List<SysMenu> list) {
        sysMenuMapper.deleteRoleMenu(roleId);
        sysMenuMapper.insertRoleMenu(list);
        return 0;
    }

    @Override
    public List<SysMenu> selectMenuByRoleId(String roleId) {
        return sysMenuMapper.selectMenuByRoleId(roleId);
    }

    @Override
    public int selectMenuCount(SysMenu sysMenu) {
        return sysMenuMapper.selectMenuCount(sysMenu);
    }

}
