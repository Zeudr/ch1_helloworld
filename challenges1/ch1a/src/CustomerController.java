public class CustomerController {

    String dbName;
    String dbUser;
    String dbPw;

    String firstname;
    String lastname;

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;


    public CustomerController() {
        this.customerService = new CustomerService();
        this.customerRepository = new CustomerRepository();
    }

    public void process(String url) {
        getConnectionInformation();

        customerRepository.makeDBConnection(String.format(url, dbName), dbUser, dbPw);
        customerRepository.checkDbConnection();

        String createTable = "CREATE TABLE Customer(Id int NOT NULL AUTO_INCREMENT, Firstname varchar(255) NOT NULL, Lastname varchar(255) NOT NULL, PRIMARY KEY (Id));";
        customerRepository.prepDB(createTable);

        getPersonInformation();
        customerRepository.saveCustomer(firstname, lastname);

        customerRepository.getCustomer(firstname, lastname);
    }

    private void getConnectionInformation() {
        dbName = customerService.getUserValue("Please input your DB-Name: ");
        dbUser = customerService.getUserValue("Please input your DB-User: ");
        dbPw = customerService.getUserValue("Please input your DB-Password: ");
    }

    private void getPersonInformation() {
        firstname = customerService.getUserValue("Please input your firstname: ");
        lastname = customerService.getUserValue("Please input your lastname: ");
    }

}
