package com.jaimedantas.iso8583decoder.decoder;


import com.jaimedantas.iso8583decoder.model.AccountHolder;
import com.jaimedantas.iso8583decoder.model.AccountHolderSenderTemplate;

public class AccountHolderSenderTemplateDecoder extends DecoderMpm<AccountHolderSenderTemplate> {

    public AccountHolderSenderTemplateDecoder(final String source) {
        super(source);
    }

    @Override
    protected AccountHolderSenderTemplate decode() throws IllegalArgumentException {
        final AccountHolderSenderTemplate result = new AccountHolderSenderTemplate();

        while(iterator.hasNext()) {
            final String value = iterator.next();
            result.setValue(DecoderMpm.decode(value, AccountHolder.class));
        }

        return result;
    }
}
