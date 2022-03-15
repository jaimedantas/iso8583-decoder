package com.jaimedantas.iso8583decoder.core;

import java.io.Serializable;
import java.util.Optional;

public interface TLV<T, V> extends Serializable {

  public T getTag();

  public V getValue();

  default Integer getLength() {
    return Optional.ofNullable(getValue()).map(V::toString).map(String::length).orElse(0);
  }

}
