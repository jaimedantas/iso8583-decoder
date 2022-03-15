package com.jaimedantas.iso8583decoder.decoder;

import com.jaimedantas.iso8583decoder.core.ultils.TLVUtils;
import com.jaimedantas.iso8583decoder.model.*;
import com.jaimedantas.iso8583decoder.model.constants.DataElement108Tags;

import java.util.*;
import java.util.function.BiConsumer;


public final class DataElement108Decoder extends DecoderMpm<DataElement108>{

    private static final Map<String, Map.Entry<Class<?>, BiConsumer<DataElement108, ?>>> mapConsumers = new HashMap<>();

    static {
        mapConsumers.put(DataElement108Tags.RECEIVER_DATA, consumerTagLengthValue(AccountHolderReceiverTemplate.class, DataElement108::setReceiverData));
        mapConsumers.put(DataElement108Tags.SENDER_DATA, consumerTagLengthValue(AccountHolderSenderTemplate.class, DataElement108::setSenderData));
        mapConsumers.put(DataElement108Tags.TRANSACTION_REFERENCE_DATA, consumerTagLengthValue(TransactionReferenceDataTemplate.class, DataElement108::setTransactionReferenceDataTemplate));
    }

    public DataElement108Decoder(final String source) {
        super(source);
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected DataElement108 decode() throws IllegalArgumentException {

        final Set<String> tags = new HashSet<>();

        final DataElement108 result = new DataElement108();

        while(iterator.hasNext()) {
            final String value = iterator.next();

            final String tag = TLVUtils.valueOfTag(value);

            final String derivateId = tag;

            tags.add(tag);

            final Map.Entry<Class<?>, BiConsumer<DataElement108, ?>> entry = mapConsumers.get(derivateId);

            final Class<?> clazz = entry.getKey();

            final BiConsumer consumer = entry.getValue();

            consumer.accept(result, DecoderMpm.decode(value, clazz));
        }

        return result;
    }

}
