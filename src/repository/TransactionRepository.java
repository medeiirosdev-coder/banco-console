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

    public void createTransaction(Transaction transaction){

        transactions.add(transaction);

    }


    public List<Transaction> getBankStatement(Long number){

        return transactions.stream()
                .filter(transaction -> transaction.getAccountNumber().equals(number))
                .toList();

    }

    public Map<TransactionType,List<Transaction>> statementByPeriod(Long number, LocalDate startDate, LocalDate endDate){

        return transactions
                .stream()
                .filter(transaction -> transaction.getAccountNumber().equals(number))
                .filter(transaction -> !transaction.getDateTime().toLocalDate().isBefore(startDate) && !transaction.getDateTime().toLocalDate().isAfter(endDate) )
                .sorted(Comparator.comparing(Transaction::getDateTime))
                .collect(Collectors.groupingBy(Transaction::getTransactionType));


    }




}

