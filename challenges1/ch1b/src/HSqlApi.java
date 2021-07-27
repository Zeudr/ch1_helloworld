import common.Customer;
import common.DBapi;
import common.IDBApi;

import java.sql.ResultSet;
import java.sql.SQLException;


public class HSqlApi extends DBapi implements IDBApi {


    public HSqlApi() {
    }

    @Override
    public String tableSyntax() {
        return "CREATE TABLE Customer(Id int NOT NULL IDENTITY, Firstname varchar(255) NOT NULL, Lastname varchar(255) NOT NULL, PRIMARY KEY (Id));";
    }

    @Override
    public void connect(String dbName, String dbUser, String dbPw) {
        makeDBConnection(String.format("jdbc:hsqldb:mem:%s", dbName), dbUser, dbPw);
        checkDbConnection();

        createCustomerTable(tableSyntax());
    }

    @Override
    public void saveCustomer(String firstname, String lastname) {
        executeUpdate(String.format("INSERT INTO Customer(Firstname, Lastname) VALUES('%s', '%s');", firstname, lastname));
    }

    @Override
    public Customer getCustomer(String firstname, String lastname){
        try {
            ResultSet res = executeQuery(String.format("SELECT * FROM Customer c WHERE c.Firstname LIKE '%s' AND c.Lastname LIKE '%s';", firstname, lastname));
            return new Customer(res.getString("Firstname"), res.getString("Lastname"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void showDatabase() {
        // for debugging: (bp must not suspend all threads)
        // System.setProperty("java.awt.headless", "false");
        // DatabaseManagerSwing.main(new String[]{
        //         "--url", "jdbc:hsqldb:mem:carvoInMem", "--noexit"
        // });
    }

}
