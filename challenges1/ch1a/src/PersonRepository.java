import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonRepository {

    protected void checkDbConnection(Statement statement) {
        if (statement == null) {
            throw new IllegalStateException("Error --> DB-Connection Failed");
        }
    }

    protected Statement makeDBConnection(String url, String user, String password) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    protected void prepDB(Statement statement, boolean isMysqlDB) {
        String keyWord;
        if (isMysqlDB) {
            keyWord = "AUTO_INCREMENT";
        } else {
            keyWord = "IDENTITY";
        }

        String dropTable = "DROP TABLE IF EXISTS Person";
        String createTable = String.format("CREATE TABLE Person(Id int NOT NULL IDENTITY, Firstname varchar(255) NOT NULL, Lastname varchar(255) NOT NULL, PRIMARY KEY (Id));", keyWord);

        try {
            statement.execute(dropTable);
            statement.execute(createTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void savePerson(Statement statement, String firstname, String lastname) {
        String insertQuery = String.format("INSERT INTO Person(Firstname, Lastname) VALUES('%s', '%s');", firstname, lastname);

        try {
            statement.executeUpdate(insertQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void getPerson(Statement statement, String firstname, String lastname) {
        String selectQuery = String.format("SELECT * FROM Person p WHERE p.Firstname LIKE '%s' AND p.Lastname LIKE '%s';", firstname, lastname);

        try {
            Person person = new Person(statement.executeQuery(selectQuery));
            System.out.println(String.format("Saved in DB --> %s %s", person.getFirstname(), person.getLastname()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
