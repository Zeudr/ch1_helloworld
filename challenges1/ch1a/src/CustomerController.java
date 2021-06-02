import java.sql.Statement;

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

    public void process(boolean isMysqlDB, String url) {
        getConnectionInformation();

        Statement statement = customerRepository.makeDBConnection(String.format(url, dbName), dbUser, dbPw);
        customerRepository.checkDbConnection(statement);
        customerRepository.prepDB(statement, isMysqlDB);

        getPersonInformation();
        customerRepository.savePerson(statement, firstname, lastname);
        customerRepository.getPerson(statement, firstname, lastname);
    }

    public void process() {
        String url = chooseDb();

        getConnectionInformation();

        Statement statement = customerRepository.makeDBConnection(String.format(url, dbName), dbUser, dbPw);
        customerRepository.checkDbConnection(statement);
        customerRepository.prepDB(statement, url.equals("jdbc:mysql://127.0.0.1:3306/%s"));

        getPersonInformation();
        customerRepository.savePerson(statement, firstname, lastname);
        customerRepository.getPerson(statement, firstname, lastname);
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

    protected String chooseDb() {
        String answer = customerService.getUserValue("Change DB(y/n)? (MYSQLDB --> y | HSQLDB --> n)");
        String url;

        if (answer.equals("y")) {
            url = "jdbc:mysql://127.0.0.1:3306/%s";
        } else {
            url = "jdbc:hsqldb:file:%s";
        }

        return url;
    }

}
