package common;

import java.util.Scanner;


public class PresentationLayer {

    public static DBConnection getConnectionInformation() {
        String dbName = getUserValue("Please input your DB-Name: ");
        String dbUser = getUserValue("Please input your DB-User: ");
        String dbPw = getUserValue("Please input your DB-Password: ");

        return new DBConnection(dbName, dbUser, dbPw);
    }

    public static Customer getPersonInformation() {
        String firstname = getUserValue("Please input your firstname: ");
        String lastname = getUserValue("Please input your lastname: ");

        return new Customer(firstname, lastname);
    }

    public static void printPersonInformation(Customer customer) {
        System.out.println(String.format("Saved in DB --> %s %s", customer.getFirstname(), customer.getLastname()));
    }

    public static String getUserValue(String text) {
        Scanner input = new Scanner(System.in);
        String s;

        do {
            System.out.println(text);
            s = input.nextLine();
        } while (s.equals(""));

        return s;
    }

}
