import common.DBConnection;
import common.DBapi;


public class MySqlApi extends DBapi {

    @Override
    public void createTable() {
        execute("CREATE TABLE Customer(Id int NOT NULL AUTO_INCREMENT, Firstname varchar(255) NOT NULL, Lastname varchar(255) NOT NULL, PRIMARY KEY (Id));"); // TODO: no dependency to customer, move to mysqlcustomer service
    }

    @Override
    public void connect(DBConnection dbConnection) throws Exception {
        makeDBConnection(dbConnection);
    }

}
