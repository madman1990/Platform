package com.imobpay.commons.utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * <pre>
 * 【类型】: CommonUtil <br/> 
 * 【作用】: CommonUtil. <br/>  
 * 【时间】：2017年5月23日 上午10:01:48 <br/> 
 * 【作者】：Ferry Chen <br/>
 * </pre>
 */
public class CommonUtil {

    /**
     * 
     * 【方法名】 : 获取HttpServletRequest; <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:34:59 .<br/>
     * 【参数】： .<br/>
     * 
     * @return .<br/>
     */
    public static HttpServletRequest getHttpRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 
     * 【方法名】 : 获取文件扩展名; <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:35:17 .<br/>
     * 【参数】： .<br/>
     * 
     * @param fileName
     *            .<br/>
     * @return .<br/>
     */
    public static String getFileExtension(String fileName) {
        if (StringUtils.isBlank(fileName)) {
            return null;
        }
        return fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
    }

    /**
     * 
     * 【方法名】 : 获取文件扩展名. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:35:35 .<br/>
     * 【参数】： .<br/>
     * 
     * @param fileName
     *            .<br/>
     * @return .<br/>
     */
    public static String getFileName(String fileName) {
        String fileExtension = getFileExtension(fileName);
        return fileName.substring(0, fileName.lastIndexOf(fileExtension) - 1);
    }

    /**
     * 
     * 【方法名】 : 用来去掉List中空值和相同项的。 <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:35:51 .<br/>
     * 【参数】： .<br/>
     * 
     * @param list
     *            .<br/>
     * @return .<br/>
     */
    public static List<String> removeSameItem(List<String> list) {
        List<String> difList = new ArrayList<String>();
        for (String t : list) {
            if (t != null && !difList.contains(t)) {
                difList.add(t);
            }
        }
        return difList;
    }

    /**
     * 
     * 【方法名】 : 返回用户的IP地址. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:36:37 .<br/>
     * 【参数】： .<br/>
     * 
     * @param request
     *            .<br/>
     * @return .<br/>
     */
    public static String toIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 
     * 【方法名】 : 去除字符串最后一个逗号,若传入为空则返回空字符串. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:36:54 .<br/>
     * 【参数】： .<br/>
     * 
     * @param para
     *            .<br/>
     * @return .<br/>
     */
    public static String trimComma(String para) {
        if (StringUtils.isNotBlank(para)) {
            if (para.endsWith(",")) {
                return para.substring(0, para.length() - 1);
            } else {
                return para;
            }
        } else {
            return "";
        }
    }

    /**
     * 
     * 【方法名】 :String转int值 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:02:13 .<br/>
     * 【参数】： .<br/>
     * 
     * @param value
     *            .<br/>
     * @param def
     *            .<br/>
     * @return .<br/>
     */
    public static Integer valueOf(String value, int def) {
        try {
            if (!StringUtils.isBlank(value)) {
                return Integer.parseInt(value);
            }
        } catch (Exception e) {
            return def;
        }
        return def;
    }

    /**
     * 
     * 【方法名】 : String转int值 . <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:02:52 .<br/>
     * 【参数】： .<br/>
     * 
     * @param value
     *            .<br/>
     * @return .<br/>
     */
    public static Integer valueOf(String value) {
        return valueOf(value, 0);
    }

    /**
     * 
     * 【方法名】 : html转议. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:37:27 .<br/>
     * 【参数】： .<br/>
     * 
     * @param content
     *            .<br/>
     * @return .<br/>
     */
    public static String htmltoString(String content) {
        if (content == null) {
            return "";
        }

        String html = content;
        html = html.replace("'", "&apos;");
        html = html.replaceAll("&", "&amp;");
        html = html.replace("\"", "&quot;");
        // 替换跳格
        html = html.replace("\t", "&nbsp;&nbsp;");
        // 替换空格
        html = html.replace(" ", "&nbsp;");
        html = html.replace("<", "&lt;");
        html = html.replaceAll(">", "&gt;");

        return html;
    }

    /**
     * 
     * 【方法名】 : html转议. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:38:08 .<br/>
     * 【参数】： .<br/>
     * 
     * @param content
     *            .<br/>
     * @return .<br/>
     */
    public static String stringtohtml(String content) {
        if (content == null) {
            return "";
        }
        String html = content;
        html = html.replace("&apos;", "'");
        html = html.replaceAll("&amp;", "&");
        html = html.replace("&quot;", "\"");
        // 替换跳格
        html = html.replace("&nbsp;&nbsp;", "\t");
        // 替换空格
        html = html.replace("&nbsp;", " ");
        html = html.replace("&lt;", "<");
        html = html.replaceAll("&gt;", ">");
        return html;
    }

    /**
     * 
     * 【方法名】 : String数组转Long数组. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:39:16 .<br/>
     * 【参数】： .<br/>
     * 
     * @param str
     *            .<br/>
     * @return .<br/>
     */
    public static Long[] stringArrayToLongArray(String[] str) {
        Long[] num = null;
        if (str != null && str.length > 0) {
            int len = str.length;
            num = new Long[len];
            for (int i = 0; i < len; i++) {
                num[i] = Long.valueOf(str[i]);
            }
        }
        return num;
    }

    /**
     * 
     * 【方法名】 : 脱敏. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月25日 下午7:40:23 .<br/>
     * 【参数】： .<br/>
     * 
     * @param data
     *            data
     * @param type
     *            type1 姓名 只保留第一个字符 type2 手机号码 前三后四 type3 客户编号第一位以及后四为 type4
     *            证件号码前十后四 中间四个* type5 第二交易帐号 根据不同情况判断 type6 终端编号 前四后五
     * @return .<br/>
     */
    public static String mosaic(String data, String type) {
        /*
         * 
         */
        String head;
        String end;
        int datasize;
        StringBuffer result = new StringBuffer();

        try {
            // 当数据为空 或者打码标记为1则直接返回
            if (StringUtils.isBlank(data)) {
                return data;
            }
            datasize = data.length();
            if ("1".equals(type)) {
                result.append(data.substring(0, 1));
                for (int i = 1; i < datasize; i++) {
                    result.append("*");
                }
                return result.toString();
            }
            if ("2".equals(type)) {
                if (datasize == 11) {
                    head = data.substring(0, 3);
                    end = data.substring(7);
                    return head + "****" + end;
                } else {
                    return "error";
                }
            }
            if ("3".equals(type)) {
                if (datasize == 10) {
                    head = data.substring(0, 1);
                    end = data.substring(6);
                    return head + "*****" + end;
                } else {
                    return "error";
                }
            }
            if ("4".equals(type)) {
                if (datasize == 18) {
                    head = data.substring(0, 3);
                    end = data.substring(14);
                    return head + "***********" + end;
                } else if (datasize == 15) {
                    head = data.substring(0, 3);
                    end = data.substring(11);
                    return head + "***********" + end;
                } else {
                    return "error";
                }
            }
            if ("5".equals(type)) {
                if (datasize == 10) {
                    return data;
                } else if (datasize == 11) {
                    head = data.substring(0, 3);
                    end = data.substring(7);
                    return head + "****" + end;
                } else if (datasize > 11) {
                    head = data.substring(0, 6);
                    end = data.substring(datasize - 4);
                    return head + "****" + end;
                } else {
                    return "error";
                }
            }
            if ("6".equals(type)) {
                if (datasize > 10) {
                    head = data.substring(0, 4);
                    end = data.substring(-5);
                    return head + "***********" + end;
                } else {
                    return "error";
                }
            }
            return "";
        } finally {
            head = null;
            end = null;
            result = null;
        }
    }

}
