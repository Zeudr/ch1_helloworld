package common;


public class CustomerService {

    private final IDBApi mySqlApi;

    public CustomerService(IDBApi idbApi) {
        this.mySqlApi = idbApi;
    }

    public void process() {
        DBConnection dbConnection = PresentationLayer.getConnectionInformation();
        mySqlApi.connect(dbConnection.getDbName(), dbConnection.getDbUser(), dbConnection.getDbPw());

        Customer customer = PresentationLayer.getPersonInformation();
        mySqlApi.saveCustomer(customer.getFirstname(), customer.getLastname());

        Customer customerFromDB = mySqlApi.getCustomer(customer.getFirstname(), customer.getLastname());
        PresentationLayer.printPersonInformation(customerFromDB);
    }

}
