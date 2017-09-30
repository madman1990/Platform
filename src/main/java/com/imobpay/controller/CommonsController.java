/** 
 * 包名: package com.imobpay.controller; <br/> 
 * 添加时间: 2017年5月24日 下午7:01:10 <br/> 
 */
package com.imobpay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imobpay.commons.base.BaseController;
import com.imobpay.commons.utils.StringUtils;
import com.imobpay.model.system.SysParam;
import com.imobpay.service.system.ISysParamService;

/**
 * 类名: CommonsController <br/>
 * 作用：参数<br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月24日 下午7:01:10 <br/>
 */
@Controller
public class CommonsController extends BaseController {

    /** */
    @Autowired
    private ISysParamService sysParamService;

    /**
     * 
     * 【方法名】 : 查询运营商. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月24日 下午7:10:50 .<br/>
     * 【参数】： .<br/>
     * 
     * @return .<br/>
     */
    @RequestMapping(value = "/selectMobileCarrier", method = RequestMethod.POST)
    @ResponseBody
    public Object selectMobileCarrier() {
        List<SysParam> paramList = sysParamService.selectSysParamByType("MOBILE_CARRIER");
        return beforeFirstParam(paramList, "不限");
    }

    /**
     * 
     * 【方法名】 : 增加默认 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月25日 上午11:48:14 .<br/>
     * 【参数】： .<br/>
     * 
     * @param paramList
     *            List
     * @param firstText
     *            firstText
     * @return .<br/>
     */
    private List<SysParam> beforeFirstParam(List<SysParam> paramList, String firstText) {
        SysParam param = new SysParam();
        param.setParamCode("");
        param.setParamValue1(firstText);
        paramList.add(0, param);
        return paramList;
    }

    /**
     * 
     * 【方法名】 : 依据 参数类型查询 参数。<br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月7日 下午2:56:08 .<br/>
     * 【参数】： .<br/>
     * 
     * @param type
     *            type
     * @return .<br/>
     */
    @RequestMapping(value = "/querySysParamByType", method = RequestMethod.POST)
    @ResponseBody
    public Object querySysParamByType(String type) {
        List<SysParam> paramList = sysParamService.selectSysParamByType(type);
        return paramList;
    }

    /**
     * 
     * 【方法名】 : 查询奖项级别. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月8日 上午11:47:25 .<br/>
     * 【参数】： .<br/>
     * 
     * @return .<br/>
     */
    @RequestMapping(value = "/selectAwardLevel", method = RequestMethod.POST)
    @ResponseBody
    public Object selectAwardLevel() {
        return sysParamService.selectAwardLevel();
    }

    /**
     * 
     * 【方法名】 : 获取App信息 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月22日 下午1:51:37 .<br/>
     * 【参数】： .<br/>
     * 
     * @return .<br/>
     */
    @RequestMapping(value = "/selectAppId", method = RequestMethod.POST)
    @ResponseBody
    public Object selectAppId() {
        return sysParamService.selectAppList();
    }

    /**
     * 
     * 【方法名】 : 获取机构机构信息. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年6月22日 下午1:51:45 .<br/>
     * 【参数】： .<br/>
     * 
     * @param appId
     *            appId
     * @return .<br/>
     */
    @RequestMapping(value = "/selectBranchId", method = RequestMethod.POST)
    @ResponseBody
    public Object selectBranchId(String appId) {
        if (StringUtils.isNotBlank(appId)) {
            String[] appIdArr = appId.split(",");
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < appIdArr.length; i++) {
                sb.append("'" + appIdArr[i] + "',");
            }
            appId = sb.toString().substring(0, sb.toString().length() - 1);
        }
        return sysParamService.selectBranchList(appId);
    }
     
}
