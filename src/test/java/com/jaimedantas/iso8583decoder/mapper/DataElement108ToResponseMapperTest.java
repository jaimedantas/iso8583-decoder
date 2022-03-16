package com.jaimedantas.iso8583decoder.mapper;

import com.jaimedantas.iso8583decoder.decoder.Decoder;
import com.jaimedantas.iso8583decoder.exception.DecodeException;
import com.jaimedantas.iso8583decoder.model.iso8583.DataElement108;
import com.jaimedantas.iso8583decoder.model.message.Response;
import org.junit.Test;

import java.util.Objects;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class DataElement108ToResponseMapperTest {

    DataElement108ToResponseMapper mapper = new DataElement108ToResponseMapper();

    @Test
    public void shouldBuildResponseObjectFromStringDe108() throws DecodeException {
        //given
        String encodeDe108 = "01600104EMMA0207ANTHONY0306VAUGHN0507MACHIAS0602VI1110174609308702630106BRENDA0209ANNABELLE0307MCGUIRE0505DATIL0602MO111012544681890312030203050204";

        //when
        final DataElement108 dataElement108 = Decoder.decode(encodeDe108, DataElement108.class);
        Response response = mapper.dataElement108ToResponse(dataElement108);

        //then
        assertThat(response.getReceiver().getFirst(), equalTo("EMMA"));
        assertThat(response.getReceiver().getMiddle(), equalTo("ANTHONY"));
        assertThat(response.getReceiver().getLast(), equalTo("VAUGHN"));
        assertThat(response.getReceiver().getCity(), equalTo("MACHIAS"));
        assertThat(response.getReceiver().getState(), equalTo("VI"));
        assertThat(response.getReceiver().getAccount(), equalTo("1746093087"));

        assertThat(response.getSender().getFirst(), equalTo("BRENDA"));
        assertThat(response.getSender().getLast(), equalTo("MCGUIRE"));
        assertThat(response.getSender().getCity(), equalTo("DATIL"));
        assertThat(response.getSender().getState(), equalTo("MO"));
        assertThat(response.getSender().getAccount(), equalTo("1254468189"));

        assertThat(response.getReferenceData().getFundingSource(), equalTo("03"));
        assertThat(response.getReferenceData().getTransactionPurpose(), equalTo("04"));

    }


    @Test
    public void shouldBuildResponseWithoutMiddleNameReceiverStringDe108() throws DecodeException {
        //given
        String encodeDe108 = "01490104EMMA0306VAUGHN0507MACHIAS0602VI1110174609308702630106BRENDA0209ANNABELLE0307MCGUIRE0505DATIL0602MO111012544681890312030203050204";

        //when
        final DataElement108 dataElement108 = Decoder.decode(encodeDe108, DataElement108.class);
        Response response = mapper.dataElement108ToResponse(dataElement108);

        //then
        assertThat(response.getReceiver().getFirst(), equalTo("EMMA"));
        assertThat(response.getReceiver().getLast(), equalTo("VAUGHN"));
        assertThat(response.getReceiver().getCity(), equalTo("MACHIAS"));
        assertThat(response.getReceiver().getState(), equalTo("VI"));
        assertThat(response.getReceiver().getAccount(), equalTo("1746093087"));

        assertThat(response.getSender().getFirst(), equalTo("BRENDA"));
        assertThat(response.getSender().getLast(), equalTo("MCGUIRE"));
        assertThat(response.getSender().getCity(), equalTo("DATIL"));
        assertThat(response.getSender().getState(), equalTo("MO"));
        assertThat(response.getSender().getAccount(), equalTo("1254468189"));

        assertThat(response.getReferenceData().getFundingSource(), equalTo("03"));
        assertThat(response.getReferenceData().getTransactionPurpose(), equalTo("04"));

    }

    @Test
    public void shouldBuildResponseWithoutMiddleNameSenderStringDe108() throws DecodeException {
        //given
        String encodeDe108 = "01600104EMMA0207ANTHONY0306VAUGHN0507MACHIAS0602VI1110174609308702500106BRENDA0307MCGUIRE0505DATIL0602MO111012544681890312030203050204";

        //when
        final DataElement108 dataElement108 = Decoder.decode(encodeDe108, DataElement108.class);
        Response response = mapper.dataElement108ToResponse(dataElement108);

        //then
        assertThat(response.getReceiver().getFirst(), equalTo("EMMA"));
        assertThat(response.getReceiver().getLast(), equalTo("VAUGHN"));
        assertThat(response.getReceiver().getCity(), equalTo("MACHIAS"));
        assertThat(response.getReceiver().getState(), equalTo("VI"));
        assertThat(response.getReceiver().getAccount(), equalTo("1746093087"));

        assertThat(response.getSender().getFirst(), equalTo("BRENDA"));
        assertThat(response.getSender().getLast(), equalTo("MCGUIRE"));
        assertThat(response.getSender().getCity(), equalTo("DATIL"));
        assertThat(response.getSender().getState(), equalTo("MO"));
        assertThat(response.getSender().getAccount(), equalTo("1254468189"));

        assertThat(response.getReferenceData().getFundingSource(), equalTo("03"));
        assertThat(response.getReferenceData().getTransactionPurpose(), equalTo("04"));

    }

    @Test(expected = NullPointerException.class)
    public void shouldFailDueToMissingFieldOfDe108() throws RuntimeException, DecodeException {
        //given
        String encodeDe108 = "01600104EMMA0207ANTHONY0306VAUGHN0507MACHIAS0602VI1110174609308702500106BRENDA0307MCGUIRE0505DATIL0602MO111012544681890306030203";

        //when
        final DataElement108 dataElement108 = Decoder.decode(encodeDe108, DataElement108.class);
        Response response = mapper.dataElement108ToResponse(dataElement108);

        //then
        assertTrue(Objects.isNull(response));

    }


}
