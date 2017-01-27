package org.mybatis.samples.cache;

import org.apache.ibatis.cache.impl.PerpetualCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by iurii.dziuban on 27.01.2017.
 *
 * Example of Custom cache with configurable properties
 */
public class CustomDefaultCache extends PerpetualCache {

    private Logger LOG = LoggerFactory.getLogger(CustomDefaultCache.class);

    private String stringProperty;
    private String integerProperty;

    public CustomDefaultCache(String id) {
        super(id);
    }

    @Override
    public Object getObject(Object key) {
        LOG.info("stringProperty = {}, integerProperty = {}", stringProperty, integerProperty);
        return super.getObject(key);
    }

}
