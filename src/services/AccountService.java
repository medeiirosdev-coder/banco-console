package services;

import entities.*;
import repository.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

public class AccountService {

    private final TransactionService transactionService;
    private final AccountRepository repository;

    public AccountService(TransactionService transactionService, AccountRepository repository) {
        this.transactionService = transactionService;
        this.repository = repository;
    }

    public void createAccount(Long number, String holder, BigDecimal balance, AccountType type){

        if (repository.existsByNumber(number)){

            throw new IllegalArgumentException("Já existe uma conta com o número: " + number);

        }

        repository.createAccount(number,holder,balance, type);

    }

    public Account withdraw(Long number, BigDecimal amount){

        Account acc = repository.findByNumber(number)
                .orElseThrow(() -> new IllegalArgumentException("Conta de número " + number + " não encontrada."));

        acc.withdraw(amount);
        repository.save(acc);

        transactionService.createTransaction(acc, TransactionType.WITHDRAW, amount);

        return acc;

    }

    public Account deposit(Long number, BigDecimal amount){

        Account acc = repository.findByNumber(number)
                .orElseThrow(() -> new IllegalArgumentException("Conta de número " + number + " não encontrada."));

        acc.deposit(amount);
        repository.save(acc);

        transactionService.createTransaction(acc, TransactionType.DEPOSIT, amount);

        return acc;

    }

    public Account findAccount(Long number){

        return repository.findByNumber(number)
                .orElseThrow(() ->  new IllegalArgumentException("Conta de número " + number + " não encontrada."));

    }

    public List<Transaction> fetchBankStatement(Long number){

        Account acc = repository.findByNumber(number)
                .orElseThrow(() -> new IllegalArgumentException("Conta de número " + number + " não encontrada."));

        return transactionService.getBankStatement(acc);

    }

}
