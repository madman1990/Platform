package com.imobpay.commons.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;

import com.imobpay.commons.log.LogPay;

/**
 * 
 * <pre>
 * 【类型】: ShiroSpringCacheManager <br/> 
 * 【作用】: 使用spring-cache作为shiro缓存 缓存管理器. <br/>  
 * 【时间】：2017年5月23日 上午9:55:58 <br/> 
 * 【作者】：Ferry Chen <br/> 
 * </pre>
 */
public class ShiroSpringCacheManager implements CacheManager, Destroyable {
    /**  */
    private org.springframework.cache.CacheManager cacheManager;

    /**
     * 
     * 【方法名】    : (这里用一句话描述这个方法的作用). <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午9:56:46 .<br/>
     * 【参数】： .<br/>
     * @return .<br/>
     */
    public org.springframework.cache.CacheManager getCacheManager() {
        return cacheManager;
    }

    /**
     * 
     * 【方法名】    : (这里用一句话描述这个方法的作用). <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午9:56:50 .<br/>
     * 【参数】： .<br/>
     * @param cacheManager .<br/>
     */
    public void setCacheManager(org.springframework.cache.CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        LogPay.trace("Acquiring ShiroSpringCache instance named [" + name + "]");
        org.springframework.cache.Cache cache = cacheManager.getCache(name);
        return new ShiroSpringCache<K, V>(cache);
    }

    @Override
    public void destroy() throws Exception {
        cacheManager = null;
    }

}
