import java.sql.Statement;

public class PersonService extends BaseService {

    public void process() {
        Statement statement = makeHSQLDBConnection();
        checkDbConnection(statement);
        prepHSQLDB(statement);
        savePerson(statement);
    }

}
