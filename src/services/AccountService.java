package services;

import entities.*;
import exceptions.AccountAlreadyExistsException;
import exceptions.AccountNotFoundException;
import exceptions.TransferDepositException;
import exceptions.TransferSameAccException;
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


    public Account findAccount(Long number){

        return repository.findByNumber(number)
                .orElseThrow(() ->  new AccountNotFoundException("Conta de número " + number + " não encontrada."));

    }


    public void createAccount(Long number, String holder, BigDecimal balance, AccountType type){

        if (repository.existsByNumber(number)){

            throw new AccountAlreadyExistsException("Já existe uma conta com o número: " + number);

        }

        repository.createAccount(number,holder,balance, type);

    }

    public Account withdraw(Long number, BigDecimal amount, TransactionType transactionType){

        Account acc = findAccount(number);

        acc.withdraw(amount);
        repository.save(acc);

        transactionService.createTransaction(acc, transactionType, amount);

        return acc;

    }

    public Account deposit(Long number, BigDecimal amount, TransactionType transactionType){

        Account acc = findAccount(number);

        acc.deposit(amount);
        repository.save(acc);

        transactionService.createTransaction(acc, transactionType, amount);

        return acc;

    }


    public List<Transaction> fetchBankStatement(Long number){

        Account acc = findAccount(number);

        return transactionService.getBankStatement(acc);

    }

    public void transfer(Long fromNumberAcc, Long toNumberAcc, BigDecimal transferAmount){

        if (fromNumberAcc.equals(toNumberAcc)){
            throw new TransferSameAccException("Não é possível transferir para a mesma conta.");
        }

        withdraw(fromNumberAcc,  transferAmount,TransactionType.TRANSFER_IN);

        try {
            deposit(toNumberAcc, transferAmount, TransactionType.TRANSFER_OUT);
        } catch (TransferDepositException e){
            deposit(fromNumberAcc,transferAmount,TransactionType.REFUND);
            throw e;
        }



    }

}
