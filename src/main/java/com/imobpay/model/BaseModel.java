/** 
 * 包名: package com.compass.utils; <br/> 
 * 添加时间: 2016年4月14日 下午3:28:34 <br/> 
 */
package com.imobpay.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * <pre>
 * 【类型】: BaseModel <br/> 
 * 【作用】: BaseModel. <br/>  
 * 【时间】：2017年5月23日 上午10:51:50 <br/> 
 * 【作者】：Ferry Chen <br/>
 * </pre>
 */
public class BaseModel implements Serializable {

    /**
     * 
     * @since JDK 1.6
     */
    private static final long serialVersionUID = 1L;
    /** 默认页行数 */
    private static final int DEFAULT_ROW_NUMBER = 20;

    /**
     * 当前行数
     */
    private int rows;
    /**
     * 当前页数
     */
    private int page;
    /**
     * 查询页数
     */
    private int pageNumber;
    /**
     * 查询行数
     */
    private int rowNumber;
    /**
     * 开始行数
     */
    private int start;
    /**
     * 结束行数
     */
    private int end;

    /**
     * 方法名： getRows.<br/>
     * 
     * 执行流程:.<br/>
     * 注意事项:.<br/>
     * 方法作用:.<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Ferry Chen<br/>
     * 创建日期：2016年4月14日.<br/>
     * 创建时间：下午3:42:41.<br/>
     * 其它内容： JDK 1.6 qtfr 1.0.<br/>
     */
    @JsonIgnore
    public int getRows() {
        return rows;
    }

    /**
     * 方法名： setRows.<br/>
     * 
     * 执行流程:.<br/>
     * 注意事项:.<br/>
     * 方法作用:.<br/>
     *
     * 参数： @param rows 设置值
     *
     * 创建者：Ferry Chen<br/>
     * 创建日期：2016年4月14日.<br/>
     * 创建时间：下午3:42:41.<br/>
     * 其它内容： JDK 1.6 qtfr 1.0.<br/>
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * 方法名： getPage.<br/>
     * 
     * 执行流程:.<br/>
     * 注意事项:.<br/>
     * 方法作用:.<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Ferry Chen<br/>
     * 创建日期：2016年4月14日.<br/>
     * 创建时间：下午3:42:41.<br/>
     * 其它内容： JDK 1.6 qtfr 1.0.<br/>
     */
    @JsonIgnore
    public int getPage() {
        return page;
    }

    /**
     * 方法名： setPage.<br/>
     * 
     * 执行流程:.<br/>
     * 注意事项:.<br/>
     * 方法作用:.<br/>
     *
     * 参数： @param page 设置值
     *
     * 创建者：Ferry Chen<br/>
     * 创建日期：2016年4月14日.<br/>
     * 创建时间：下午3:42:41.<br/>
     * 其它内容： JDK 1.6 qtfr 1.0.<br/>
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * 方法名： getPagenumber.<br/>
     * 
     * 执行流程:.<br/>
     * 注意事项:.<br/>
     * 方法作用:.<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Ferry Chen<br/>
     * 创建日期：2016年4月14日.<br/>
     * 创建时间：下午3:42:41.<br/>
     * 其它内容： JDK 1.6 qtfr 1.0.<br/>
     */
    @JsonIgnore
    public int getPagenumber() {
        return page == 0 ? 1 : page;
    }

    /**
     * 
     * 【方法名】 : (这里用一句话描述这个方法的作用). <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:49:16 .<br/>
     * 【参数】： .<br/>
     * 
     * @param pageNumber
     *            设置值.<br/>
     */
    public void setPagenumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * 方法名： getRownumber.<br/>
     * 
     * 执行流程:.<br/>
     * 注意事项:.<br/>
     * 方法作用:.<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Ferry Chen<br/>
     * 创建日期：2016年4月14日.<br/>
     * 创建时间：下午3:42:41.<br/>
     * 其它内容： JDK 1.6 qtfr 1.0.<br/>
     */
    @JsonIgnore
    public int getRownumber() {
        return rows == 0 ? DEFAULT_ROW_NUMBER : rows;
    }

    /**
     * 
     * 【方法名】 : (这里用一句话描述这个方法的作用). <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:49:32 .<br/>
     * 【参数】： .<br/>
     * 
     * @param rowNumber
     *            .<br/>
     */
    public void setRownumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    /**
     * 方法名： getStart.<br/>
     * 
     * 执行流程:.<br/>
     * 注意事项:.<br/>
     * 方法作用:.<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Ferry Chen<br/>
     * 创建日期：2016年4月14日.<br/>
     * 创建时间：下午3:42:41.<br/>
     * 其它内容： JDK 1.6 qtfr 1.0.<br/>
     */
    @JsonIgnore
    public int getStart() {
        return (this.getPagenumber() - 1) * this.getRownumber();
    }

    /**
     * 方法名： setStart.<br/>
     * 执行流程:.<br/>
     * 注意事项:.<br/>
     * 方法作用:.<br/>
     *
     * 参数： @param start 设置值
     *
     * 创建者：Ferry Chen<br/>
     * 创建日期：2016年4月14日.<br/>
     * 创建时间：下午3:42:41.<br/>
     * 其它内容： JDK 1.6 qtfr 1.0.<br/>
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * 方法名： getEnd.<br/>
     * 执行流程:.<br/>
     * 注意事项:.<br/>
     * 方法作用:.<br/>
     *
     * 返回值：@return 返回值
     *
     * 创建者：Ferry Chen<br/>
     * 创建日期：2016年4月14日.<br/>
     * 创建时间：下午3:42:41.<br/>
     * 其它内容： JDK 1.6 qtfr 1.0.<br/>
     */
    @JsonIgnore
    public int getEnd() {
        return this.getPagenumber() * this.getRownumber();
    }

    /**
     * 方法名： setEnd.<br/>
     * 方法作用:.<br/>
     * 参数： @param end 设置值
     *
     * 创建者：Ferry Chen<br/>
     * 创建日期：2016年4月14日.<br/>
     * 创建时间：下午3:42:41.<br/>
     * 其它内容： JDK 1.6 qtfr 1.0.<br/>
     */
    public void setEnd(int end) {
        this.end = end;
    }

}
