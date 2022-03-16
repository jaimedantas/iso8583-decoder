package com.jaimedantas.iso8583decoder.model;

import com.jaimedantas.iso8583decoder.core.map.TagLengthString;
import com.jaimedantas.iso8583decoder.model.iso8583.AccountHolder;
import org.junit.Assert;
import org.junit.Test;

public class AccountHolderTest {

    @Test
    public void shouldGenerateObjectFromAccount(){
        AccountHolder accountHolder = new AccountHolder();

        accountHolder.setFirstName(new TagLengthString("01","JAIME"));
        accountHolder.setMiddleName(new TagLengthString("02","C"));
        accountHolder.setLastName(new TagLengthString("03","DANTAS"));
        accountHolder.setCity(new TagLengthString("05","TORONTO"));
        accountHolder.setState(new TagLengthString("06","ON"));
        accountHolder.setAccountNumber(new TagLengthString("11","0000001"));

        Assert.assertNotNull(accountHolder);
    }

}
