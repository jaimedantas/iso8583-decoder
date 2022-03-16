package com.jaimedantas.iso8583decoder.core.utils;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import com.jaimedantas.iso8583decoder.core.ultils.TLVUtils;
import org.junit.Test;

public class TLVUtilsTest {

  /**
   * This entire test set was copied from https://github.com/mvallim/emv-qrcode
   */

  @Test
  public void testSuccessValueOfTag() {
    assertThat(TLVUtils.valueOfTag("01070103100"), equalTo("01"));
    assertThat(TLVUtils.valueOfTag("XXXX01070103100", 4), equalTo("01"));
  }

  @Test
  public void testSuccessValueOfLength() {
    assertThat(TLVUtils.valueOfLength("01070103100"), equalTo(7));
    assertThat(TLVUtils.valueOfLength("XXXX01070103100", 4), equalTo(7));
  }

  @Test
  public void testSuccessValueOf() {
    assertThat(TLVUtils.valueOf("01070103100"), equalTo("0103100"));
    assertThat(TLVUtils.valueOf("XXXX01070103100", 4), equalTo("0103100"));
  }

  @Test
  public void testSuccessChunk() {
    assertThat(TLVUtils.chunk("01070103100", 0), equalTo("01070103100"));
    assertThat(TLVUtils.chunk("01070103100020512345", 11), equalTo("020512345"));
  }

}
