import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {

    private String firstname;
    private String lastname;

    public Customer(ResultSet resultSet) throws SQLException {
        if(resultSet.next()) {
            firstname = resultSet.getString("Firstname");
            lastname = resultSet.getString("Lastname");
        }
    }

    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }

}
