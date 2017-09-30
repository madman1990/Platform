/** 
 * 包名: package com.imobpay.service.system.impl; <br/> 
 * 添加时间: 2017年5月22日 下午3:45:55 <br/> 
 */
package com.imobpay.service.system.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobpay.commons.result.PageInfo;
import com.imobpay.mapper.sys.SysUserOperLogMapper;
import com.imobpay.model.system.SysUserOperLog;
import com.imobpay.service.system.ISysUserOperLogService;

/**
 * 类名: SysUserOperServiceImpl <br/>
 * 作用：日志 <br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月22日 下午3:45:55 <br/>
 */
@Service
public class SysUserOperLogServiceImpl implements ISysUserOperLogService {
    /** */
    @Autowired
    private SysUserOperLogMapper sysUserOperLogMapper;

    @Override
    public int insertOperLog(SysUserOperLog userOper) {
        return sysUserOperLogMapper.insertOperLog(userOper);
    }

    @Override
    public PageInfo selectOperLogList(SysUserOperLog userOper) {
        PageInfo pageInfo = new PageInfo();
        int total = sysUserOperLogMapper.selectOperLogCount(userOper);
        if (total < 1) {
            return pageInfo;
        }
        pageInfo.setTotal(total);
        pageInfo.setRows(sysUserOperLogMapper.selectOperLogList(userOper));
        return pageInfo;
    }

}
