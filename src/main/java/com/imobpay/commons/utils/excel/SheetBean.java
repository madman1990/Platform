package com.imobpay.commons.utils.excel;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * <pre>
 * 【类型】: SheetBean <br/> 
 * 【作用】: excle序列化工具类. <br/>  
 * 【时间】：2017年3月15日 下午3:43:29 <br/> 
 * 【作者】：张朝辉 <br/> 
 * 修改内容：新增注释
 * </pre>
 */
public class SheetBean implements Serializable {

    /** (一句话描述) */
    private static final long serialVersionUID = 1L;
    /**
     * Excel Sheet中的第二行的变量名集合
     */
    private List<String>      varNameList;
    /**
     * 从Sheet中第三行开始的所有数据，行列转换成二维数组格式
     */
    private String[][]        sheetData;

    /**
     * 描述：获取属性值.<br/>
     * 创建人：LanceWu <br/>
     * 返回类型：@return varNameList .<br/>
     */
    public List<String> getVarNameList() {
        return varNameList;
    }

    /**
     * 创建人：LanceWu <br/>
     * 创建时间：2017年3月15日 下午4:05:18 <br/>
     * 参数: @param varNameList 设置值. <br/>
     */
    public void setVarNameList(List<String> varNameList) {
        this.varNameList = varNameList;
    }
    
    /**
     * 描述：获取属性值.<br/>
     * 创建人：LanceWu <br/>
     * 返回类型：@return sheetData .<br/>
     */
    public String[][] getSheetData() {
        return sheetData;
    }

    /**
     * 创建人：LanceWu <br/>
     * 创建时间：2017年3月15日 下午4:05:18 <br/>
     * 参数: @param sheetData 设置值. <br/>
     */
    public void setSheetData(String[][] sheetData) {
        this.sheetData = sheetData;
    }
    /**
     * 描述：获取属性值.<br/>
     * 创建人：LanceWu <br/>
     * 返回类型：@return serialversionuid .<br/>
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

  
}
