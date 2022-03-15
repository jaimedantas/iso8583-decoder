package com.jaimedantas.iso8583decoder.core.mpm;

import com.jaimedantas.iso8583decoder.core.TLV;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Setter
public class TagLengthString implements TLV<String, String> {

  private static final long serialVersionUID = -6482977134879939277L;

  private String tag;

  private String value;

  public TagLengthString() {
    super();
  }

  public TagLengthString(final String tag, final String value) {
    this.tag = tag;
    this.value = value;
  }

  @Override
  public String getTag() {
    return tag;
  }

  @Override
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {

    if (StringUtils.isBlank(value)) {
      return StringUtils.EMPTY;
    }

    return String.format("%s%02d%s", tag, value.length(), value);
  }

}
