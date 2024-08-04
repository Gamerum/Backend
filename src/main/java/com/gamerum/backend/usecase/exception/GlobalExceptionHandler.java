package com.gamerum.backend.usecase.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(SocketTimeoutException.class)
    public ResponseEntity<ErrorResponse> handleSocketTimeoutException(Exception ex) {
        logger.error("\n\nSocketTimeoutException: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SOCKET_TIMEOUT_EXCEPTION), HttpStatus.GATEWAY_TIMEOUT);
    }

    @ExceptionHandler(UnknownHostException.class)
    public ResponseEntity<ErrorResponse> handleUnknownHostException(Exception ex) {
        logger.error("\n\nUnknownHostException: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.UNKNOWN_HOST), HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(SSLException.class)
    public ResponseEntity<ErrorResponse> handleSSLException(Exception ex) {
        logger.error("\n\nSSLException: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SSL_EXCEPTION), HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorResponse> handleIOException(Exception ex) {
        logger.error("\n\nIOException: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.IO_EXCEPTION), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ErrorException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(ErrorException ex) {
        logger.error("\n\nGlobalException: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorResponse(ex.getErrorCode()), ex.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errorCode = ex.getBindingResult().getAllErrors().stream()
                .map(e -> ((FieldError) e).getField() + ":" + e.getDefaultMessage()).toList();
        logger.error("\n\nValidationException: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorResponse(errorCode), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        logger.error("\n\nException: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.EXCEPTION), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
