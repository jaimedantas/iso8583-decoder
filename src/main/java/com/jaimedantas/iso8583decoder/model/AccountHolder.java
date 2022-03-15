package com.jaimedantas.iso8583decoder.model;

import com.jaimedantas.iso8583decoder.core.mpm.TagLengthString;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class AccountHolder implements Serializable {

    private static final long serialVersionUID = -7468210501969513049L;

    private TagLengthString firstName;
    private TagLengthString middleName;
    private TagLengthString lastName;
    private TagLengthString city;
    private TagLengthString state;
    private TagLengthString accountNumber;

}
