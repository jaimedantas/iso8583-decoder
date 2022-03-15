package com.jaimedantas.iso8583decoder.decoder;

import com.jaimedantas.iso8583decoder.model.DataElement108;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DataElement108Test {


    @Test
    public void testSuccessDecode() throws IllegalArgumentException {
        final String receiverData = "01600104EMMA0207ANTHONY0306VAUGHN0507MACHIAS0602VI1110174609308702630106BRENDA0209ANNABELLE0307MCGUIRE0505DATIL0602MO111012544681890312030203050204";

        final DataElement108 dataElement108 = DecoderMpm.decode(receiverData, DataElement108.class);

        System.out.println("");

        assertThat(dataElement108.toString(), equalTo("CN"));

    }

}
