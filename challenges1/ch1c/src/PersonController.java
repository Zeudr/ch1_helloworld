import java.sql.Statement;

public class PersonController {

    String dbName;
    String dbUser;
    String dbPw;

    String firstname;
    String lastname;

    boolean isMysqlDB;
    String url;

    private final PersonService personService;
    private final PersonRepository personRepository;

    public PersonController() {
        this.personService = new PersonService();
        this.personRepository = new PersonRepository();
    }

    public void process() {
        isMysqlDB = chooseDb();
        getConnectionInformation();

        Statement statement = personRepository.makeDBConnection(url, dbUser, dbPw);
        personRepository.checkDbConnection(statement);
        personRepository.prepDB(statement, isMysqlDB);

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

    protected boolean chooseDb() {
        String answer = personService.getUserValue("Change DB(y/n)? (MYSQLDB --> y | HSQLDB --> n)");

        if (answer.equals("y")) {
            url = String.format("jdbc:mysql://127.0.0.1:3306/%s", dbName);
        } else {
            url = String.format("jdbc:hsqldb:file:%s", dbName);
        }

        return answer.equals("y");
    }

}
