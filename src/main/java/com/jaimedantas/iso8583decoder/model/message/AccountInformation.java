package com.jaimedantas.iso8583decoder.model.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountInformation {
    String first;
    String middle;
    String last;
    String city;
    String state;
    String account;
}
