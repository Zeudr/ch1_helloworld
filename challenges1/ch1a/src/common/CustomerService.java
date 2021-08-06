package common;


import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerService {

    private final IDBApi idbApi;


    public CustomerService(IDBApi idbApi) {
        this.idbApi = idbApi;
    }

    public void process() {
        try {
            DBConnection dbConnection = PresentationLayer.getConnectionInformation();
            idbApi.connect(dbConnection);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        dropCustomerTable();
        idbApi.createTable();

        Customer customer = PresentationLayer.getPersonInformation();
        saveCustomer(customer.getFirstname(), customer.getLastname());

        Customer customerFromDB = getCustomer(customer.getFirstname(), customer.getLastname());
        PresentationLayer.printPersonInformation(customerFromDB);
    }

    public void saveCustomer(String firstname, String lastname) {
        idbApi.executeUpdate(String.format("INSERT INTO Customer(Firstname, Lastname) VALUES('%s', '%s');", firstname, lastname));
    }

    public Customer getCustomer(String firstname, String lastname) {
        try {
            ResultSet resultSet = idbApi.executeQuery(String.format("SELECT * FROM Customer c WHERE c.Firstname LIKE '%s' AND c.Lastname LIKE '%s';", firstname, lastname));
            if (resultSet.next()) {
                return new Customer(resultSet.getString("Firstname"), resultSet.getString("Lastname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    private void dropCustomerTable() {
        idbApi.dropTableIfExists("Customer");
    }

}
