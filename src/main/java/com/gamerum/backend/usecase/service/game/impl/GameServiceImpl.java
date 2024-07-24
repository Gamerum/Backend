package com.gamerum.backend.usecase.service.game.impl;


import com.gamerum.backend.usecase.service.game.GameService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "${cache.config.data.game.cache_name}")
public class GameServiceImpl implements GameService {

    @Override
    @Cacheable(key = "'popularGames'", unless = "#result == null || #result.isBlank()")
    public String getTop5PopularGames() {
        return "";
    }
}
