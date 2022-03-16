package com.jaimedantas.iso8583decoder.decoder;

import com.jaimedantas.iso8583decoder.exception.DecodeException;
import com.jaimedantas.iso8583decoder.model.iso8583.AccountHolder;
import com.jaimedantas.iso8583decoder.model.iso8583.AccountHolderReceiverTemplate;

public class AccountHolderReceiverTemplateDecoder extends Decoder<AccountHolderReceiverTemplate> {

    public AccountHolderReceiverTemplateDecoder(final String source) {
        super(source);
    }

    @Override
    protected AccountHolderReceiverTemplate decode() throws DecodeException {
        final AccountHolderReceiverTemplate result = new AccountHolderReceiverTemplate();

        while(iterator.hasNext()) {
            final String value = iterator.next();
            result.setValue(Decoder.decode(value, AccountHolder.class));
        }

        return result;
    }
}
