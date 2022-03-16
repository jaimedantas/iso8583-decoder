package com.jaimedantas.iso8583decoder.model.iso8583;

import com.jaimedantas.iso8583decoder.core.TLV;
import com.jaimedantas.iso8583decoder.model.iso8583.constants.DataElement108Tags;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@Setter
public class TransactionReferenceDataTemplate implements TLV<String, TransactionReferenceData> {

    private static final long serialVersionUID = 1599691772517275562L;

    private TransactionReferenceData value;

    @Override
    public String getTag() {
        return DataElement108Tags.TRANSACTION_REFERENCE_DATA;
    }

    @Override
    public TransactionReferenceData getValue() {
        return value;
    }

    @Override
    public String toString() {

        if (Objects.isNull(value)) {
            return StringUtils.EMPTY;
        }

        final String string = value.toString();

        if (StringUtils.isBlank(string)) {
            return StringUtils.EMPTY;
        }

        return String.format("%s%02d%s", getTag(), string.length(), string);
    }

}
