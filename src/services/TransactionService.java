package services;

import entities.Account;
import entities.Transaction;
import entities.TransactionType;
import repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class TransactionService {


    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void internalTransaction(Long number, BigDecimal amount, TransactionType transactionType){

        transactionRepository.createTransaction(new Transaction(number,amount,transactionType));

    }


    public void transfer(Long sourceAcc, Long targetAcc,  BigDecimal amount){

        transactionRepository.createTransaction(new Transaction(sourceAcc,TransactionType.TRANSFER_IN,amount,targetAcc));
        transactionRepository.createTransaction(new Transaction(targetAcc,TransactionType.TRANSFER_OUT,amount,sourceAcc));

    }

    public List<Transaction> getBankStatement(Account acc){


        return transactionRepository.getBankStatement(acc.getNumber());


    }

    public Map<TransactionType, List<Transaction>> statementByPeriod(Long number, LocalDate startDate, LocalDate endDate){

        return transactionRepository.statementByPeriod(number, startDate,endDate);

    }

}
