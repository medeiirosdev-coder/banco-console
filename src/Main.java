import entities.AccountService;
import entities.Menu;
import entities.TransactionService;


public class Main {


    public static void main(String[] args) {


        TransactionService transactionService = new TransactionService();
        AccountService accountService = new AccountService(transactionService);

        Menu menu = new Menu(accountService);
        menu.start();



    }

}