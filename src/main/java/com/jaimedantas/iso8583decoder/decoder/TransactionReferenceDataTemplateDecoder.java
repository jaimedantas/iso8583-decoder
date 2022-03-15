package com.jaimedantas.iso8583decoder.decoder;


import com.jaimedantas.iso8583decoder.model.TransactionReferenceData;
import com.jaimedantas.iso8583decoder.model.TransactionReferenceDataTemplate;

public class TransactionReferenceDataTemplateDecoder extends DecoderMpm<TransactionReferenceDataTemplate>{

    public TransactionReferenceDataTemplateDecoder(final String source) {
        super(source);
    }

    @Override
    protected TransactionReferenceDataTemplate decode() throws IllegalArgumentException {
        final TransactionReferenceDataTemplate result = new TransactionReferenceDataTemplate();

        while(iterator.hasNext()) {
            final String value = iterator.next();
            result.setValue(DecoderMpm.decode(value, TransactionReferenceData.class));
        }

        return result;
    }

}
