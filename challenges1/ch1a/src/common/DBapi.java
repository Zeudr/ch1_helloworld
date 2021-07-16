package common;

import java.sql.*;

public abstract class DBapi {

    public Statement statement;


    public abstract String tableSyntax();

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
        String dropTable = "DROP TABLE IF EXISTS Customer";

        execute(dropTable);
        execute(query);
    }

    private void execute(String query) {
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
          return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected Customer createCustomer(ResultSet resultSet) throws SQLException {
        String firstname = "";
        String lastname = "";

        if(resultSet.next()) {
            firstname = resultSet.getString("Firstname");
            lastname = resultSet.getString("Lastname");
        }

        return new Customer(firstname, lastname);
    }

    public void showDatabase() {
        // for debugging: (bp must not suspend all threads)
        // System.setProperty("java.awt.headless", "false");
        // DatabaseManagerSwing.main(new String[]{
        //         "--url", "jdbc:hsqldb:mem:carvoInMem", "--noexit"
        // });
    }

}
