package com.jaimedantas.iso8583decoder.mapper;

import com.jaimedantas.iso8583decoder.model.iso8583.DataElement108;
import com.jaimedantas.iso8583decoder.model.message.Response;

public interface Mapper {
    Response dataElement108ToResponse(DataElement108 dataElement108);
}
