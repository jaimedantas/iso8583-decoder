package com.jaimedantas.iso8583decoder.decoder;

import com.jaimedantas.iso8583decoder.core.ultils.TLVUtils;
import com.jaimedantas.iso8583decoder.exception.DecodeException;
import lombok.SneakyThrows;

import java.util.Iterator;
import java.util.function.Consumer;

final class DecoderIterator implements Iterator<String> {

  private Integer current;
  private final Integer max;
  private final String source;

  public DecoderIterator(final String source) {
    current = 0;
    max = source.length();
    this.source = source;
  }

  @Override
  public boolean hasNext() {

    if (current >= max) {
      return false;
    }

    final Integer valueLength = TLVUtils.valueOfLength(source, current);

    return current + TLVUtils.ID_WORD_COUNT + TLVUtils.VALUE_LENGTH_WORD_COUNT + valueLength <= max;
  }

  @Override
  public void forEachRemaining(final Consumer<? super String> action) {
    while (hasNext()) {
      action.accept(next());
    }
  }

  @SneakyThrows
  @Override
  public String next() {

    if(!hasNext()){
      throw new DecodeException("No such element");
    }

    final String value = TLVUtils.chunk(source, current);

    current += value.length();

    return value;
  }

}
