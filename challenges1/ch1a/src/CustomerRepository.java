import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepository extends AbstractDB {

    public void saveCustomer(String firstname, String lastname) {
        save(String.format("INSERT INTO Customer(Firstname, Lastname) VALUES('%s', '%s');", firstname, lastname));
    }

    public void getCustomer(String firstname, String lastname) {
        String query = String.format("SELECT * FROM Customer c WHERE c.Firstname LIKE '%s' AND c.Lastname LIKE '%s';", firstname, lastname);

        try {
            Customer customer = createCustomer(statement.executeQuery(query));
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
