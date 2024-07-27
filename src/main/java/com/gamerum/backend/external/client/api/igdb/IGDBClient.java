package com.gamerum.backend.external.client.api.igdb;

import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedList;
import java.util.List;

@FeignClient(name = "igdbClient", url = "https://api.igdb.com/v4")
public interface IGDBClient {
    @RequestMapping(method = RequestMethod.POST, value = "/games")
    List<GameDocument> getGames(
            @RequestHeader("Client-ID") String clientId,
            @RequestHeader("Authorization") String authorization,
            @RequestHeader("x-user-agent") String agent,
            @RequestBody String query
    );
}
