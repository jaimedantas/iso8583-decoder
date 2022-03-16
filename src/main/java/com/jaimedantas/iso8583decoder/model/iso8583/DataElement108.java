package com.jaimedantas.iso8583decoder.model.iso8583;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DataElement108 implements Serializable {

    private static final long serialVersionUID = -6292647268318625092L;

    private AccountHolderReceiverTemplate receiverData;
    private AccountHolderSenderTemplate senderData;
    private TransactionReferenceDataTemplate transactionReferenceDataTemplate;

}
