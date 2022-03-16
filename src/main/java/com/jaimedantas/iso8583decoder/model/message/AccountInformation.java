package com.jaimedantas.iso8583decoder.model.message;

import lombok.Data;

@Data
public class AccountInformation {
    String first;
    String middle;
    String last;
    String city;
    String state;
    String account;
}
