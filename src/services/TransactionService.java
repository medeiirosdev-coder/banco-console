package services;

import entities.Account;
import entities.Transaction;
import entities.TransactionType;
import repository.TransactionRepository;

import java.math.BigDecimal;
import java.util.List;

public class TransactionService {


    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void createTransaction(Account acc, TransactionType transactionType, BigDecimal amount){

        transactionRepository.createTransaction(acc, transactionType, amount);

    }

    public List<Transaction> getBankStatement(Account acc){


        return transactionRepository.getBankStatement(acc.getNumber());


    }


}
