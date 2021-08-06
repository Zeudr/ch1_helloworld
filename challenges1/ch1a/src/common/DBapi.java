package common;

import java.sql.*;


public abstract class DBapi implements IDBApi {

    private Connection connection;

    public void makeDBConnection(DBConnection dbConnection) throws Exception {
            connection = DriverManager.getConnection(dbConnection.getDbName(), dbConnection.getDbUser(), dbConnection.getDbPw());
            checkDbConnection();
    }

    public void checkDbConnection() {
        if (connection == null) {
            throw new IllegalStateException("Error --> DB-Connection Failed");
        }
    }

    public void dropTableIfExists(String tableName) {
        execute(String.format("DROP TABLE IF EXISTS %s", tableName));
    }

    public void execute(String query) {
        try {
            connection.createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
          return connection.createStatement().executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String query) {
        try {
            connection.createStatement().executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
