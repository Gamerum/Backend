package com.gamerum.backend.usecase.exception;

import com.gamerum.backend.usecase.exception.request.RequestException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(UnirestException.class)
    public ResponseEntity<ErrorResponse> handleUnirestException(UnirestException ex) {
        if (ex.getCause() instanceof java.net.SocketTimeoutException) {
            logger.error("SocketTimeoutException: {}", ex.getMessage(), ex);
            return new ResponseEntity<>(
                    new ErrorResponse("Request timed out.", ex.getMessage()),
                    HttpStatus.GATEWAY_TIMEOUT);
        }
        if (ex.getCause() instanceof java.net.UnknownHostException) {
            logger.error("UnknownHostException: {}", ex.getMessage(), ex);
            return new ResponseEntity<>(
                    new ErrorResponse("Unknown host.", ex.getMessage()),
                    HttpStatus.BAD_GATEWAY);
        }

        if (ex.getCause() instanceof javax.net.ssl.SSLException) {
            logger.error("SSLException: {}", ex.getMessage(), ex);
            return new ResponseEntity<>(
                    new ErrorResponse("SSL/TLS error.", ex.getMessage()),
                    HttpStatus.BAD_GATEWAY);
        }

        if (ex.getCause() instanceof java.io.IOException) {
            logger.error("IOException: {}", ex.getMessage(), ex);
            return new ResponseEntity<>(
                    new ErrorResponse("IO exception: ", ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        logger.error("Exception: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(
                new ErrorResponse("An error occurred: ", ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RequestException.class)
    public ResponseEntity<ErrorResponse> handleRequestException(RequestException ex) {
        logger.error("RequestException - StatusCode: {}: {}", ex.getStatus(), ex.getMessage(), ex);
        return new ResponseEntity<>(
                new ErrorResponse("Request exception: ", ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
