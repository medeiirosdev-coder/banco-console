package application;

import entities.AccountType;
import entities.TransactionType;
import exceptions.*;
import services.AccountService;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private final Scanner sc = new Scanner(System.in);
    private final AccountService accountService;

    public Menu(AccountService accountService) {
        this.accountService = accountService;
    }

    public void start(){

            boolean running = true;

            while(running){

                try {

                    System.out.println("== CONSOLE ==");
                    System.out.println("1 - Criar Conta");
                    System.out.println("2 - Sacar");
                    System.out.println("3 - Depositar");
                    System.out.println("4 - Procurar conta");
                    System.out.println("5 - Extrato Bancário");
                    System.out.println("6 - Transferir");
                    System.out.println("0 - Sair");
                    int option = sc.nextInt();


                    switch (option){

                        case 1 -> createAccount();
                        case 2 -> withdraw();
                        case 3 -> deposit();
                        case 4 -> searchAccount();
                        case 5 -> fetchBankStatement();
                        case 6 -> transfer();
                        case 0 -> running = false;
                        default -> System.out.println("Opção inválida.");

                    }

                } catch (InputMismatchException e) {

                    System.out.println("Digite apenas números.");
                    sc.nextLine();

                } catch (IllegalArgumentException e){
                    System.out.println("Erro: " + e.getMessage());

                } catch (AccountAlreadyExistsException | InsufficientBalanceException | InvalidAmountException |
                         AccountNotFoundException  | InvalidTypeOfAccountException e){

                    System.out.println(e.getMessage());

                }


            }

        sc.close();
    }


    public void createAccount(){

        System.out.println("1 - Conta Poupança");
        System.out.println("2 - Conta Corrente");
        int option = sc.nextInt();

        AccountType type = switch(option){
            case 1 -> AccountType.SAVINGS;
            case 2 -> AccountType.CHECKING;
            default -> throw new InvalidTypeOfAccountException("Tipo de conta não existe:  " + option);
        };

        System.out.println("Número da conta: ");
        Long number = sc.nextLong();
        sc.nextLine();

        System.out.println("Nome do titular: ");
        String holder = sc.nextLine();

        System.out.println("Saldo inicial: ");
        BigDecimal balance = sc.nextBigDecimal();

        accountService.createAccount(number,holder,balance, type);

    }

    public void withdraw(){

        System.out.println("Número da conta: ");
        Long number = sc.nextLong();
        sc.nextLine();

        System.out.println("Insira o quanto deseja sacar: ");
        BigDecimal amount = sc.nextBigDecimal();


        System.out.println(accountService.withdraw(number, amount, TransactionType.WITHDRAW));

    }

    public void deposit()  {

        System.out.println("Número da conta: ");
        Long number = sc.nextLong();
        sc.nextLine();

        System.out.println("Insira o quanto deseja depositar: ");
        BigDecimal amount = sc.nextBigDecimal();

        System.out.println(accountService.deposit(number, amount, TransactionType.DEPOSIT));


    }

    public void searchAccount(){

        System.out.println("Número da conta: ");
        Long number = sc.nextLong();
        sc.nextLine();

        System.out.println(accountService.findAccount(number));

    }

    public void fetchBankStatement(){

        System.out.println("Número da conta: ");
        Long number = sc.nextLong();
        sc.nextLine();


        System.out.println(accountService.fetchBankStatement(number));

    }

    public void transfer(){

        System.out.println("Número da conta que irá enviar: ");
        Long numberFromAcc = sc.nextLong();
        sc.nextLine();

        System.out.println("Número da conta que irá receber: ");
        Long numberToAcc = sc.nextLong();
        sc.nextLine();

        System.out.println("Valor de transferência: ");
        BigDecimal transferAmount = sc.nextBigDecimal();

        accountService.transfer(numberFromAcc, numberToAcc, transferAmount);


    }

}

























