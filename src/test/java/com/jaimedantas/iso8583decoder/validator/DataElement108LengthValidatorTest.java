package com.jaimedantas.iso8583decoder.validator;

import br.com.fluentvalidator.Validator;
import br.com.fluentvalidator.context.ValidationResult;
import com.jaimedantas.iso8583decoder.model.message.Request;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class DataElement108LengthValidatorTest {

    @Test
    public void shoudPassValidateLLLVARofDataElement108() {
        //give
        final String encoded = "14701600104EMMA0207ANTHONY0306VAUGHN0507MACHIAS0602VI1110174609308702630106BRENDA0209ANNABELLE0307MCGUIRE0505DATIL0602MO111012544681890312030203050204";
        //when
        final Request request = new Request();
        request.setRequest(encoded);
        final Validator<Request> validatorRequest = new DataElement108LengthValidator();
        final ValidationResult validationResult = validatorRequest.validate(request);
        //then
        assertTrue(validationResult.isValid());
    }

    @Test
    public void shoudFallValidateLLLVARofDataElement108() {
        final String encoded = "14601600104EMMA0207ANTHONY0306VAUGHN0507MACHIAS0602VI1110174609308702630106BRENDA0209ANNABELLE0307MCGUIRE0505DATIL0602MO111012544681890312030203050204";

        final Request request = new Request();
        request.setRequest(encoded);
        final Validator<Request> validatorRequest = new DataElement108LengthValidator();
        final ValidationResult validationResult = validatorRequest.validate(request);

        assertFalse(validationResult.isValid());
    }

}
