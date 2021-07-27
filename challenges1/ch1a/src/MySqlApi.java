import common.Customer;
import common.DBapi;
import common.IDBApi;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MySqlApi extends DBapi implements IDBApi {


    public MySqlApi() {
    }

    @Override
    public String tableSyntax() {
        return "CREATE TABLE Customer(Id int NOT NULL AUTO_INCREMENT, Firstname varchar(255) NOT NULL, Lastname varchar(255) NOT NULL, PRIMARY KEY (Id));";
    }

    @Override
    public void connect(String dbName, String dbUser, String dbPw){
        makeDBConnection(String.format("jdbc:mysql://127.0.0.1:3306/%s", dbName), dbUser, dbPw);
        checkDbConnection();

        createCustomerTable(tableSyntax());
    }

    @Override
    public void saveCustomer(String firstname, String lastname) {
        executeUpdate(String.format("INSERT INTO Customer(Firstname, Lastname) VALUES('%s', '%s');", firstname, lastname));
    }

    @Override
    public Customer getCustomer(String firstname, String lastname) {
        try {
            ResultSet resultSet = executeQuery(String.format("SELECT * FROM Customer c WHERE c.Firstname LIKE '%s' AND c.Lastname LIKE '%s';", firstname, lastname));
            if (resultSet.next()) {
                return new Customer(resultSet.getString("Firstname"), resultSet.getString("Lastname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
