package com.treegrowth.service.iml.cache;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "tree.cache")
public class ConfigParam {

    private  Map<String, Long> expires;
    private Long defaultExpireTime;

    public Long getDefaultExpireTime() {
        return defaultExpireTime;
    }

    public void setDefaultExpireTime(Long defaultExpireTime) {
        this.defaultExpireTime = defaultExpireTime;
    }

    public Map<String, Long> getExpires() {
        return expires;
    }

    public void setExpires(Map<String, Long> expires) {
        this.expires = expires;
    }
}
