package com.gamerum.backend.external.client.api.igdb.exception;

import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.result.Result;

public class RequestException extends Exception {
    private final int statusCode;
    private final Request request;
    private final Result<String, FuelError> result;

    public RequestException(int statusCode, Request request, Result<String, FuelError> result) {
        this.statusCode = statusCode;
        this.request = request;
        this.result = result;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Request getRequest() {
        return request;
    }

    public Result<String, FuelError> getResult() {
        return result;
    }
}
