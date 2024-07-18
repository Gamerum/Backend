package com.gamerum.backend.external.client.api.game.igdb.utils.token;

import com.gamerum.backend.external.client.api.token.Token;
import com.gamerum.backend.external.client.api.token.TokenHandler;
import com.gamerum.backend.usecase.exception.request.TwitchRequestException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class IGDBTokenHandler extends TokenHandler {
    private final String requestUrl = "https://id.twitch.tv/oauth2/token";

    @Value("${api.twitch.client_id}")
    private String clientId;
    @Value("${api.twitch.client_secret}")
    private String clientSecret;
    @Value("${api.twitch.grant_type}")
    private String grantType;


    @Override
    protected Token getNewToken() throws UnirestException, TwitchRequestException {
        HttpResponse<JsonNode> response = fetchNewTokenFromAPI();
        if (response.getStatus() == HttpStatus.OK.value()) {
            JsonNode responseBody = response.getBody();
            String token = responseBody.getObject().getString("access_token");
            String tokenType = responseBody.getObject().getString("token_type");
            long tokenExpire = responseBody.getObject().getLong("expires_in");
            return new Token(tokenType, token, calculateExpirationTime(tokenExpire));
        }
        throw new TwitchRequestException(response.getStatus(), response.getBody().getObject().getString("message"));
    }

    @Override
    protected HttpResponse<JsonNode> fetchNewTokenFromAPI() throws UnirestException {
        String url = requestUrl +
                "?client_id=" + clientId +
                "&client_secret=" + clientSecret +
                "&grant_type=" + grantType;
        return Unirest.post(url).asJson();
    }

    @Override
    public String getAuthorization() {
        Token token = getToken();
        return token.getTokenType() + " " + token.getAccessToken();
    }
}
