package com.jaimedantas.iso8583decoder.decoder;


import com.jaimedantas.iso8583decoder.core.ultils.TLVUtils;

// @formatter:off
public final class StringDecoder extends DecoderMpm<String> {

  public StringDecoder(final String source) {
    super(source);
  }

  @Override
  protected String decode() throws IllegalArgumentException {
    final StringBuilder result = new StringBuilder();

    while(iterator.hasNext()) {
      final String value = iterator.next();
      result.append(TLVUtils.valueOf(value));
    }

    return result.toString();
  }

}
// @formatter:on
