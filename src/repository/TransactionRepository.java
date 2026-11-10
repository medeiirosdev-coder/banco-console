package repository;

import entities.Account;
import entities.Transaction;
import entities.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TransactionRepository {


    private final List<Transaction> transactions = new ArrayList<>();

    public void createTransaction(Account acc, TransactionType transactionType, BigDecimal amount){

        Transaction newTransaction = new Transaction(acc, transactionType, amount);

        transactions.add(newTransaction);

    }

    public List<Transaction> getBankStatement(Long number){

        return transactions.stream()
                .filter(transaction -> transaction.getAccount().getNumber().equals(number))
                .toList();

    }


}

