package com.gamerum.backend.external.client.api.IGDB;

import com.gamerum.backend.external.client.api.TokenHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public IGDBTokenHandler igdbTokenHandler() {
        return new IGDBTokenHandler();
    }
}
