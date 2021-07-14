package common;

public class Customer {

    private String firstname;
    private String lastname;

    public Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }

}