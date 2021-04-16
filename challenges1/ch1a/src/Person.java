import java.sql.ResultSet;
import java.sql.SQLException;

public class Person {

    private String firstname;
    private String lastname;

    public Person(ResultSet resultSet) throws SQLException {
        if(resultSet.next()) {
            firstname = resultSet.getString("Firstname");
            lastname = resultSet.getString("Lastname");
        }
    }

    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }

}
