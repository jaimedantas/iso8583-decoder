package com.jaimedantas.iso8583decoder.model.iso8583;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jaimedantas.iso8583decoder.core.map.TagLengthString;
import lombok.Data;

import java.io.Serializable;

@Data
public class AccountHolder implements Serializable {

    private static final long serialVersionUID = -7468210501969513049L;

    @JsonProperty("first")
    private TagLengthString firstName;
    private TagLengthString middleName;
    private TagLengthString lastName;
    private TagLengthString city;
    private TagLengthString state;
    private TagLengthString accountNumber;

}
