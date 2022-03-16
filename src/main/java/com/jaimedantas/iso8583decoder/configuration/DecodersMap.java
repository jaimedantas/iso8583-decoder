package com.jaimedantas.iso8583decoder.configuration;

import com.jaimedantas.iso8583decoder.core.map.TagLengthString;
import com.jaimedantas.iso8583decoder.decoder.*;
import com.jaimedantas.iso8583decoder.model.iso8583.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class DecodersMap {

    private static final Map<Class<?>, Class<? extends Decoder<?>>> MAP_DECODERS = new ConcurrentHashMap<>();

    static {
        MAP_DECODERS.put(TagLengthString.class, TagLengthStringDecoder.class);
        MAP_DECODERS.put(DataElement108.class, DataElement108Decoder.class);
        MAP_DECODERS.put(AccountHolder.class, AccountHolderDecoder.class);
        MAP_DECODERS.put(AccountHolderReceiverTemplate.class, AccountHolderReceiverTemplateDecoder.class);
        MAP_DECODERS.put(AccountHolderSenderTemplate.class, AccountHolderSenderTemplateDecoder.class);
        MAP_DECODERS.put(TransactionReferenceData.class, TransactionReferenceDataDecoder.class);
        MAP_DECODERS.put(TransactionReferenceDataTemplate.class, TransactionReferenceDataTemplateDecoder.class);
    }

    public static Class<? extends Decoder<?>> getDecoder(final Class<?> clazz) {
        return MAP_DECODERS.get(clazz);
    }

    private DecodersMap(){}
}
