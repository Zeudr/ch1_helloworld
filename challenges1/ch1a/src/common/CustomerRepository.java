package common;


public class CustomerRepository {

    public String saveCustomer(String firstname, String lastname) {
        return String.format("INSERT INTO Customer(Firstname, Lastname) VALUES('%s', '%s');", firstname, lastname);
    }

    public String getCustomer(String firstname, String lastname) {
        return String.format("SELECT * FROM Customer c WHERE c.Firstname LIKE '%s' AND c.Lastname LIKE '%s';", firstname, lastname);
    }

}
