package com.jaimedantas.iso8583decoder.core.map;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TagLengthStringTest {


  @Test
  public void shouldSuccessToString() {
    final TagLengthString tagLengthString = new TagLengthString();

    tagLengthString.setTag("02");
    tagLengthString.setValue("1234");

    assertThat(tagLengthString.toString(), equalTo("02041234"));
    assertThat(new TagLengthString("02", "1234").toString(), equalTo("02041234"));
  }

  @Test
  public void shouldSuccessToStringWhenValueIsNull() {
    final TagLengthString tagLengthString = new TagLengthString();

    tagLengthString.setTag("02");
    tagLengthString.setValue(null);

    assertThat(tagLengthString.toString(), equalTo(StringUtils.EMPTY));
  }

  @Test
  public void shouldSuccessToStringWhenValueIsEmpty() {
    final TagLengthString tagLengthString = new TagLengthString();

    tagLengthString.setTag("02");
    tagLengthString.setValue(StringUtils.EMPTY);

    assertThat(tagLengthString.toString(), equalTo(StringUtils.EMPTY));
  }

}
