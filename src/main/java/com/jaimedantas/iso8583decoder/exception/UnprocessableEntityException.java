package com.jaimedantas.iso8583decoder.exception;

import br.com.fluentvalidator.context.ValidationResult;
import lombok.Getter;

@Getter
public class UnprocessableEntityException extends Exception {

    private static final long serialVersionUID = -715220529243374914L;

    final String message;
    final ValidationResult validationResult;

    public UnprocessableEntityException(ValidationResult validationResult) {
        super(validationResult.getErrors().toString());
        this.validationResult = validationResult;
        this.message = validationResult.getErrors().toString();
    }
}
