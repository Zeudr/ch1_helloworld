package common;


public class CustomerService {

    private final IDBApi mySqlApi;
    private final PresentationLayer presentationLayer;

    public CustomerService(IDBApi idbApi) {
        this.mySqlApi = idbApi;
        this.presentationLayer = new PresentationLayer();
    }

    public void process() {
        DBConnection dbConnection = PresentationLayer.getConnectionInformation();
        mySqlApi.connect(dbConnection.getDbName(), dbConnection.getDbName(), dbConnection.getDbPw());

        Customer customer = PresentationLayer.getPersonInformation();
        mySqlApi.saveCustomer(customer.getFirstname(), customer.getLastname());

        mySqlApi.getCustomer(customer.getFirstname(), customer.getLastname());
    }

}
