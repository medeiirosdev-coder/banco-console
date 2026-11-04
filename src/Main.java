import repository.AccountRepository;
import repository.TransactionRepository;
import services.AccountService;
import application.Menu;
import services.TransactionService;


public class Main {


    public static void main(String[] args) {

        AccountRepository accountRepository = new AccountRepository();
        TransactionRepository transactionRepository = new TransactionRepository();

        TransactionService transactionService = new TransactionService(transactionRepository);
        AccountService accountService = new AccountService(transactionService, accountRepository);



        Menu menu = new Menu(accountService);
        menu.start();



    }

}