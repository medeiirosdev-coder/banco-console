package entities;

import java.math.BigDecimal;

public class Transaction {

    private Account account;
    private TransactionType transactionType;
    private BigDecimal amount;

    public Transaction(Account account, TransactionType transactionType, BigDecimal amount) {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Conta: " + getAccount()
                + "\nTipo de Transação: " + getTransactionType()
                + "\nValor: " +  getAmount() ;
    }
}
