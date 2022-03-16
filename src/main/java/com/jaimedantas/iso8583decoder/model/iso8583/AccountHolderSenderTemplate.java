package com.jaimedantas.iso8583decoder.model.iso8583;

import com.jaimedantas.iso8583decoder.core.TLV;
import com.jaimedantas.iso8583decoder.model.iso8583.constants.DataElement108Tags;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@Setter
@Getter
public class AccountHolderSenderTemplate implements TLV<String, AccountHolder> {

    private static final long serialVersionUID = 7739684225496128707L;

    private AccountHolder value;

    @Override
    public String getTag() {
        return DataElement108Tags.RECEIVER_DATA;
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
