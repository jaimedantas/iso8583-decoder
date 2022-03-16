package com.jaimedantas.iso8583decoder.model.message;

import lombok.Data;

@Data
public class Response {
    AccountInformation receiver;
    AccountInformation sender;
    ReferenceData referenceData;
}
