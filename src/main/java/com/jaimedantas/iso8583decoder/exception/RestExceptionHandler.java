package com.jaimedantas.iso8583decoder.exception;

import com.jaimedantas.iso8583decoder.controller.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @ExceptionHandler(DecodeException.class)
    protected ResponseEntity<Object> handleDecodeException(DecodeException ex){
        logger.error("Decode Exception in request {} with message {}", MDC.get("CorrelationId"), ex.getMessage());
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Throwable.class)
    protected ResponseEntity<Object> handleArithmeticException(Throwable ex){
        logger.error("Reach generic exception in request {} with message {}", MDC.get("CorrelationId"), ex.getMessage());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
