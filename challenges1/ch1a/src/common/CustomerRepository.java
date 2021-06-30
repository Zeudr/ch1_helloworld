package common;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepository {

    DBapi api = new DBapi();

    public void saveCustomer(String firstname, String lastname) {
        api.save(String.format("INSERT INTO common.Customer(Firstname, Lastname) VALUES('%s', '%s');", firstname, lastname));
    }

    public void getCustomer(String firstname, String lastname) {
        String query = String.format("SELECT * FROM common.Customer c WHERE c.Firstname LIKE '%s' AND c.Lastname LIKE '%s';", firstname, lastname);

        try {
            Customer customer = createCustomer(api.statement.executeQuery(query));
            System.out.println(String.format("Saved in DB --> %s %s", customer.getFirstname(), customer.getLastname()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Customer createCustomer(ResultSet resultSet) throws SQLException {
        String firstname = "";
        String lastname = "";

        if(resultSet.next()) {
            firstname = resultSet.getString("Firstname");
            lastname = resultSet.getString("Lastname");
        }

        return new Customer(firstname, lastname);
    }

}
