/** 
 * 包名: package com.imobpay.model.system; <br/> 
 * 添加时间: 2017年5月24日 下午6:48:13 <br/> 
 */
package com.imobpay.mapper.sys;

import java.util.List;
import java.util.Map;

import com.imobpay.model.system.SysParam;

/**
 * 类名: SysParamMapper <br/>
 * 作用：参数<br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月24日 下午6:48:13 <br/>
 */
public interface SysParamMapper {

    /**
     * 
     * 【方法名】 : 依据依据查询 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月24日 下午6:46:33 .<br/>
     * 【参数】： .<br/>
     * 
     * @param paramType
     *            类型
     * @return .<br/>
     */
    public List<SysParam> selectSysParamByType(String paramType);

    /**
     * 
     * 【方法名】 : 查询客户级别. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月25日 下午3:39:52 .<br/>
     * 【参数】： .<br/>
     * 
     * @return .<br/>
     */
    public List<Map<String, Object>> selectCustLevel();

    /**
     * 
     * 【方法名】 : 奖项级别. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月8日 上午11:45:12 .<br/>
     * 【参数】： .<br/>
     * 
     * @return .<br/>
     */
    public List<Map<String, Object>> selectAwardLevel();

    /**
     * 
     * 【方法名】 : 查询App信息. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月22日 上午11:02:33 .<br/>
     * 【参数】： .<br/>
     * 
     * @return .<br/>
     */
    public List<Map<String, Object>> selectAppList();

    /**
     * 
     * 【方法名】 : 查询机构 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月22日 上午11:07:05 .<br/>
     * 【参数】： .<br/>
     * 
     * @param map
     *            appId
     * @return .<br/>
     */
    public List<Map<String, Object>> selectBranchList(Map<String, Object> map);
}
