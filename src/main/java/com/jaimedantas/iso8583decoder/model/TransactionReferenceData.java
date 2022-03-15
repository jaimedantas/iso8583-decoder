package com.jaimedantas.iso8583decoder.model;

import com.jaimedantas.iso8583decoder.core.mpm.TagLengthString;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TransactionReferenceData implements Serializable {

    private static final long serialVersionUID = -3284239118541044408L;

    private TagLengthString fundingSource;
    private TagLengthString transactionPurpose;

}
