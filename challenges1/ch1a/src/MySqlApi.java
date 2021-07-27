import common.DBapi;
import common.IDBApi;


public class MySqlApi extends DBapi implements IDBApi {


    public MySqlApi() {
    }

    @Override
    public void createCustomerTable() {
        execute("CREATE TABLE Customer(Id int NOT NULL AUTO_INCREMENT, Firstname varchar(255) NOT NULL, Lastname varchar(255) NOT NULL, PRIMARY KEY (Id));");
    }

    @Override
    public void connect(String dbName, String dbUser, String dbPassword) {
        makeDBConnection(String.format("jdbc:mysql://127.0.0.1:3306/%s", dbName), dbUser, dbPassword);
    }

}
