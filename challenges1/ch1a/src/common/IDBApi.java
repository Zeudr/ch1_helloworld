package common;

public interface IDBApi {

    void connect(String dbName, String dbUser, String dbPw);

    void saveCustomer(String firstname, String lastname);

    Customer getCustomer(String firstname, String lastname);

}
