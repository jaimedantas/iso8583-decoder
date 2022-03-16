package com.jaimedantas.iso8583decoder.mapper;

import com.jaimedantas.iso8583decoder.model.iso8583.DataElement108;
import com.jaimedantas.iso8583decoder.model.message.ResponseSingleTransaction;

public interface DataElement108Mapper {
    ResponseSingleTransaction dataElement108ToResponse(DataElement108 dataElement108);
}
