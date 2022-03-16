package com.jaimedantas.iso8583decoder.decoder;

import com.jaimedantas.iso8583decoder.exception.DecodeException;
import com.jaimedantas.iso8583decoder.model.iso8583.TransactionReferenceData;
import com.jaimedantas.iso8583decoder.model.iso8583.TransactionReferenceDataTemplate;

public class TransactionReferenceDataTemplateDecoder extends Decoder<TransactionReferenceDataTemplate> {

    public TransactionReferenceDataTemplateDecoder(final String source) {
        super(source);
    }

    @Override
    protected TransactionReferenceDataTemplate decode() throws DecodeException {
        final TransactionReferenceDataTemplate result = new TransactionReferenceDataTemplate();

        while(iterator.hasNext()) {
            final String value = iterator.next();
            result.setValue(Decoder.decode(value, TransactionReferenceData.class));
        }

        return result;
    }

}
