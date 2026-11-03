package entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AccountService {

    private List<Account> accounts = new ArrayList<>();


    public Account findByNumber(Long number){

        for (Account acc : accounts) {

            if (!acc.getNumber().equals(number)){

                throw new IllegalArgumentException("Conta não encontrada");

            }

            return acc;

        }


        return null;
    }

    public void createAccount(Long number, String holder, BigDecimal balance, AccountType type){

        Account newAccount = switch(type) {
            case SAVINGS -> new SavingsAccount(number,holder,balance);
            case CHECKING -> new CheckingAccount(number,holder,balance);
        };

        accounts.add(newAccount);

    }

    public Account withdraw(Long number, BigDecimal amount){

        Account acc = findByNumber(number);

        acc.withdraw(amount);

        return acc;

    }

    public Account deposit(Long number, BigDecimal amount){

        Account acc = findByNumber(number);

        acc.deposit(amount);

        return acc;

    }

}
