package com.jaimedantas.iso8583decoder.decoder;

import com.jaimedantas.iso8583decoder.core.map.TagLengthString;
import com.jaimedantas.iso8583decoder.exception.DecodeException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TagLengthStringDecoderTest {

  @Test
  public void shouldSuccessDecode() throws IllegalArgumentException, DecodeException {
    final TagLengthString tagLengthString = Decoder.decode("02041234", TagLengthString.class);

    assertThat(tagLengthString, not(nullValue()));

    assertThat(tagLengthString.getTag(), equalTo("02"));
    assertThat(tagLengthString.getLength(), equalTo(4));
    assertThat(tagLengthString.getValue(), equalTo("1234"));
  }

  @Test
  public void shouldSuccessDecodeEncode() throws IllegalArgumentException, DecodeException {
    final TagLengthString tagLengthString = Decoder.decode("02041234", TagLengthString.class);

    assertThat(tagLengthString.toString(), equalTo("02041234"));
  }

}
