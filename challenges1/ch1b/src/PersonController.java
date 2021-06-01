import java.sql.Statement;

public class PersonController {

    String dbName;
    String dbUser;
    String dbPw;

    String firstname;
    String lastname;

    private final PersonService personService;
    private final PersonRepository personRepository;

    public PersonController() {
        this.personService = new PersonService();
        this.personRepository = new PersonRepository();
    }

    public void process() {
        getConnectionInformation();

        Statement statement = personRepository.makeDBConnection(String.format("jdbc:hsqldb:file:%s", dbName), dbUser, dbPw);
        personRepository.checkDbConnection(statement);
        personRepository.prepDB(statement, false);

        getPersonInformation();
        personRepository.savePerson(statement, firstname, lastname);
        personRepository.getPerson(statement, firstname, lastname);
    }

    private void getConnectionInformation() {
        dbName = personService.getUserValue("Please input your DB-Name: ");
        dbUser = personService.getUserValue("Please input your DB-User: ");
        dbPw = personService.getUserValue("Please input your DB-Password: ");
    }

    private void getPersonInformation() {
        firstname = personService.getUserValue("Please input your firstname: ");
        lastname = personService.getUserValue("Please input your lastname: ");
    }

}
