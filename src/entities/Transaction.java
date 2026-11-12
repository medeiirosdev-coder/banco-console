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

    public Transaction(Long accountNumber, TransactionType transactionType, BigDecimal amount, Long counterpartAccountNumber) {
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
        this.counterpartAccountNumber = counterpartAccountNumber;
    }

    public Long getAccountNumber() {
        return accountNumber;
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
        return  "Valor: R$" +  String.format("%.2f",getAmount()) + " Data: " + getDateTime().format(dtf);
    }
}
