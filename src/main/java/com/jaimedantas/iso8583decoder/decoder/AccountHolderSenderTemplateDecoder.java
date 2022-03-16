package com.jaimedantas.iso8583decoder.decoder;

import com.jaimedantas.iso8583decoder.exception.DecodeException;
import com.jaimedantas.iso8583decoder.model.iso8583.AccountHolder;
import com.jaimedantas.iso8583decoder.model.iso8583.AccountHolderSenderTemplate;

public class AccountHolderSenderTemplateDecoder extends Decoder<AccountHolderSenderTemplate> {

    public AccountHolderSenderTemplateDecoder(final String source) {
        super(source);
    }

    @Override
    protected AccountHolderSenderTemplate decode() throws DecodeException {
        final AccountHolderSenderTemplate result = new AccountHolderSenderTemplate();

        while(iterator.hasNext()) {
            final String value = iterator.next();
            result.setValue(Decoder.decode(value, AccountHolder.class));
        }

        return result;
    }
}
