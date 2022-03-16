package com.jaimedantas.iso8583decoder.decoder;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DecoderIteratorTest {

  @Test
  public void shouldSuccessParse() {
    final String encoded = "00020101021102160004hoge0104abcd520441115303156540523.7255020256035005802CN5914BEST TRANSPORT6007BEIJING6107123456762950105123450205678900305098760405543210505abcde0605fghij0705klmno0805pqres0903tuv1004abcd5004ijkl64280002ZH0102北京0204最佳运输0304abcd65020080320016A0112233449988770708123456786304C659";

    final DecoderIterator decodeIterator = new DecoderIterator(encoded);

    assertThat(decodeIterator.hasNext(), equalTo(true));

    assertThatCode(() -> decodeIterator.forEachRemaining(stub -> {
    })).doesNotThrowAnyException();

    assertThat(decodeIterator.hasNext(), equalTo(false));
  }

  @Test
  public void shouldFailParse() {
    final String encoded = "00020101021102160004hoge0104abcd520441115303156540523.7255020256035005802CN5914BEST TRANSPORT6007BEIJING6107123456762950105123450205678900305098760405543210505abcde0605fghij0705klmno0805pqres0903tuv1004abcd5004ijkl64280002ZH0102北京0204最佳运输0304abcd65020080320016A0112233449988770708123456786304C659";

    final DecoderIterator decodeIterator = new DecoderIterator(encoded);

    assertThat(decodeIterator.hasNext(), equalTo(true));

    assertThatCode(() -> decodeIterator.forEachRemaining(stub -> {
    })).doesNotThrowAnyException();

    final Throwable throwable = catchThrowable(() -> decodeIterator.next());

    assertThat(throwable).isInstanceOf(NoSuchElementException.class);

  }

}
