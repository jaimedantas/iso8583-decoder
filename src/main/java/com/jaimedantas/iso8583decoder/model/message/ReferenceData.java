package com.jaimedantas.iso8583decoder.model.message;

import com.jaimedantas.iso8583decoder.model.message.enums.FundingSource;
import com.jaimedantas.iso8583decoder.model.message.enums.TransactionPurpose;
import lombok.Data;

@Data
public class ReferenceData {
    FundingSource fundingSource;
    TransactionPurpose transactionPurpose;

    public String getFundingSource(){
        return this.fundingSource.toString();
    }
    public String getTransactionPurpose(){
        return this.transactionPurpose.toString();
    }
}
