/** 
 * 包名: package com.imobpay.service.system; <br/> 
 * 添加时间: 2017年5月22日 下午3:44:39 <br/> 
 */
package com.imobpay.service.system;

import com.imobpay.commons.result.PageInfo;
import com.imobpay.model.system.SysUserOperLog;

/**
 * 类名: ISysUserOperService <br/>
 * 作用：用户日志 <br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月22日 下午3:44:39 <br/>
 */
public interface ISysUserOperLogService {

    /**
     * 
     * 【方法名】 : 插入日志 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:19:12 .<br/>
     * 【参数】： .<br/>
     * 
     * @param userOper
     *            SysUserOperLog
     * @return .<br/>
     */
    public int insertOperLog(SysUserOperLog userOper);

    /**
     * 
     * 【方法名】 : 查询 列表 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月19日 下午4:15:53 .<br/>
     * 【参数】： .<br/>
     * 
     * @param userOper
     *            SysUserOperLog
     * @return .<br/>
     */
    public PageInfo selectOperLogList(SysUserOperLog userOper);
}
