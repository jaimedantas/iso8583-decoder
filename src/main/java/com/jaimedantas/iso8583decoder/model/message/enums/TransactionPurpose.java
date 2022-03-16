package com.jaimedantas.iso8583decoder.model.message.enums;

public enum TransactionPurpose {

    FAMILY_SUPPORT("00"),
    REGULAR_LABOR_TRANSFER_EXPATRIATES("01"),
    TRAVEL_AND_TOURISM("02"),
    EDUCATION("03"),
    HOSPITALIZATION_AND_MEDICAL_TREATMENT("04"),
    EMERGENCY_NEED("05"),
    SAVINGS("06"),
    GIFTS("07"),
    OTHER("08"),
    SALARY("09"),
    CROWD_LENDING("10"),
    CRYPTO_CURRENCY("11");

    private final String value;

    TransactionPurpose(final String value){
        this.value = value;
    }

    public static TransactionPurpose fromString(String commandText) {
        for (TransactionPurpose c : TransactionPurpose.values()) {
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
