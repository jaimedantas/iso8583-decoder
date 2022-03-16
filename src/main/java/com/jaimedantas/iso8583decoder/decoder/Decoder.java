package com.jaimedantas.iso8583decoder.decoder;

import com.jaimedantas.iso8583decoder.configuration.DecodersMap;
import com.jaimedantas.iso8583decoder.exception.DecodeException;

import java.lang.reflect.Constructor;
import java.util.AbstractMap.SimpleEntry;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

public abstract class Decoder<T> {

  private static final Map<Class<?>, Constructor<? extends Decoder<?>>> ctorMap = new ConcurrentHashMap<>();

  protected final Iterator<String> iterator;

  protected Decoder(final String source) {
    this.iterator = new DecoderIterator(source);
  }

  protected abstract T decode() throws IllegalArgumentException, DecodeException;

  protected static <C, T> Entry<Class<?>, BiConsumer<C, ?>> consumerTagLengthValue(final Class<T> clazz, final BiConsumer<C, T> consumer) {
    return new SimpleEntry<>(clazz, consumer);
  }

  /**
   * Decode TLV using string
   *
   * @param <T> target class
   * @param source string TLV
   * @param clazz target class
   * @return target class result
   * @throws DecodeException
   */
  public static <T> T decode(final String source, final Class<T> clazz) throws DecodeException {
    try {
      final Class<? extends Decoder<?>> parserClass = DecodersMap.getDecoder(clazz);

      if (!ctorMap.containsKey(clazz)) {
        ctorMap.put(clazz, parserClass.getConstructor(String.class));
      }

      final Constructor<? extends Decoder<?>> ctor = ctorMap.get(clazz);
      final Decoder<?> parser = ctor.newInstance(source);
      return clazz.cast(parser.decode());
    } catch (final Exception ex) {
      throw new DecodeException(ex.getMessage());
    }
  }

}
