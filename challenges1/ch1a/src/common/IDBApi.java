package common;

import java.sql.ResultSet;


public interface IDBApi {

    void connect(DBConnection dbConnection) throws Exception;

    void checkDbConnection();

    void createTable();

    void dropTableIfExists(String tableName);

    void executeUpdate(String query);

    ResultSet executeQuery(String query);

}
