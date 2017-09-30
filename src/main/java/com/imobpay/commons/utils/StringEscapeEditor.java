package com.imobpay.commons.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.web.util.HtmlUtils;

/**
 * 
 * <pre>
 * 【类型】: StringEscapeEditor <br/> 
 * 【作用】: html 转换. <br/>  
 * 【时间】：2017年5月23日 上午10:00:31 <br/> 
 * 【作者】：Ferry Chen <br/>
 * </pre>
 */
public class StringEscapeEditor extends PropertyEditorSupport {
    /** */
    public StringEscapeEditor() {
    }

    @Override
    public String getAsText() {
        Object value = getValue();
        return value != null ? value.toString() : "";
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null) {
            setValue(null);
        } else {
            setValue(HtmlUtils.htmlEscape(text));
        }
    }

}
