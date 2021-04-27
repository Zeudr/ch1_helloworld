import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PersonService {

    public PersonService() {
    }

    public void process() {
        Statement statement = makeDbConnection();
        if (statement == null) {
            throw new IllegalStateException("Error --> DB-Connection Failed");
        }
        prepDb(statement);
        savePerson(statement);
    }

    private Statement makeDbConnection() {
        String dbName;
        String dbUser;
        String dbPw;

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Please input your DB-Name: ");
            dbName = input.nextLine();
        } while (dbName.equals(""));

        do {
            System.out.println("Please input your DB-User: ");
            dbUser = input.nextLine();
        } while (dbUser.equals(""));

        do {
            System.out.println("Please input your DB-Password: ");
            dbPw = input.nextLine();
        } while (dbPw.equals(""));

        try {
            Connection mysql = DriverManager.getConnection(String.format("jdbc:mysql://127.0.0.1:3306/%s", dbName), dbUser, dbPw);
            return mysql.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void prepDb(Statement statement) {
        String dropTable = "DROP TABLE IF EXISTS Person";
        String createTable = "CREATE TABLE `Person` (`Id` int(11) NOT NULL AUTO_INCREMENT, `Firstname` varchar(255) NOT NULL, `Lastname` varchar(255) NOT NULL, PRIMARY KEY (`Id`));";

        try {
            statement.execute(dropTable);
            statement.execute(createTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void savePerson(Statement statement) {
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

        String insertQuery = String.format("INSERT INTO Person(Firstname, Lastname) VALUES('%s', '%s');", firstname, lastname);
        String selectQuery = String.format("SELECT * FROM Person p WHERE p.Firstname LIKE '%s' AND p.Lastname LIKE '%s';", firstname, lastname);

        try {
            statement.executeUpdate(insertQuery);

            Person person = new Person(statement.executeQuery(selectQuery));
            System.out.println(String.format("Saved in DB --> %s %s", person.getFirstname(), person.getLastname()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
