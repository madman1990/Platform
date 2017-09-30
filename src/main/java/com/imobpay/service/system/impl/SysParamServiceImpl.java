/** 
 * 包名: package com.imobpay.service.system.impl; <br/> 
 * 添加时间: 2017年5月24日 下午6:19:06 <br/> 
 */
package com.imobpay.service.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobpay.mapper.sys.SysParamMapper;
import com.imobpay.model.system.SysParam;
import com.imobpay.service.system.ISysParamService;

/**
 * 类名: SysParamServiceImpl <br/>
 * 作用： 参数 <br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月24日 下午6:19:06 <br/>
 */
@Service
public class SysParamServiceImpl implements ISysParamService {
    /**  */
    @Autowired
    private SysParamMapper sysParamMapper;

    @Override
    public List<SysParam> selectSysParamByType(String paramType) {
        return sysParamMapper.selectSysParamByType(paramType);
    }

    @Override
    public List<Map<String, Object>> selectCustLevel() {
        return sysParamMapper.selectCustLevel();
    }

    @Override
    public List<Map<String, Object>> selectAwardLevel() {
        return sysParamMapper.selectAwardLevel();
    }

    @Override
    public List<Map<String, Object>> selectAppList() {
        return sysParamMapper.selectAppList();
    }

    @Override
    public List<Map<String, Object>> selectBranchList(String appId) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("appId", appId);
        return sysParamMapper.selectBranchList(map);
    }

}
