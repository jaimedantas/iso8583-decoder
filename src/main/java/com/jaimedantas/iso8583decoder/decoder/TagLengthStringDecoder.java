package com.jaimedantas.iso8583decoder.decoder;

import com.jaimedantas.iso8583decoder.core.map.TagLengthString;
import com.jaimedantas.iso8583decoder.core.ultils.TLVUtils;
import com.jaimedantas.iso8583decoder.exception.DecodeException;

public final class TagLengthStringDecoder extends Decoder<TagLengthString> {

  public TagLengthStringDecoder(final String source) {
    super(source);
  }

  @Override
  protected TagLengthString decode() throws DecodeException {
    final TagLengthString result = new TagLengthString();

    while(iterator.hasNext()) {
      final String value = iterator.next();
      result.setTag(TLVUtils.valueOfTag(value));
      result.setValue(TLVUtils.valueOf(value));
    }

    return result;
  }

}

