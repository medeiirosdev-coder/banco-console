package entities;

import java.math.BigDecimal;

public class CheckingAccount extends Account implements Taxable{

    private static final BigDecimal TAX_RATE = new BigDecimal("1.00");

    public CheckingAccount(Long number, String holder, BigDecimal balance) {
        super(number, holder, balance);
    }


    @Override
    public void withdraw(BigDecimal amount) {
        super.withdraw(amount.add(calculateTax()));
    }

    @Override
    public BigDecimal calculateTax() {
        return TAX_RATE;
    }

    @Override
    public AccountType getType() {
        return AccountType.CHECKING;
    }
}
