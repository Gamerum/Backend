package com.gamerum.backend.usecase.exception;

import com.gamerum.backend.usecase.exception.request.RequestException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(UnirestException.class)
    public ResponseEntity<ErrorResponse> handleUnirestException(UnirestException ex) {
        if (ex.getCause() instanceof SocketTimeoutException)
            return handleSocketTimeoutException(ex);

        if (ex.getCause() instanceof UnknownHostException)
            return handleUnknownHostException(ex);

        if (ex.getCause() instanceof SSLException)
            return handleSSLException(ex);

        if (ex.getCause() instanceof IOException)
            return handleIOException(ex);

        return handleException(ex);
    }

    @ExceptionHandler(RequestException.class)
    public ResponseEntity<ErrorResponse> handleRequestException(RequestException ex) {
        logger.error("\n\nRequestException - StatusCode: {}: {}", ex.getStatus(), ex.getMessage(), ex);
        return new ResponseEntity<>(
                new ErrorResponse("Request exception occurred.", ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(SocketTimeoutException.class)
    public ResponseEntity<ErrorResponse> handleSocketTimeoutException(Exception ex) {
        logger.error("\n\nSocketTimeoutException: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(
                new ErrorResponse("Request timed out.", ex.getMessage()),
                HttpStatus.GATEWAY_TIMEOUT);
    }

    @ExceptionHandler(UnknownHostException.class)
    public ResponseEntity<ErrorResponse> handleUnknownHostException(Exception ex) {
        logger.error("\n\nUnknownHostException: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(
                new ErrorResponse("Unknown host.", ex.getMessage()),
                HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(SSLException.class)
    public ResponseEntity<ErrorResponse> handleSSLException(Exception ex) {
        logger.error("\n\nSSLException: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(
                new ErrorResponse("SSL/TLS error.", ex.getMessage()),
                HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorResponse> handleIOException(Exception ex) {
        logger.error("\n\nIOException: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(
                new ErrorResponse("IO exception.", ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        logger.error("\n\nException: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(
                new ErrorResponse("An error occurred.", ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
