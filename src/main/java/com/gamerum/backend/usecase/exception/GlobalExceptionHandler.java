package com.gamerum.backend.usecase.exception;

import com.gamerum.backend.adaptor.dto.response.ErrorResponse;
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

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(Exception ex) {
        logger.error("\n\nNotFoundException: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(
                new ErrorResponse("NotFound exception", ex.getMessage()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        logger.error("\n\nException: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(
                new ErrorResponse("An error occurred.", ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
