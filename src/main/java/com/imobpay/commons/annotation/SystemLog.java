/** 
 * 包名: package com.imobpay.commons.annotation; <br/> 
 * 添加时间: 2017年5月18日 下午5:17:36 <br/> 
 */
package com.imobpay.commons.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类名: SystemLog <br/>
 * 作用：日志 <br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月18日 下午5:17:36 <br/>
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {

    public String module() default "";

    public String methods() default "";

    public String description() default "";

    public boolean isReadParam() default true;
}
