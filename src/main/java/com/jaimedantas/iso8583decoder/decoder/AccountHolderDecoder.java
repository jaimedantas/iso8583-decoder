package com.jaimedantas.iso8583decoder.decoder;

import com.jaimedantas.iso8583decoder.core.map.TagLengthString;
import com.jaimedantas.iso8583decoder.core.ultils.TLVUtils;
import com.jaimedantas.iso8583decoder.exception.DecodeException;
import com.jaimedantas.iso8583decoder.model.iso8583.AccountHolder;
import com.jaimedantas.iso8583decoder.model.iso8583.constants.AccountHolderTags;
import java.util.*;
import java.util.function.BiConsumer;


public final class AccountHolderDecoder extends Decoder<AccountHolder> {

    private static final Map<String, Map.Entry<Class<?>, BiConsumer<AccountHolder, ?>>> mapConsumers = new HashMap<>();

    static {
        mapConsumers.put(AccountHolderTags.FIRST_NAME, consumerTagLengthValue(TagLengthString.class, AccountHolder::setFirstName));
        mapConsumers.put(AccountHolderTags.MIDDLE_NAME, consumerTagLengthValue(TagLengthString.class, AccountHolder::setMiddleName));
        mapConsumers.put(AccountHolderTags.LAST_NAME, consumerTagLengthValue(TagLengthString.class, AccountHolder::setLastName));
        mapConsumers.put(AccountHolderTags.CITY, consumerTagLengthValue(TagLengthString.class, AccountHolder::setCity));
        mapConsumers.put(AccountHolderTags.STATE, consumerTagLengthValue(TagLengthString.class, AccountHolder::setState));
        mapConsumers.put(AccountHolderTags.ACCOUNT_NUMBER, consumerTagLengthValue(TagLengthString.class, AccountHolder::setAccountNumber));
    }

    public AccountHolderDecoder(final String source) {
        super(TLVUtils.valueOf(source));
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected AccountHolder decode() throws DecodeException {

        final AccountHolder result = new AccountHolder();

        while(iterator.hasNext()) {
            final String value = iterator.next();
            final String tag = TLVUtils.valueOfTag(value);
            final Map.Entry<Class<?>, BiConsumer<AccountHolder, ?>> entry = mapConsumers.get(tag);
            final Class<?> clazz = entry.getKey();
            final BiConsumer consumer = entry.getValue();
            consumer.accept(result, Decoder.decode(value, clazz));
        }

        return result;
    }
}
