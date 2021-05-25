import java.sql.Statement;

public class PersonService extends BaseService {

    public PersonService() {
    }

    public void process() {
        Statement statement = makeHSQLDBConnection();
        checkDbConnection(statement);
        prepHSQLDB(statement);
        savePerson(statement);
    }

}
