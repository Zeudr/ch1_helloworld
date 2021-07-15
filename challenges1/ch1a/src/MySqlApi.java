import common.Customer;
import common.CustomerRepository;
import common.DBapi;
import common.IDBApi;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MySqlApi extends DBapi implements IDBApi {

    private final CustomerRepository customerRepository;


    @Override
    public String tableSyntax() {
        return "CREATE TABLE Customer(Id int NOT NULL AUTO_INCREMENT, Firstname varchar(255) NOT NULL, Lastname varchar(255) NOT NULL, PRIMARY KEY (Id));";
    }

    public MySqlApi() {
        this.customerRepository = new CustomerRepository();
    }

    @Override
    public void connect(String dbName, String dbUser, String dbPw){
        makeDBConnection(String.format("jdbc:mysql://127.0.0.1:3306/%s", dbName), dbUser, dbPw);
        checkDbConnection();

        prepDB(tableSyntax());
    }

    @Override
    public void saveCustomer(String firstname, String lastname) {
        save(customerRepository.saveCustomer(firstname, lastname));
    }

    @Override
    public void getCustomer(String firstname, String lastname){
        try {
            Customer customer = createCustomer(executeQuery(customerRepository.getCustomer(firstname, lastname)));
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
