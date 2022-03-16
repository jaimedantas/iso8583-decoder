package com.jaimedantas.iso8583decoder.decoder;

import com.jaimedantas.iso8583decoder.exception.DecodeException;
import com.jaimedantas.iso8583decoder.model.iso8583.DataElement108;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class DataElement108Test {


    @Test
    public void shouldSuccessDecode() throws DecodeException {
        final String receiverData = "01600104EMMA0207ANTHONY0306VAUGHN0507MACHIAS0602VI1110174609308702630106BRENDA0209ANNABELLE0307MCGUIRE0505DATIL0602MO111012544681890312030203050204";

        final DataElement108 dataElement108 = Decoder.decode(receiverData, DataElement108.class);

        assertFalse(Objects.isNull(dataElement108));

    }

    @Test(expected = DecodeException.class)
    public void shouldThrowDecodeException() throws DecodeException {
        final String receiverData = "01610104EMMA0207ANTHONY0306VAUGHN0507MACHIAS0602VI1110174609308702630106BRENDA0209ANNABELLE0307MCGUIRE0505DATIL0602MO111012544681890312030203050204";

        final DataElement108 dataElement108 = Decoder.decode(receiverData, DataElement108.class);

        Assert.assertNull(dataElement108);
    }
}
