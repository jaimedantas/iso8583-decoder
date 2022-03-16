package com.jaimedantas.iso8583decoder.validator;

import br.com.fluentvalidator.AbstractValidator;
import com.jaimedantas.iso8583decoder.model.iso8583.TransactionReferenceData;
import com.jaimedantas.iso8583decoder.model.iso8583.TransactionReferenceDataTemplate;
import com.jaimedantas.iso8583decoder.model.message.enums.FundingSource;
import com.jaimedantas.iso8583decoder.model.message.enums.TransactionPurpose;

import java.util.Objects;

import static br.com.fluentvalidator.function.FunctionBuilder.of;

    public class ReferenceDataValidator extends AbstractValidator<TransactionReferenceDataTemplate> {

    @Override
    public void rules() {
        ruleFor("ReferenceData", TransactionReferenceDataTemplate::getValue)
                .must(this::checkFundingSource)
                .withMessage("Funding Source is invalid")
                .withAttempedValue(of(TransactionReferenceData::getFundingSource))
                .critical()
                .must(this::checkTransactionPurposeSource)
                .withMessage("Transaction Purpose is invalid")
                .withAttempedValue(of(TransactionReferenceData::getTransactionPurpose))
                .critical()
                .must(this::checkCrypto)
                .withMessage("Transaction cannot be completed since it is for crypto purpose")
                .withAttempedValue(of(TransactionReferenceData::getTransactionPurpose))
                .critical();
    }

    private boolean checkFundingSource(final TransactionReferenceData transactionReferenceData) {
        return !Objects.isNull(FundingSource.fromString(transactionReferenceData.getFundingSource().getValue()));
    }
    private boolean checkTransactionPurposeSource(final TransactionReferenceData transactionReferenceData) {
        return !Objects.isNull(TransactionPurpose.fromString(transactionReferenceData.getTransactionPurpose().getValue()));
    }
    private boolean checkCrypto(final TransactionReferenceData transactionReferenceData) {
        return !transactionReferenceData.getTransactionPurpose().getValue().equals(TransactionPurpose.CRYPTO_CURRENCY.toString());
    }
}
