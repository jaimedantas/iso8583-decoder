package com.jaimedantas.iso8583decoder.decoder;

import com.jaimedantas.iso8583decoder.model.AccountHolder;
import com.jaimedantas.iso8583decoder.model.AccountHolderReceiverTemplate;

public class AccountHolderReceiverTemplateDecoder extends DecoderMpm<AccountHolderReceiverTemplate> {

    public AccountHolderReceiverTemplateDecoder(final String source) {
        super(source);
    }

    @Override
    protected AccountHolderReceiverTemplate decode() throws IllegalArgumentException {
        final AccountHolderReceiverTemplate result = new AccountHolderReceiverTemplate();

        while(iterator.hasNext()) {
            final String value = iterator.next();
            result.setValue(DecoderMpm.decode(value, AccountHolder.class));
        }

        return result;
    }
}
