package banking;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean continueLoop = true;
        int choice=0;
        databaseConnector condata = new databaseConnector(args);
        AccountManager account = new AccountManager();

        while(continueLoop){
            System.out.println("1. Create an account");
            System.out.println("2. Log into account");
            System.out.println("0. Exit");

            if(in.hasNextInt()){
                choice = in.nextInt();
            }
            else{
                System.out.println("Introduzca una opcion valida");
            }
            switch (choice){
                case 1: account.createAccount(condata); break;
                case 2: continueLoop = account.logIn(condata); break;
                case 0: continueLoop = false; break;
                default:
            }
        }
    }
}

class AccountManager {

    public AccountManager() {

    }

    void createAccount(databaseConnector condata) {
        Card card = new Card();
        System.out.println("Your card has been created");
        System.out.println(card.getCardNumber());
        System.out.println("Your card PIN:");
        System.out.println(card.getPinNumber());
        condata.insertCard(card.getCardNumber(),
                String.valueOf(card.getPinNumber()),
                card.getBalance());
    }

    boolean logIn(databaseConnector condata) {
        Card card;
        Scanner in = new Scanner(System.in);
        boolean isMenu = true;

        System.out.println("Enter your card number:");
        String cardNumber = in.nextLine();
        System.out.println("Enter your PIN:");
        int pinNumber = in.nextInt();

        if (cardNumber != null && cardNumber.length() >= 16 && pinNumber > 999 && pinNumber < 10000) {
            card = searchCardNumber(cardNumber, pinNumber, condata);

            if (card != null) {
                return accountMenu(card, condata);
            } else {
                System.out.println("Wrong card number or PIN!");
            }

        } else System.out.println("Wrong card number or PIN!");
        return isMenu;
    }

    private Card searchCardNumber(String cardNumber, int pinNumber, databaseConnector condata) {
        return condata.searchCard(cardNumber, String.valueOf(pinNumber));
    }

    public boolean accountMenu(Card card, databaseConnector condata) {
        Scanner in = new Scanner(System.in);
        int choice = 0;
        System.out.println("You have successfully logged in!\n");

        do {

            System.out.println("1. Balance");
            System.out.println("2. Add income");
            System.out.println("3. Do transfer");
            System.out.println("4. Close account");
            System.out.println("5. Log out");
            System.out.println("0. Exit");

            if (in.hasNextInt()) {
                choice = in.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Balance: " + card.getBalance());
                        break;
                    case 2:
                        updateCardBalance(card, condata);
                        break;
                    case 3:
                        transferBalanceToCard(card, condata);
                        break;
                    case 4:
                        closeAccount(condata,card);
                        break;
                    case 5:
                        return true;
                    case 0:
                        return false;
                    default:
                }
            } else {
                System.out.println("Introduzca una opcion valida");
            }

        } while (true);
    }

    private void updateCardBalance(Card card, databaseConnector condata) {
        System.out.println("Enter income:");
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int income = in.nextInt();
            card.setBalance(card.getBalance() + income);
            condata.updateCardBalance(card.getBalance(), card.getCardNumber());
        } else {
            System.out.println("introduce a valid number!");
        }

    }
    private void transferBalanceToCard(Card card, databaseConnector condata) {
        String cardNumber="";
        Boolean cardIsValid = true;
        Card toTransfer;

        System.out.println("Transfer\n" + "Enter card number:");

        Scanner in = new Scanner(System.in);

        if (in.hasNextLine()) {
            cardNumber = in.nextLine();

            if(cardNumber.equals(card.getCardNumber()))
            {
                System.out.println("You can't transfer money to the same account!");
                cardIsValid = false;
            } else{
                if(!card.isValidCardNumber(cardNumber)) {
                    System.out.println("Probably you made a mistake in the card number. Please try again!");
                    cardIsValid = false;}
                else {
                        toTransfer = condata.searchCardExist(cardNumber);

                        if(toTransfer==null){
                            cardIsValid = false;
                            System.out.println("Such a card does not exist.");
                        }else {
                            if(cardIsValid){
                                System.out.println("Enter how much money you want to transfer:");
                                int amount = in.nextInt();
                                if(amount > card.getBalance()){
                                    System.out.println("Not enough money!");
                                }else{
                                    condata.updateCardBalance(card.getBalance()-amount, card.getCardNumber());
                                    condata.updateCardBalance(toTransfer.getBalance()+amount, toTransfer.getCardNumber());
                                }
                            }
                        }

                    }

            }
        }
        else {
            System.out.println("Introduzca un numero de cuenta valida!");
        }



    }
    private void closeAccount(databaseConnector condata, Card card) {
        condata.removeAccount(card.getCardNumber());
        System.out.println("The account has been closed!");
    }
}