import entities.AccountService;
import entities.Menu;


public class Main {


    public static void main(String[] args) {

        AccountService accountService = new AccountService();

        Menu menu = new Menu(accountService);
        menu.start();



    }

}