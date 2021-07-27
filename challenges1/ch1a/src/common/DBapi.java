package common;

import java.sql.*;


public abstract class DBapi {

    private Connection connection;


    public abstract String tableSyntax();

    public void makeDBConnection(String url, String user, String password) {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void checkDbConnection() {
        if (connection == null) {
            throw new IllegalStateException("Error --> DB-Connection Failed");
        }
    }

    public void createCustomerTable(String query) {
        execute("DROP TABLE IF EXISTS Customer");
        execute(query);
    }

    private void execute(String query) {
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
