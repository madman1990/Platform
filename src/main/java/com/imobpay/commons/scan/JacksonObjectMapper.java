package com.imobpay.commons.scan;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * <pre>
 * 【类型】: JacksonObjectMapper <br/> 
 * 【作用】: 解决Jackson 差8小时的问题. <br/>  
 * 【时间】：2017年5月23日 上午9:51:11 <br/> 
 * 【作者】：Ferry Chen <br/>
 * </pre>
 */
@Component("jacksonObjectMapper")
public class JacksonObjectMapper extends ObjectMapper {
    /**  */
    private static final long serialVersionUID = 4288193147502386170L;
    /**  地区 */
    private static final Locale CHINA = Locale.CHINA;
    /**
     * 
     * 【方法名】    : (这里用一句话描述这个方法的作用). <br/> 
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午9:51:53 .<br/>
     * 【参数】： .<br/> .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: Ferry Chen 修改描述：创建新新件 .<br/>
     * <p/>
     */
    public JacksonObjectMapper() {
        this.setLocale(CHINA);
        this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", CHINA));
        this.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }

}
