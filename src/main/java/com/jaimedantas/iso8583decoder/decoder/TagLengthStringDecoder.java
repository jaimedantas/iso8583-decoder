package com.jaimedantas.iso8583decoder.decoder;

import com.jaimedantas.iso8583decoder.core.mpm.TagLengthString;
import com.jaimedantas.iso8583decoder.core.ultils.TLVUtils;

// @formatter:off
public final class TagLengthStringDecoder extends DecoderMpm<TagLengthString> {

  public TagLengthStringDecoder(final String source) {
    super(source);
  }

  @Override
  protected TagLengthString decode() throws IllegalArgumentException {
    final TagLengthString result = new TagLengthString();

    while(iterator.hasNext()) {
      final String value = iterator.next();
      result.setTag(TLVUtils.valueOfTag(value));
      result.setValue(TLVUtils.valueOf(value));
    }

    return result;
  }

}

// @formatter:on
