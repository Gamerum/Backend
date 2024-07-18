package com.gamerum.backend.external.client.api.game.igdb;

import com.gamerum.backend.external.client.api.game.GameDbApi;
import com.gamerum.backend.external.client.api.game.igdb.utils.endpoint.Endpoint;
import com.gamerum.backend.external.client.api.game.igdb.utils.token.IGDBTokenHandler;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class IGDBApi implements GameDbApi {
    private final String baseUrl = "https://api.igdb.com/v4/";

    @Value("${api.twitch.client_id}")
    private String clientId;

    @Autowired
    private IGDBTokenHandler tokenHandler;

    public byte[] makeProtoRequest(String endpoint, String query) throws ExecutionException, InterruptedException {
        CompletableFuture<byte[]> future = CompletableFuture.supplyAsync(() -> {
            try {
                return protoRequest(endpoint, query);
            } catch (UnirestException | IOException e) {
                throw new RuntimeException(e);
            }
        });
        return future.get();
    }

    private byte[] protoRequest(String endpoint, String query) throws UnirestException, IOException {
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
