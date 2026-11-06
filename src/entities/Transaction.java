package entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private Account account;
    private TransactionType transactionType;
    private BigDecimal amount;
    private LocalDateTime dateTime;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


    public Transaction(Account account, TransactionType transactionType, BigDecimal amount) {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return  "Tipo de Transação: " + getTransactionType().getDescription()
                + "\nValor: " +  getAmount()
                + "\nData: " + getDateTime().format(dtf);
    }
}
