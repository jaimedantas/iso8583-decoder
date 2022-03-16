package com.jaimedantas.iso8583decoder.processor;

import br.com.fluentvalidator.Validator;
import br.com.fluentvalidator.context.ValidationResult;
import com.jaimedantas.iso8583decoder.decoder.Decoder;
import com.jaimedantas.iso8583decoder.exception.BadRequestException;
import com.jaimedantas.iso8583decoder.exception.DecodeException;
import com.jaimedantas.iso8583decoder.exception.UnprocessableEntityException;
import com.jaimedantas.iso8583decoder.mapper.DataElement108ToResponseDataElement108Mapper;
import com.jaimedantas.iso8583decoder.model.iso8583.DataElement108;
import com.jaimedantas.iso8583decoder.model.iso8583.TransactionReferenceDataTemplate;
import com.jaimedantas.iso8583decoder.model.message.Request;
import com.jaimedantas.iso8583decoder.model.message.ResponseSingleTransaction;
import com.jaimedantas.iso8583decoder.validator.DataElement108LengthValidator;
import com.jaimedantas.iso8583decoder.validator.ReferenceDataValidator;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Objects;

@Component
public class ProcessDataElement108 {

    /**
     * Executes the complete parse and validation of the raw string of DE 108 to the Contract of the API
     * @param input request from client
     * @return
     * @throws DecodeException
     * @throws BadRequestException
     * @throws UnprocessableEntityException
     */
    public ResponseEntity<ResponseSingleTransaction> process(String input) throws DecodeException, BadRequestException, UnprocessableEntityException {

        final Request request = new Request();
        request.setClientRequest(input);
        final Validator<Request> validatorRequest = new DataElement108LengthValidator();
        final ValidationResult validationRequestResult = validatorRequest.validate(request);

        if (!validationRequestResult.isValid()){
            throw new BadRequestException(validationRequestResult);
        }

        final DataElement108 dataElement108 = Decoder.decode(input.substring(3), DataElement108.class);
        final Validator<TransactionReferenceDataTemplate> validatorDataElement108 = new ReferenceDataValidator();
        final ValidationResult validationDataElementResult = validatorDataElement108.validate(dataElement108.getTransactionReferenceDataTemplate());

        if (!validationDataElementResult.isValid()) {
            throw new UnprocessableEntityException(validationDataElementResult);
        }

        DataElement108ToResponseDataElement108Mapper mapper = new DataElement108ToResponseDataElement108Mapper();
        ResponseSingleTransaction response = mapper.dataElement108ToResponse(dataElement108);

        return ResponseEntity.ok().body(response);

    }

    /**
     * Processes the file input from client
     * @param input
     * @return
     * @throws DecodeException
     */
    @SneakyThrows
    public ResponseEntity<ArrayList<ResponseSingleTransaction>> processFile(MultipartFile input) {

        String k = new String(input.getBytes());
        String[] parts = k.split("\n");
        ArrayList<ResponseSingleTransaction> arrayList = new ArrayList<>();
        for (String p : parts)
        {
            ResponseSingleTransaction responseSingleTransaction = parseTransaction(p);
            if (!Objects.isNull(responseSingleTransaction)){
                arrayList.add(responseSingleTransaction);
            }
        }
        return ResponseEntity.ok().body(arrayList);
    }

    /**
     * Parses each transaction from file
     * @param transaction
     * @return
     * @throws DecodeException
     */
    private ResponseSingleTransaction parseTransaction(String transaction) throws DecodeException {

        //validation
        final Request request = new Request();
        request.setClientRequest(transaction);
        final Validator<Request> validatorRequest = new DataElement108LengthValidator();
        final ValidationResult validationRequestResult = validatorRequest.validate(request);

        if (!validationRequestResult.isValid()){
            return null;
        }

        final DataElement108 dataElement108 = Decoder.decode(transaction.substring(3), DataElement108.class);
        final Validator<TransactionReferenceDataTemplate> validatorDataElement108 = new ReferenceDataValidator();
        final ValidationResult validationDataElementResult = validatorDataElement108.validate(dataElement108.getTransactionReferenceDataTemplate());

        if (!validationDataElementResult.isValid()) {
            return null;
        }

        DataElement108ToResponseDataElement108Mapper mapper = new DataElement108ToResponseDataElement108Mapper();
        return mapper.dataElement108ToResponse(dataElement108);
    }


}
