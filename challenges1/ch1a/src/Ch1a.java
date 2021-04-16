import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ch1a {

    public static void main(String[] args) {

        String dbName = "ch1_helloworld";
        String dbUser = "root";
        String dbPw   = "admin";

        String firstname;
        String lastname;

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Please input your firstname: ");
            firstname = input.nextLine();
        } while (firstname.equals(""));


        do {
            System.out.println("Please input your lastname: ");
            lastname = input.nextLine();
        } while (lastname.equals(""));

        try {
            Connection mysql = DriverManager.getConnection(String.format("jdbc:mysql://127.0.0.1:3306/%s", dbName), dbUser, dbPw);
            Statement stmt = mysql.createStatement();

            String insertQuery = String.format("INSERT INTO Person(Firstname, Lastname) VALUES('%s', '%s');", firstname, lastname);

            stmt.executeUpdate(insertQuery);

            String selectQuery = String.format("SELECT * FROM Person p WHERE p.Firstname LIKE '%s' AND p.Lastname LIKE '%s';", firstname, lastname);

            Person person = new Person(stmt.executeQuery(selectQuery));
            System.out.println(String.format("Saved in DB --> %s %s", person.getFirstname(), person.getLastname()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
