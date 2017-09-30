/** 
 * 包名: package com.imobpay.service.system.impl; <br/> 
 * 添加时间: 2017年5月19日 下午1:48:41 <br/> 
 */
package com.imobpay.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobpay.commons.result.PageInfo;
import com.imobpay.mapper.sys.SysUserMapper;
import com.imobpay.model.system.SysUser;
import com.imobpay.service.system.ISysUserService;

/**
 * 类名: SysUserServiceImpl <br/>
 * 作用：用户 <br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月19日 下午1:48:41 <br/>
 */
@Service
public class SysUserServiceImpl implements ISysUserService {
    /** */
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> selectUserList(SysUser sysUser) {
        return sysUserMapper.selectUserList(sysUser);
    }

    @Override
    public SysUser selectById(String userId) {
        return sysUserMapper.selectUserById(userId);
    }

    @Override
    public int updatePwdByUserId(String userId, String password) {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(userId);
        sysUser.setPassword(password);
        return sysUserMapper.updateByUserId(sysUser);
    }

    @Override
    public int insertUser(SysUser sysUser) {
        int userId = sysUserMapper.getUserId();
        sysUser.setUserId(String.valueOf(userId));
        sysUserMapper.insertUser(sysUser);
        sysUserMapper.insertUserRole(sysUser);
        return 1;
    }

    @Override
    public PageInfo selectSysUserList(SysUser sysUser) {
        PageInfo pagetInfo = new PageInfo();
        int total = sysUserMapper.selectSysUserCount(sysUser);
        if (total < 1) {
            return pagetInfo;
        }
        pagetInfo.setTotal(total);
        pagetInfo.setRows(sysUserMapper.selectSysUserList(sysUser));
        return pagetInfo;
    }

    @Override
    public int updateUser(SysUser sysUser) {
        sysUserMapper.updateByUserId(sysUser);
        sysUserMapper.deleteUserRole(sysUser);
        sysUserMapper.insertUserRole(sysUser);
        return 1;
    }

    @Override
    public int deleteUser(SysUser sysUser) {
        sysUser.setStatus("3");
        return sysUserMapper.updateByUserId(sysUser);
    }

}
