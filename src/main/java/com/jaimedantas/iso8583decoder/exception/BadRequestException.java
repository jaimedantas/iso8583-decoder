package com.jaimedantas.iso8583decoder.exception;

import br.com.fluentvalidator.context.ValidationResult;
import lombok.Getter;

@Getter
public class BadRequestException extends Exception {

    private static final long serialVersionUID = -9176921235615825388L;

    final String message;
    final ValidationResult validationResult;

    public BadRequestException(ValidationResult validationResult) {
        super(validationResult.getErrors().toString());
        this.validationResult = validationResult;
        this.message = validationResult.getErrors().toString();
    }
}
