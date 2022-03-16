package com.jaimedantas.iso8583decoder.core.map;

import com.jaimedantas.iso8583decoder.core.TLV;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Setter
@Getter
@AllArgsConstructor
public class TagLengthString implements TLV<String, String> {

  private static final long serialVersionUID = -5164041778566004362L;

  private String tag;
  private String value;

  public TagLengthString() {
    super();
  }

  @Override
  public String toString() {

    if (StringUtils.isBlank(value)) {
      return StringUtils.EMPTY;
    }

    return String.format("%s%02d%s", tag, value.length(), value);
  }

}
