package com.gamerum.backend.external.client.api.igdb;

import com.gamerum.backend.external.client.api.token.Token;
import com.gamerum.backend.external.client.api.token.TokenHandler;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URISyntaxException;

public class IGDBTokenHandler extends TokenHandler {
    @Value("${api.twitch.token_request_url}")
    private String requestUrl;
    @Value("${api.twitch.client_id}")
    private String clientId;
    @Value("${api.twitch.client_secret}")
    private String clientSecret;
    @Value("${api.twitch.grant_type}")
    private String grantType;


    @Override
    protected Token getNewTokenAsync() throws URISyntaxException, IOException, InterruptedException, UnirestException {
        HttpResponse<JsonNode> response = fetchNewTokenFromAPI();
        if(response.getStatus() == HttpStatus.OK.value()){
            JsonNode responseBody = response.getBody();
            String token = responseBody.getObject().getString("access_token");
            String tokenType = responseBody.getObject().getString("token_type");
            long tokenExpire = responseBody.getObject().getLong("expires_in");
            return new Token(tokenType, token, calculateExpirationTime(tokenExpire));
        }
        throw new RuntimeException();
    }

    @Override
    protected HttpResponse<JsonNode> fetchNewTokenFromAPI() throws URISyntaxException, IOException, InterruptedException, UnirestException {
        String requestBody = "param1=value1&param2=value2&param3=value3";
        HttpResponse<JsonNode> response = Unirest.post(requestUrl)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("client_id", clientId)
                .header("client_secret", clientSecret)
                .header("grant_type", grantType)
                .body(requestBody)
                .asJson();

        return null;
    }

    @Override
    public String getAuthorization(){
        Token token = getToken();
        return token.getTokenType() + " " + token.getAccessToken();
    }
}
