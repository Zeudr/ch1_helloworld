import java.sql.Statement;

public class PersonService extends BaseService {

    public PersonService() {
    }

    public void process() {
        Statement statement = makeMYSQLDBConnection();
        checkDbConnection(statement);
        prepMYSQLDB(statement);
        savePerson(statement);
    }

}
