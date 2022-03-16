package com.jaimedantas.iso8583decoder.model.message.enums;

public enum FundingSource {
    CREDIT("01"),
    DEBIT("02"),
    PREPAID("03"),
    DEPOSIT_ACCOUNT("04"),
    MOBILE_MONEY_ACCOUNT("05"),
    CASH("06"),
    OTHER("07");

    private final String value;

    FundingSource(final String value){
        this.value = value;
    }

    public static FundingSource fromString(String commandText) {
        for (FundingSource c : FundingSource.values()) {
            if (c.value.equals(commandText)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return value;
    }
}
