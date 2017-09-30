package com.imobpay.commons.utils.excel;

import java.io.Serializable;

/**
 * 
 * <pre>
 * 【类型】: ColumnVarBean <br/> 
 * 【作用】: 字段序列化类. <br/>  
 * 【时间】：2017年3月15日 下午4:11:44 <br/> 
 * 【作者】：张朝辉 <br/>
 * </pre>
 */
public class ColumnVarBean implements Serializable {
    /**
     * 
     * 序列化编号
     */
    private static final long serialVersionUID = 8989228426708214373L;
    /**
     * Model中的属性名
     */
    private String            modelAttrName;
    /**
     * Excel中的变量名
     */
    private String            colAttrName;
    /**
     * 保存至Model中的默认值
     */
    private String            defaultVal;
    /**
     * 对应的列类型（在保存至Model中需要做数据转换和验证）
     */
    private String            columnType;
    /**
     * 是否必须 true:必须，不能为空 ,默认为false
     */
    private boolean           required         = false;
    /**
     * 最大长度,默认为32
     */
    private int               maxlength        = 32;

    /**
     * 是否为扩展属性,默认为false
     */
    private boolean           ext              = false;

    /**
     * 是否忽略此字段
     */
    private boolean           ignore           = false;

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return columnType .<br/>
     */
    public String getColumnType() {
        return columnType;
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月9日 下午3:11:59 <br/>
     * 参数: @param columnType 设置值. <br/>
     */
    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：LanceWu <br/>
     * 返回类型：@return modelAttrName .<br/>
     */
    public String getModelAttrName() {
        return modelAttrName;
    }

    /**
     * 创建人：LanceWu <br/>
     * 创建时间：2017年3月15日 下午4:14:27 <br/>
     * 参数: @param modelAttrName 设置值. <br/>
     */
    public void setModelAttrName(String modelAttrName) {
        this.modelAttrName = modelAttrName;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：LanceWu <br/>
     * 返回类型：@return colAttrName .<br/>
     */
    public String getColAttrName() {
        return colAttrName;
    }

    /**
     * 创建人：LanceWu <br/>
     * 创建时间：2017年3月15日 下午4:14:27 <br/>
     * 参数: @param colAttrName 设置值. <br/>
     */
    public void setColAttrName(String colAttrName) {
        this.colAttrName = colAttrName;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：LanceWu <br/>
     * 返回类型：@return defaultVal .<br/>
     */
    public String getDefaultVal() {
        return defaultVal;
    }

    /**
     * 创建人：LanceWu <br/>
     * 创建时间：2017年3月15日 下午4:14:27 <br/>
     * 参数: @param defaultVal 设置值. <br/>
     */
    public void setDefaultVal(String defaultVal) {
        this.defaultVal = defaultVal;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：LanceWu <br/>
     * 返回类型：@return required .<br/>
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * 创建人：LanceWu <br/>
     * 创建时间：2017年3月15日 下午4:14:27 <br/>
     * 参数: @param required 设置值. <br/>
     */
    public void setRequired(boolean required) {
        this.required = required;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：LanceWu <br/>
     * 返回类型：@return maxlength .<br/>
     */
    public int getMaxlength() {
        return maxlength;
    }

    /**
     * 创建人：LanceWu <br/>
     * 创建时间：2017年3月15日 下午4:14:27 <br/>
     * 参数: @param maxlength 设置值. <br/>
     */
    public void setMaxlength(int maxlength) {
        this.maxlength = maxlength;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：LanceWu <br/>
     * 返回类型：@return isExt .<br/>
     */
    public boolean isExt() {
        return ext;
    }

    /**
     * 创建人：LanceWu <br/>
     * 创建时间：2017年3月15日 下午4:14:27 <br/>
     * 参数: @param ext 设置值. <br/>
     */
    public void setExt(boolean ext) {
        this.ext = ext;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：LanceWu <br/>
     * 返回类型：@return ignore .<br/>
     */
    public boolean isIgnore() {
        return ignore;
    }

    /**
     * 创建人：LanceWu <br/>
     * 创建时间：2017年3月15日 下午4:14:27 <br/>
     * 参数: @param ignore 设置值. <br/>
     */
    public void setIgnore(boolean ignore) {
        this.ignore = ignore;
    }

}
