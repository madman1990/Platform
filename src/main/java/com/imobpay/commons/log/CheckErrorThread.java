/**
 *  <pre>	
 *  Project Name:PayCommomPlatform .</br>
 *  File: CheckErrorThread.java .</br>
 *  Package Name:com.pay.base.log .</br>
 *  Date      Author       Changes .</br>
 *  2016年5月18日   Lance.Wu     Create  .</br>
 *  Description: .</br>
 *  Copyright 2014-2015 YINGXIANG FINANCE Services Co.,Ltd. All rights reserved..</br>
 *  <pre>	
 */
package com.imobpay.commons.log;

/**
 * <pre>
 * ClassName: CheckErrorThread <br/> 
 * Function:   ADD FUNCTION. <br/> 
 * Reason:   ADD REASON(可选). <br/> 
 * date: 2016年5月18日 下午2:03:55 <br/> 
 * 
 * @author Lance.Wu . <br/> 
 * @version   . <br/> 
 * @since JDK 1.6 PayCommomPlatform 1.0 . <br/>
 * </pre>
 */
public class CheckErrorThread implements Runnable {

    /** 日志对像 */
    private Throwable t = null;

    /**
     * 方法名:(创建日志对像). <br/>
     * 创建者： Lance.Wu .<br/>
     * 创建时间： 2016年5月18日 下午2:06:34 .<br/>
     * 参数：@param t .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: Lance.Wu 修改描述：创建新新件 .<br/>
     * <p/>
     */
    public CheckErrorThread(Throwable t) {
        this.t = t;
    }

    /**
     * 描述：功能藐视：当前方法实现方法.<br/>
     * 创建人：Lance.Wu .<br/>
     * 创建时间：2016年5月18日 下午2:04:16 .<br/>
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        t.getLocalizedMessage();
    }

}
