package com.jaimedantas.iso8583decoder.model;

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

    public void setReceiverData(final AccountHolderReceiverTemplate receiverData) {
        this.receiverData = receiverData;
    }

    public void setSenderData(final AccountHolderSenderTemplate senderData) {
        this.senderData = senderData;
    }

    public void setTransactionReferenceDataTemplate(final TransactionReferenceDataTemplate transactionReferenceDataTemplate) {
        this.transactionReferenceDataTemplate = transactionReferenceDataTemplate;
    }

}
