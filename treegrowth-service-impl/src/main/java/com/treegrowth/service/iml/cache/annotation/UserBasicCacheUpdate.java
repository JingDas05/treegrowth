package com.treegrowth.service.iml.cache.annotation;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;

import java.lang.annotation.*;

import static com.treegrowth.service.iml.cache.annotation.UserBasicCache.KEY;
import static com.treegrowth.service.iml.cache.annotation.UserBasicCache.VALUE;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Caching(put = @CachePut(key = KEY, value = VALUE))
public @interface UserBasicCacheUpdate {

}
