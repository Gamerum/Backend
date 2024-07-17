package com.gamerum.backend.external.client.api.igdb;

import com.gamerum.backend.external.client.api.igdb.utils.Endpoint;
import com.gamerum.backend.external.client.api.token.TokenHandler;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Value;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class IGDBApi {
    private final TokenHandler tokenHandler;

    @Value("${api.twitch.client_id}")
    private String clientId;

    @Value("${api.igdb.base_url}")
    private String baseUrl;

    public IGDBApi() {
        tokenHandler = new IGDBTokenHandler();
    }

    protected byte[] protoRequest(Endpoint endpoint, String query) throws UnirestException, IOException {
        String requestUrl = baseUrl + endpoint.toString() + ".pb";

        HttpResponse<InputStream> response = Unirest.post(requestUrl)
                .header("client-id", clientId)
                .header("authorization", tokenHandler.getAuthorization())
                .header("x-user-agent", "igdb-api-jvm")
                .body(query)
                .asBinary();

        if (response.getStatus() != 200) {
            throw new RuntimeException();
        }

        return readResponseBody(response.getBody());
    }

    private byte[] readResponseBody(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        return outputStream.toByteArray();
    }
}
