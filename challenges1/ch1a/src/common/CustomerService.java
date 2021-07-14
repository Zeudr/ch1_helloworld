package common;


public class CustomerService {

    private final MySqlConnection mySqlConnection;
    private final PresentationLayer presentationLayer;

    public CustomerService() {
        this.mySqlConnection = new MySqlConnection();
        this.presentationLayer = new PresentationLayer();
    }

    public void process() {
        presentationLayer.getConnectionInformation();
        mySqlConnection.connect(presentationLayer.getDbName(), presentationLayer.getDbUser(), presentationLayer.getDbPw());

        presentationLayer.getPersonInformation();
        mySqlConnection.saveCustomer(presentationLayer.getFirstname(), presentationLayer.getLastname());

        mySqlConnection.getCustomer(presentationLayer.getFirstname(), presentationLayer.getLastname());
    }

}
