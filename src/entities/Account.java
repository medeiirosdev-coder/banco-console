package entities;

import java.math.BigDecimal;

public abstract class Account {

    private final Long number;
    private final String holder;
    private BigDecimal balance = BigDecimal.ZERO;

    public Account(Long number, String holder, BigDecimal balance) {
        this.number = number;
        this.holder = holder;
        deposit(balance);
    }

    public Long getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount){

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor para depósito deve ser positivo e maior que zero.");
        }

        this.balance = this.balance.add(amount);

    }

    public void withdraw(BigDecimal amount){

        if(balance.compareTo(amount) < 0){
            throw new IllegalArgumentException("Saldo insuficiente.");
        }

        this.balance = this.balance.subtract(amount);

    }

    @Override
    public String toString() {
        return "Número da Conta: " + getNumber()
                + "\nTitular: " + getHolder()
                + "\nSaldo: " + getBalance();
    }
}
