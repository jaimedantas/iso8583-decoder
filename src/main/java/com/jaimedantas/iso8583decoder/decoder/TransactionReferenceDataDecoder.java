package com.jaimedantas.iso8583decoder.decoder;


import com.jaimedantas.iso8583decoder.core.mpm.TagLengthString;
import com.jaimedantas.iso8583decoder.core.ultils.TLVUtils;
import com.jaimedantas.iso8583decoder.model.TransactionReferenceData;
import com.jaimedantas.iso8583decoder.model.constants.TransactionReferenceDataTags;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public final class TransactionReferenceDataDecoder extends DecoderMpm<TransactionReferenceData> {
    private static final Map<String, Map.Entry<Class<?>, BiConsumer<TransactionReferenceData, ?>>> mapConsumers = new HashMap<>();

    static {
        mapConsumers.put(TransactionReferenceDataTags.FUNDING_SOURCE, consumerTagLengthValue(TagLengthString.class, TransactionReferenceData::setFundingSource));
        mapConsumers.put(TransactionReferenceDataTags.TRANSACTION_PURPOSE, consumerTagLengthValue(TagLengthString.class, TransactionReferenceData::setTransactionPurpose));
    }

    public TransactionReferenceDataDecoder(final String source) {
        super(TLVUtils.valueOf(source));
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TransactionReferenceData decode() throws IllegalArgumentException {

        final Set<String> tags = new HashSet<>();

        final TransactionReferenceData result = new TransactionReferenceData();

        while(iterator.hasNext()) {
            final String value = iterator.next();

            final String tag = TLVUtils.valueOfTag(value);


            tags.add(tag);

            final Map.Entry<Class<?>, BiConsumer<TransactionReferenceData, ?>> entry = mapConsumers.get(tag);


            final Class<?> clazz = entry.getKey();

            final BiConsumer consumer = entry.getValue();

            consumer.accept(result, DecoderMpm.decode(value, clazz));
        }

        return result;
    }
}
