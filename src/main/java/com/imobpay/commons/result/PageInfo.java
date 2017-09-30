package com.imobpay.commons.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <pre>
 * 【类型】: PageInfo <br/> 
 * 【作用】: 分页对象. <br/>  
 * 【时间】：2017年5月23日 上午9:48:52 <br/> 
 * 【作者】：Ferry Chen <br/>
 * </pre>
 */
@SuppressWarnings("rawtypes")
public class PageInfo extends Result implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * 【方法名】    : (这里用一句话描述这个方法的作用). <br/> 
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 下午6:41:02 .<br/>
     * 【参数】： .<br/> .<br/>
     */
    public PageInfo() {
        this.total = 0;
        this.rows = new ArrayList();
    }

    /** 总记录 */
    private int total;
    /** 显示的记录 */
    private List rows;

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return total .<br/>
     */
    public int getTotal() {
        return total;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：Ferry Chen <br/>
     * 返回类型：@return rows .<br/>
     */
    public List getRows() {
        return rows;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月23日 上午9:48:44 <br/>
     * 参数: @param total 设置值. <br/>
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * 创建人：Ferry Chen <br/>
     * 创建时间：2017年5月23日 上午9:48:44 <br/>
     * 参数: @param rows 设置值. <br/>
     */
    public void setRows(List rows) {
        this.rows = rows;
    }

}
