/** 
 * 包名: package com.imobpay.mapper.sys; <br/> 
 * 添加时间: 2017年5月22日 下午3:46:48 <br/> 
 */
package com.imobpay.mapper.sys;

import java.util.List;

import com.imobpay.model.system.SysUserOperLog;

/**
 * 类名: SysUserOperMapper <br/>
 * 作用：日志 <br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月22日 下午3:46:48 <br/>
 */
public interface SysUserOperLogMapper {

    /**
     * 
     * 【方法名】 : 插入日志 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:16:13 .<br/>
     * 【参数】： .<br/>
     * 
     * @param userOper userOper
     * @return .<br/>
     */
    public int insertOperLog(SysUserOperLog userOper);
    
    /**
     * 
     * 【方法名】    : 查询 列表 . <br/> 
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月19日 下午4:14:36 .<br/>
     * 【参数】： .<br/>
     * @param userOper SysUserOperLog
     * @return .<br/>
     */
    public List<SysUserOperLog> selectOperLogList(SysUserOperLog userOper);
    
    /**
     * 
     * 【方法名】    :  查询总数. <br/> 
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月19日 下午4:14:40 .<br/>
     * 【参数】： .<br/>
     * @param userOper SysUserOperLog
     * @return .<br/>
     */
    public int selectOperLogCount(SysUserOperLog userOper);
}
