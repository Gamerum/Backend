package com.gamerum.backend.external.persistence.elasticsearch.config;

import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories( basePackages = "com.gamerum.backend.external.persistence.elasticsearch.repository" )
@ComponentScan(basePackages = "com.gamerum.backend")
public class ElasticsearchConfig extends ElasticsearchConfiguration {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();
    }

    @Override
    public JsonpMapper jsonpMapper() {
        return new JacksonJsonpMapper(objectMapper);
    }
}
