package internet_store.view_layer;

import java.util.Scanner;

public class View {

    Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }


    public int getIntFromConsole() {
        final int choice1 = scanner.nextInt();
        scanner.nextLine();                    // skip /n
        return choice1;
    }

    public String getStringFromConsole() {
        return scanner.nextLine();
    }

    public void mainMenu() {
        System.out.println("Login menu: ");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("0. Exit");
    }

    public void greeting() {
        System.out.println("Welcome to our store!. The best clothes for your kids!");
    }


    public void showAdminMenu() {
        System.out.println("Welcome to Admin Page");
        System.out.println("1. Users menu (block/unblock)");
        System.out.println("2. Order menu (confirm/unconfirm order)"); //TODO ID ==3 - must be error
        System.out.println("3. Products menu (edit / add)");
        System.out.println("4. Log out");
        System.out.println("Please make the choice");

    }

    public void showUserMenu() {
        System.out.println("Welcome to user menu");
        System.out.println("1. Products menu: ");
        System.out.println("2. My orders menu: ");
    }

    public void showProductMenu() {
        System.out.println("Products menu: ");
        System.out.println("a. List of all products: ");
        System.out.println("b. Search for specific product: ");
        System.out.println("c. Order checkout: ");
        System.out.println("d. Return to User Menu: ");
        System.out.println("e. Log Out ");
    }

    public void showGenderMenu() {
        System.out.println("Input Gender");
        System.out.println("1. For boys");
        System.out.println("2. For girls");
    }


}
