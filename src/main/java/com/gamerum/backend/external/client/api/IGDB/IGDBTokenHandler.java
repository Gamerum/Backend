package com.gamerum.backend.external.client.api.IGDB;

import com.gamerum.backend.external.client.api.Token;
import com.gamerum.backend.external.client.api.TokenHandler;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class IGDBTokenHandler extends TokenHandler {
    @Value("${api.twitch.token_request_url}")
    private String requestUrl;
    @Value("${api.twitch.client_id}")
    private String clientId;
    @Value("${api.twitch.client_secret}")
    private String clientSecret;
    @Value("${api.twitch.grant_type}")
    private String grantType;
    @Value("${api.twitch.response_param.access_token}")
    private String responseParamToken;
    @Value("${api.twitch.response_param.token_type}")
    private String responseParamTokenType;
    @Value("${api.twitch.response_param.token_expire}")
    private String responseParamTokenExpire;


    @Override
    protected Token getNewTokenAsync() throws URISyntaxException, IOException, InterruptedException {
        HttpResponse<String> response = fetchNewTokenFromAPI();
        if(response.statusCode() == HttpStatus.OK.value()){
            JSONObject object = new JSONObject(response.body());
            String token = object.getString(responseParamToken);
            String tokenType = object.getString(responseParamTokenType);
            long tokenExpire = object.getLong(responseParamTokenExpire);

            return new Token(tokenType, token, calculateExpirationTime(tokenExpire));
        }
        throw new RuntimeException();
    }

    @Override
    protected HttpResponse<String> fetchNewTokenFromAPI() throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = new URI(requestUrl);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("client_id", clientId)
                .header("client_secret", clientSecret)
                .header("grant_type", grantType)
                .POST(HttpRequest.BodyPublishers.ofString("param1=value1&param2=value2&param3=value3"))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
