import common.DBapi;
import common.IDBApi;


public class MySqlApi extends DBapi implements IDBApi { // TODO: implements IDBApi should be in parentclass


    public MySqlApi() { // TODO: remove
    }

    @Override
    public void createCustomerTable() {
        execute("CREATE TABLE Customer(Id int NOT NULL AUTO_INCREMENT, Firstname varchar(255) NOT NULL, Lastname varchar(255) NOT NULL, PRIMARY KEY (Id));"); // TODO: no dependency to customer, move to mysqlcustomer service
    }

    @Override
    public void connect(String dbName, String dbUser, String dbPassword) { // TODO: duplicated code
        makeDBConnection(String.format("jdbc:mysql://127.0.0.1:3306/%s", dbName), dbUser, dbPassword);
    }

}
