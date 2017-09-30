package com.imobpay.commons.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证工具类
 * 
 * -用于验证手机号、身份证、邮箱等，支持自定义验证
 *
 * @author 简思文 <br/>
 * @version 1.0
 * @since JDK 1.6
 */
public class RegexValidator {

    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE              = "^((1[0-9][0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD             = "((11|12|13|14|15|21|22|23|31|32|33|34|35|36|37|41|42|43|44|45|46|50|51|52|53|54|61|62|63|64|65)[0-9]{4})" +
                                                                 "(([1|2][0-9]{3}[0|1][0-9][0-3][0-9][0-9]{3}" +
                                                                 "[Xx0-9])|([0-9]{2}[0|1][0-9][0-3][0-9][0-9]{3}))";
    /** 邮箱正则 */
    public static final String REGEX_EMAIL               = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$";

    /** ip地址正则 */
    public static final String REGEX_IP_ADDR             = "((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";

    /** 特殊字符正则 */
    public static final String REGEX_SPECIAL             = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（） ——+|{}【】‘；：”“’。，_、？-]";
    
    /** 整数数字*/
    public static final String REGEX_NUM                 = "^[0-9]*$";
    /** 整数类型正则表式 */
    public static final String REGEX_INTEGER             = "[-\\+]?\\d+";

    /** 浮点型正则表式 */
    public static final String REGEX_DOUBLE              = "[-\\+]?\\d+(\\.\\d+)?";

    /**
     * 固定电话号码型正则表式，固定电话格式: 3-4位区号，7-8位直播号码，1－4位分机号
     * 如：12345678901、1234-12345678-1234
     */
    public static final String REGEX_PHONE               = "(^0[0-9]{2,3}\\-[0-9]{3,8}+(/-[0-9]{1,4})?$)|(^[0-9]{3,8}+(/-[0-9]{1,4})?$)|(^\\(0[0-9]{2,3}\\)[0-9]{3,8}+(/-[0-9]{1,4})?$)";

    /** URL型正则表式，支持http:、HTTP:、https:、HTTPS */
    public static final String REGEX_URL                 = "(http:|HTTP:|https:|HTTPS:)\\/\\/[A-Za-z0-9]+\\.[A-Za-z0-9]+[\\/=\\?%\\-&_~`@\\':+!]*([^<>\"\"])*";

    /** 中文型正则表式 */
    public static final String REGEX_CHINESE             = "[\u0391-\uFFE5]+";

    /** 英文型正则表式，支持a~z、A~Z */
    public static final String REGEX_ENGLISH             = "[A-Za-z]+";

    /** 日期型正则表式,支持 yyyy-MM-dd hh:mm:ss */
    public static final String REGEX_DATE                = "(\\d{1,4})(-|\\/)(\\d{1,2})\\2(\\d{1,2})( (\\d{1,2}):(\\d{1,2}):(\\d{1,2}))?";

    /** 英文、数字型正则表式,支持a~z、A~Z、0～9 */
    public static final String REGEX_ENGLISH_NUM         = "[A-Za-z0-9]+";

    /** 英文、数字、中文型正则表式,支持a~z、A~Z、0～9、中文 */
    public static final String REGEX_ENGLISH_NUM_CHINESE = "[A-Za-z0-9\u0391-\uFFE5]+";

    /** 金额型正则表式，支持亿级金额(两位小数) */
    public static final String REGEX_MONERY              = "[-\\+]?\\d{1,9}(\\.\\d{1,2})?";

    /**
     * 校验身份证
     * 
     * @param idCard
     *            身份证号
     * @return -校验通过返回true，否则返回false
     */
    public static boolean isIDCardRegular(String idCard) {
        if (StringUtils.isEmpty(idCard)) {
            return false;
        }
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }

    /**
     * 校验手机号
     * 
     * @param mobile
     *            手机号
     * @return -校验通过返回true，否则返回false
     */
    public static boolean isMobileNumber(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return false;
        }
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * 校验邮箱
     * 
     * @param email
     *            邮箱
     * @return -校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return false;
        }
        return Pattern.matches(REGEX_EMAIL, email);
    }

    /**
     * 作用 ： 校验IP地址 <br/>
     * 
     * @param ipAddr
     *            ip地址
     * @return -校验通过返回true，否则返回false
     */
    public static boolean isIPAddr(String ipAddr) {
        if (StringUtils.isEmpty(ipAddr)) {
            return false;
        }
        Pattern p = Pattern.compile(REGEX_IP_ADDR, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(ipAddr);
        return m.matches();
    }

    /**
     * 
     * 作用 ：校验是否包含特殊符 <br/>
     * 
     * @param data
     *            待验证参数
     * @return -包含返回true，否则返回false
     */
    public static boolean isMatchWithSpecial(String data) {
        if (StringUtils.isEmpty(data)) {
            return false;
        }
        // 编译正则表达式
        Pattern pattern = Pattern.compile(REGEX_SPECIAL);
        Matcher matcher = pattern.matcher(data);
        // 字符串是否与正则表达式相匹配
        return matcher.find();
    }

    /**
     * 
     * 作用 : 自定义正则表达式验证(本类自带各类型正则表达式可以使用) <br/>
     * 
     * @param regex
     *            正则表达式
     * @param data
     *            待验证参数
     * @return -校验通过返回true，否则返回false
     *
     */
    public static boolean isMatch(String regex, String data) {
        return StringUtils.isEmpty(data) ? false : Pattern.matches(regex, data);
    }

    /**
     * 数字验证.
     * 
     * @param val
     *            验证值
     * @return -校验通过返回true，否则返回false
     */
    public static boolean isNum(String val) {
        return StringUtils.isEmpty(val) ? false : val.matches(REGEX_NUM);
    }

}
