package common;

import java.sql.*;

public class DBapi {

    Statement statement;


    public void makeDBConnection(String url, String user, String password) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void checkDbConnection() {
        if (statement == null) {
            throw new IllegalStateException("Error --> DB-Connection Failed");
        }
    }

    public void prepDB(String query) {
        String dropTable = "DROP TABLE IF EXISTS common.Customer";

        execute(dropTable);
        execute(query);
    }

    public void execute(String query) {
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
