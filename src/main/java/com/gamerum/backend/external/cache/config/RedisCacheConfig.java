package com.gamerum.backend.external.cache.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@Configuration
public class RedisCacheConfig {

    @Value("${cache.config.entry_ttl}")
    private int entryTtlMinutes;

    @Value("${cache.config.data.game.cache_name}")
    private String gameCacheName;

    @Value("${cache.config.data.game.entry_ttl}")
    private int gameCacheTtlMinutes;

    @Value("${cache.config.data.community.cache_name}")
    private String communityCacheName;

    @Value("${cache.config.data.community.entry_ttl}")
    private int communityCacheTtlMinutes;

    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(entryTtlMinutes))
                .disableCachingNullValues()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }

    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {

        return (builder) -> builder
                .withCacheConfiguration(gameCacheName,
                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(gameCacheTtlMinutes)))
                .withCacheConfiguration(communityCacheName,
                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(communityCacheTtlMinutes)));
    }


}
