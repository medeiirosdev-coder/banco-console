package entities;

import java.math.BigDecimal;

public class SavingsAccount extends Account {


    public SavingsAccount(Long number, String holder, BigDecimal balance) {
        super(number, holder, balance);
    }

    @Override
    public AccountType getType() {
        return AccountType.SAVINGS;
    }

}
