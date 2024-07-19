package com.gamerum.backend.external.cache.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class CacheUtils {
    @Autowired
    private CacheManager cacheManager;

    public <T> void invalidateCacheListIfConditionMet(String cacheName, String key, Class<T> type, Predicate<List<T>> condition) {
        Cache cache = cacheManager.getCache(cacheName);
        if (cache != null) {
            List<T> cachedData = cache.get(key, List.class);
            if (cachedData != null && condition.test(cachedData)) {
                cache.evict(key);
            }
        }
    }
}
