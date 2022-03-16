package com.jaimedantas.iso8583decoder.exception;

import br.com.fluentvalidator.context.Error;
import br.com.fluentvalidator.context.ValidationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Collection;

import static com.jaimedantas.iso8583decoder.context.RequestFilter.CORRELATION_ID;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(DecodeException.class)
    protected ResponseEntity<Collection<Error>> handleDecodeException(DecodeException ex){
        logger.error("Decode Exception in request {} with message {}", MDC.get(CORRELATION_ID), ex.getMessage());
        Collection<Error> errors = new ArrayList<>();
        Error error = Error.create("", "We were unable to decode your request this time", "400", "");
        errors.add(error);
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<ValidationResult> handleBadRequestException(BadRequestException ex){
        logger.error("Bad Request Exception in request {} with message {}", MDC.get(CORRELATION_ID), ex.getMessage());
        return ResponseEntity.badRequest().body(ex.getValidationResult());
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    protected ResponseEntity<ValidationResult> handleUnprocessableEntityException(UnprocessableEntityException ex){
        logger.error("Unprocessable Entity Exception in request {} with message {}", MDC.get(CORRELATION_ID), ex.getMessage());
        return ResponseEntity.unprocessableEntity().body(ex.getValidationResult());
    }

    @ExceptionHandler(Throwable.class)
    protected ResponseEntity<Collection<Error>> handleGenericException(Throwable ex){
        logger.error("Reach generic exception in request {} with message {}", MDC.get(CORRELATION_ID), ex.getMessage());
        Collection<Error> errors = new ArrayList<>();
        Error error = Error.create("", "We were unable to process your request this time", "500", "");
        errors.add(error);
        return ResponseEntity.internalServerError().body(errors);
    }

}
