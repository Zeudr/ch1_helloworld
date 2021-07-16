import common.Customer;
import common.CustomerRepository;
import common.DBapi;
import common.IDBApi;

import java.sql.SQLException;


public class HSqlApi extends DBapi implements IDBApi {

    private final CustomerRepository customerRepository;


    public HSqlApi() {
        this.customerRepository = new CustomerRepository();
    }

    @Override
    public String tableSyntax() {
        return "CREATE TABLE Customer(Id int NOT NULL IDENTITY, Firstname varchar(255) NOT NULL, Lastname varchar(255) NOT NULL, PRIMARY KEY (Id));";
    }

    @Override
    public void connect(String dbName, String dbUser, String dbPw) {
        makeDBConnection(String.format("jdbc:hsqldb:mem:%s", dbName), dbUser, dbPw);
        checkDbConnection();

        prepDB(tableSyntax());
    }

    @Override
    public void saveCustomer(String firstname, String lastname) {
        save(customerRepository.saveCustomer(firstname, lastname));
    }

    @Override
    public void getCustomer(String firstname, String lastname) {
        try {
            Customer customer = createCustomer(executeQuery(customerRepository.getCustomer(firstname, lastname)));
            System.out.println(String.format("Saved in DB --> %s %s", customer.getFirstname(), customer.getLastname()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
