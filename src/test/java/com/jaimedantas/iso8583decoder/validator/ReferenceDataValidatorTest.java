package com.jaimedantas.iso8583decoder.validator;

import br.com.fluentvalidator.Validator;
import br.com.fluentvalidator.context.ValidationResult;
import com.jaimedantas.iso8583decoder.decoder.Decoder;
import com.jaimedantas.iso8583decoder.exception.DecodeException;
import com.jaimedantas.iso8583decoder.model.iso8583.DataElement108;
import com.jaimedantas.iso8583decoder.model.iso8583.TransactionReferenceDataTemplate;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReferenceDataValidatorTest {

    @Test
    public void shouldPassValidateFundingSourceOfDataElement108() throws DecodeException {
        //given
        String encoded = "01600104EMMA0207ANTHONY0306VAUGHN0507MACHIAS0602VI1110174609308702630106BRENDA0209ANNABELLE0307MCGUIRE0505DATIL0602MO111012544681890312030203050204";
        //when
        final DataElement108 dataElement108 = Decoder.decode(encoded, DataElement108.class);
        final Validator<TransactionReferenceDataTemplate> validatorRequest = new ReferenceDataValidator();
        final ValidationResult validationResult = validatorRequest.validate(dataElement108.getTransactionReferenceDataTemplate());
        //then
        assertTrue(validationResult.isValid());
    }

    @Test
    public void shouldFailValidateFundingSourceOfDataElement108() throws DecodeException {
        String encoded = "01600104EMMA0207ANTHONY0306VAUGHN0507MACHIAS0602VI1110174609308702630106BRENDA0209ANNABELLE0307MCGUIRE0505DATIL0602MO111012544681890312030266050204";

        final DataElement108 dataElement108 = Decoder.decode(encoded, DataElement108.class);
        final Validator<TransactionReferenceDataTemplate> validatorRequest = new ReferenceDataValidator();
        final ValidationResult validationResult = validatorRequest.validate(dataElement108.getTransactionReferenceDataTemplate());

        assertFalse(validationResult.isValid());
    }

    @Test
    public void shouldPassTransactionPurposeSourceOfDataElement108() throws DecodeException {
        String encoded = "01600104EMMA0207ANTHONY0306VAUGHN0507MACHIAS0602VI1110174609308702630106BRENDA0209ANNABELLE0307MCGUIRE0505DATIL0602MO111012544681890312030203050204";

        final DataElement108 dataElement108 = Decoder.decode(encoded, DataElement108.class);
        final Validator<TransactionReferenceDataTemplate> validatorRequest = new ReferenceDataValidator();
        final ValidationResult validationResult = validatorRequest.validate(dataElement108.getTransactionReferenceDataTemplate());

        assertTrue(validationResult.isValid());
    }

    @Test
    public void shouldFailValidateTransactionPurposeOfDataElement108() throws DecodeException {
        String encoded = "01600104EMMA0207ANTHONY0306VAUGHN0507MACHIAS0602VI1110174609308702630106BRENDA0209ANNABELLE0307MCGUIRE0505DATIL0602MO111012544681890312030266050244";

        final DataElement108 dataElement108 = Decoder.decode(encoded, DataElement108.class);
        final Validator<TransactionReferenceDataTemplate> validatorRequest = new ReferenceDataValidator();
        final ValidationResult validationResult = validatorRequest.validate(dataElement108.getTransactionReferenceDataTemplate());

        assertFalse(validationResult.isValid());
    }

    @Test
    public void shouldFailValidateTransactionCryptoOfDataElement108() throws DecodeException {
        String encoded = "01600104EMMA0207ANTHONY0306VAUGHN0507MACHIAS0602VI1110174609308702630106BRENDA0209ANNABELLE0307MCGUIRE0505DATIL0602MO111012544681890312030203050211";

        final DataElement108 dataElement108 = Decoder.decode(encoded, DataElement108.class);
        final Validator<TransactionReferenceDataTemplate> validatorRequest = new ReferenceDataValidator();
        final ValidationResult validationResult = validatorRequest.validate(dataElement108.getTransactionReferenceDataTemplate());

        assertFalse(validationResult.isValid());
    }


}
