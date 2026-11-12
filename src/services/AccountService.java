package services;

import entities.*;
import exceptions.AccountAlreadyExistsException;
import exceptions.AccountNotFoundException;
import exceptions.TransferDepositException;
import exceptions.TransferSameAccException;
import repository.AccountRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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

    public void withdraw(Long number, BigDecimal amount, TransactionType transactionType){

        Account acc = findAccount(number);

        acc.withdraw(amount);

        transactionService.internalTransaction(number,amount,transactionType);

    }

    public void deposit(Long number, BigDecimal amount, TransactionType transactionType){

        Account acc = findAccount(number);

        acc.deposit(amount);

        transactionService.internalTransaction(number,amount,transactionType);

    }


    public List<Transaction> fetchBankStatement(Long number){

        Account acc = findAccount(number);

        return transactionService.getBankStatement(acc);

    }

    public Map<TransactionType, List<Transaction>> statementByPeriod(Long number, LocalDate startDate, LocalDate endDate){

        return transactionService.statementByPeriod(number, startDate,endDate);

    }

    public void transfer(Long fromNumberAcc, Long toNumberAcc,BigDecimal transferAmount){

        if (fromNumberAcc.equals(toNumberAcc)){
            throw new TransferSameAccException("Transação falhou: não é possível transferir saldo para a mesma conta");
        }

        Account source = findAccount(fromNumberAcc);
        Account target = findAccount(toNumberAcc);

        source.withdraw(transferAmount);

        try {
            target.deposit(transferAmount);
        } catch (TransferDepositException e){

            source.deposit(transferAmount);
            transactionService.internalTransaction(source.getNumber(), transferAmount, TransactionType.REFUND);
            throw e;
        }

        transactionService.transfer(fromNumberAcc,toNumberAcc, transferAmount);

    }

}
