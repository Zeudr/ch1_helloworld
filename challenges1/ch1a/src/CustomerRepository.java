import java.io.IOException;
import java.sql.*;

public class CustomerRepository {

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

        String dropTable = "DROP TABLE IF EXISTS Customer";
        String createTable = String.format("CREATE TABLE Customer(Id int NOT NULL %s, Firstname varchar(255) NOT NULL, Lastname varchar(255) NOT NULL, PRIMARY KEY (Id));", keyWord);

        try {
            statement.execute(dropTable);
            statement.execute(createTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void savePerson(Statement statement, String firstname, String lastname) {
        String insertQuery = String.format("INSERT INTO Customer(Firstname, Lastname) VALUES('%s', '%s');", firstname, lastname);

        try {
            statement.executeUpdate(insertQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void getPerson(Statement statement, String firstname, String lastname) {
        String selectQuery = String.format("SELECT * FROM Customer c WHERE c.Firstname LIKE '%s' AND c.Lastname LIKE '%s';", firstname, lastname);

        try {
            Customer customer = createCustomer(statement.executeQuery(selectQuery));
            System.out.println(String.format("Saved in DB --> %s %s", customer.getFirstname(), customer.getLastname()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Customer createCustomer(ResultSet resultSet) throws SQLException {
        String firstname = "";
        String lastname = "";

        if(resultSet.next()) {
            firstname = resultSet.getString("Firstname");
            lastname = resultSet.getString("Lastname");
        }

        return new Customer(firstname, lastname);
    }

}
