package com.gamerum.backend.external.client.api.twitch;

import com.gamerum.backend.external.client.api.Token;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "twitchClient", url = "https://id.twitch.tv")
public interface TwitchClient {
    @RequestMapping(method = RequestMethod.POST, value = "/oauth2/token")
    Token getToken(
            @RequestParam("client_id") String clientId,
            @RequestParam("client_secret") String clientSecret,
            @RequestParam("grant_type") String grantType
    );
}
