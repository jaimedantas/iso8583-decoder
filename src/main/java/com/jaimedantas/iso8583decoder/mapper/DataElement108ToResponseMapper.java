package com.jaimedantas.iso8583decoder.mapper;

import com.jaimedantas.iso8583decoder.model.iso8583.DataElement108;
import com.jaimedantas.iso8583decoder.model.message.AccountInformation;
import com.jaimedantas.iso8583decoder.model.message.ReferenceData;
import com.jaimedantas.iso8583decoder.model.message.Response;
import com.jaimedantas.iso8583decoder.model.message.enums.FundingSource;
import com.jaimedantas.iso8583decoder.model.message.enums.TransactionPurpose;

import java.util.Objects;


public class DataElement108ToResponseMapper implements Mapper {

    @Override
    public Response dataElement108ToResponse(DataElement108 dataElement108) {
        if (dataElement108 == null){
            return null;
        }
        Response response = new Response();
        AccountInformation accountInformationSender = new AccountInformation();
        AccountInformation accountInformationReceiver = new AccountInformation();
        ReferenceData referenceData = new ReferenceData();

        accountInformationSender.setAccount(dataElement108.getSenderData().getValue().getAccountNumber().getValue());
        accountInformationSender.setCity(dataElement108.getSenderData().getValue().getCity().getValue());
        accountInformationSender.setFirst(dataElement108.getSenderData().getValue().getFirstName().getValue());
        accountInformationSender.setLast(dataElement108.getSenderData().getValue().getLastName().getValue());
        if (!Objects.isNull(dataElement108.getSenderData().getValue().getMiddleName())) {
            accountInformationSender.setMiddle(dataElement108.getSenderData().getValue().getMiddleName().getValue());
        }
        accountInformationSender.setState(dataElement108.getSenderData().getValue().getState().getValue());

        accountInformationReceiver.setAccount(dataElement108.getReceiverData().getValue().getAccountNumber().getValue());
        accountInformationReceiver.setCity(dataElement108.getReceiverData().getValue().getCity().getValue());
        accountInformationReceiver.setFirst(dataElement108.getReceiverData().getValue().getFirstName().getValue());
        accountInformationReceiver.setLast(dataElement108.getReceiverData().getValue().getLastName().getValue());
        if (!Objects.isNull(dataElement108.getReceiverData().getValue().getMiddleName())) {
            accountInformationReceiver.setMiddle(dataElement108.getReceiverData().getValue().getMiddleName().getValue());
        }
        accountInformationReceiver.setState(dataElement108.getReceiverData().getValue().getState().getValue());

        referenceData.setFundingSource(FundingSource.fromString(dataElement108.getTransactionReferenceDataTemplate().getValue().getFundingSource().getValue()));
        referenceData.setTransactionPurpose(TransactionPurpose.fromString(dataElement108.getTransactionReferenceDataTemplate().getValue().getTransactionPurpose().getValue()));

        response.setReceiver(accountInformationReceiver);
        response.setSender(accountInformationSender);
        response.setReferenceData(referenceData);

        return response;

    }

}
