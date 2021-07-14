package common;

import java.util.Scanner;


public class PresentationLayer {

    private String dbName;
    private String dbUser;
    private String dbPw;

    private String firstname;
    private String lastname;


    public void getConnectionInformation() {
        dbName = getUserValue("Please input your DB-Name: ");
        dbUser = getUserValue("Please input your DB-User: ");
        dbPw = getUserValue("Please input your DB-Password: ");
    }

    public void getPersonInformation() {
        firstname = getUserValue("Please input your firstname: ");
        lastname = getUserValue("Please input your lastname: ");
    }

    private String getUserValue(String text) {
        Scanner input = new Scanner(System.in);
        String s;

        do {
            System.out.println(text);
            s = input.nextLine();
        } while (s.equals(""));

        return s;
    }

    public String getDbName() {
        return dbName;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPw() {
        return dbPw;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

}
