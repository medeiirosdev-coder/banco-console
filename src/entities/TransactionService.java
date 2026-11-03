package entities;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class TransactionService {

    Map<Long, Transaction> transactions = new HashMap<>();


    public void createTransaction(Account acc, TransactionType transactionType, BigDecimal amount){

        Transaction newTransaction = new Transaction(acc, transactionType, amount);

        transactions.put(acc.getNumber(),newTransaction);

    }

    public Transaction getBankStatement(Account acc){

        return transactions.get(acc.getNumber());

    }


}
