package common;

import java.sql.ResultSet;


public interface IDBApi {

    void connect(String dbName, String dbUser, String dbPassword);

    void checkDbConnection();

    void createCustomerTable();

    void dropTableIfExists(String tableName);

    void executeUpdate(String query);

    ResultSet executeQuery(String query);

}
