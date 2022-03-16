package com.jaimedantas.iso8583decoder.processor;

import br.com.fluentvalidator.Validator;
import br.com.fluentvalidator.context.ValidationResult;
import com.jaimedantas.iso8583decoder.decoder.Decoder;
import com.jaimedantas.iso8583decoder.exception.DecodeException;
import com.jaimedantas.iso8583decoder.mapper.DataElement108ToResponseMapper;
import com.jaimedantas.iso8583decoder.model.iso8583.DataElement108;
import com.jaimedantas.iso8583decoder.model.iso8583.TransactionReferenceDataTemplate;
import com.jaimedantas.iso8583decoder.model.message.Request;
import com.jaimedantas.iso8583decoder.model.message.Response;
import com.jaimedantas.iso8583decoder.validator.DataElement108LengthValidator;
import com.jaimedantas.iso8583decoder.validator.ReferenceDataValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProcessDataElement108 {

    /**
     * Executes the complete parse of the raw string of DE 108 to the Contract of the API
     * @param input
     * @return
     * @throws DecodeException
     */
    public ResponseEntity<?> process(String input) throws DecodeException {
        //validation
        final Request request = new Request();
        request.setRequest(input);
        final Validator<Request> validatorRequest = new DataElement108LengthValidator();
        final ValidationResult validationRequestResult = validatorRequest.validate(request);

        if (!validationRequestResult.isValid()){
            return ResponseEntity.badRequest().body(validationRequestResult.getErrors());
        }

        final DataElement108 dataElement108 = Decoder.decode(input.substring(3), DataElement108.class);
        final Validator<TransactionReferenceDataTemplate> validatorDataElement108 = new ReferenceDataValidator();
        final ValidationResult validationDataElementResult = validatorDataElement108.validate(dataElement108.getTransactionReferenceDataTemplate());

        if (!validationDataElementResult.isValid()) {
            return ResponseEntity.unprocessableEntity().body(validationDataElementResult.getErrors());
        }

        DataElement108ToResponseMapper mapper = new DataElement108ToResponseMapper();
        Response response = mapper.dataElement108ToResponse(dataElement108);

        return ResponseEntity.unprocessableEntity().body(response);

    }

}
