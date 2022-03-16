package com.jaimedantas.iso8583decoder.validator;

import br.com.fluentvalidator.AbstractValidator;
import com.jaimedantas.iso8583decoder.model.message.Request;

import static br.com.fluentvalidator.function.FunctionBuilder.of;

public class DataElement108LengthValidator  extends AbstractValidator<Request> {

    @Override
    public void rules() {
        ruleFor("LLLVAR_DE108", Request::getRequest)
                .must(this::checkSizeeOfDataElement108)
                    .withMessage("Length of data element 108 is wrong")
                    .withAttempedValue(of(Request::getRequest))
                    .critical();
    }

    private boolean checkSizeeOfDataElement108(final String request) {
        return Integer.parseInt(request.substring(0,3)) == request.length()-3;
    }

}
