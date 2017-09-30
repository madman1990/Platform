/** 
 * 包名: package com.imobpay.constant; <br/> 
 * 添加时间: 2017年5月19日 下午3:55:57 <br/> 
 */
package com.imobpay.constant;

import java.nio.charset.Charset;

/**
 * 类名: StaticConstant <br/>
 * 作用：全局变量<br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月19日 下午3:55:57 <br/>
 */
public class GlobalConstant {

    /** 无效-----0 **/
    public static final String STATUS_INVALID = "0";
    /** 有效-----1 **/
    public static final String STATUS_VALID = "1";

    /** 字符集ISO-8859-1 **/
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    /** 字符集GBK **/
    public static final Charset GBK = Charset.forName("GBK");
    /** 字符集utf-8 **/
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    /** 执行成功S */
    public static final String EXECU_SUCCESS = "执行成功";

}
