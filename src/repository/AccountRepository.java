package repository;

import entities.Account;
import entities.AccountType;
import entities.CheckingAccount;
import entities.SavingsAccount;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AccountRepository {

    private final Map<Long, Account> accounts = new HashMap<>();


    public void save(Account acc){
        accounts.put(acc.getNumber(), acc);
    }

    public boolean existsByNumber(Long number){
        return accounts.containsKey(number);
    }

    public Optional<Account> findByNumber(Long number){

        return Optional.ofNullable(accounts.get(number));

    }

    public void createAccount(Long number, String holder, BigDecimal balance, AccountType type){

        Account newAccount = switch(type) {
            case SAVINGS -> new SavingsAccount(number,holder,balance);
            case CHECKING -> new CheckingAccount(number,holder,balance);
        };

        accounts.put(newAccount.getNumber(),newAccount);

    }


}
