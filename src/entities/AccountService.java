package entities;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class AccountService {

    private Map<Long, Account> accounts = new HashMap<>();


    public Account findByNumber(Long number){

        if (accounts.get(number) != null){
            throw new IllegalArgumentException("Conta não encontrada.");
        }

        return accounts.get(number);
    }

    public void createAccount(Long number, String holder, BigDecimal balance, AccountType type){

        Account newAccount = switch(type) {
            case SAVINGS -> new SavingsAccount(number,holder,balance);
            case CHECKING -> new CheckingAccount(number,holder,balance);
        };

        accounts.put(newAccount.getNumber(),newAccount);

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
