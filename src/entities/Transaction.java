package entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private Long accountNumber;
    private TransactionType transactionType;
    private BigDecimal amount;
    private LocalDateTime dateTime;
    private Long counterpartAccountNumber;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Transaction(Long accountNumber, BigDecimal amount, TransactionType transactionType) {
        this.accountNumber = accountNumber;
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

    public Long getCounterpartAccountNumber() {
        return counterpartAccountNumber;
    }

    @Override
    public String toString() {
        return  "Valor: " +  getAmount()
                + "\nData: " + getDateTime().format(dtf);
    }
}
