package com.jaimedantas.iso8583decoder.model;

import com.jaimedantas.iso8583decoder.core.TLV;
import com.jaimedantas.iso8583decoder.model.constants.DataElement108Tags;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@Setter
public class AccountHolderSenderTemplate implements TLV<String, AccountHolder> {

    private static final long serialVersionUID = 7739684225496128707L;

    private AccountHolder value;

    @Override
    public String getTag() {
        return DataElement108Tags.RECEIVER_DATA;
    }

    @Override
    public AccountHolder getValue() {
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
