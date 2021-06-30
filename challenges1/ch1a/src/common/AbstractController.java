package common;

public abstract class AbstractController {

    private String dbName;
    private String dbUser;
    private String dbPw;

    private String firstname;
    private String lastname;

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    public AbstractController() {
        this.customerService = new CustomerService();
        this.customerRepository = new CustomerRepository();
    }

    public void process(String url) {
        getConnectionInformation();

        DBapi api = new DBapi();

        api.makeDBConnection(String.format(url, dbName), dbUser, dbPw);
        api.checkDbConnection();

        api.prepDB(getCreateTableSyntax());

        getPersonInformation();
        customerRepository.saveCustomer(firstname, lastname);

        customerRepository.getCustomer(firstname, lastname);
    }

    public abstract String getCreateTableSyntax();

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
