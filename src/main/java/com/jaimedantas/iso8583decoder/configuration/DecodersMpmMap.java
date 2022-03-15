package com.jaimedantas.iso8583decoder.configuration;

import com.jaimedantas.iso8583decoder.core.mpm.TagLengthString;
import com.jaimedantas.iso8583decoder.decoder.*;
import com.jaimedantas.iso8583decoder.model.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class DecodersMpmMap {

    private static final Map<Class<?>, Class<? extends DecoderMpm<?>>> MAP_DECODERS = new ConcurrentHashMap<>();

    static {
        MAP_DECODERS.put(String.class, StringDecoder.class);
        MAP_DECODERS.put(TagLengthString.class, TagLengthStringDecoder.class);
        MAP_DECODERS.put(DataElement108.class, DataElement108Decoder.class);
        MAP_DECODERS.put(AccountHolder.class, AccountHolderDecoder.class);
        MAP_DECODERS.put(AccountHolderReceiverTemplate.class, AccountHolderReceiverTemplateDecoder.class);
        MAP_DECODERS.put(AccountHolderSenderTemplate.class, AccountHolderSenderTemplateDecoder.class);
        MAP_DECODERS.put(TransactionReferenceData.class, TransactionReferenceDataDecoder.class);
        MAP_DECODERS.put(TransactionReferenceDataTemplate.class, TransactionReferenceDataTemplateDecoder.class);
    }

    private DecodersMpmMap() {
        super();
    }

    public static Class<? extends DecoderMpm<?>> getDecoder(final Class<?> clazz) {
        return MAP_DECODERS.get(clazz);
    }

}
