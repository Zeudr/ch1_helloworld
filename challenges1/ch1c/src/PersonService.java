import java.sql.Statement;
import java.util.Scanner;

public class PersonService extends BaseService {

    public void process() {
        Statement statement;
        if (chooseDb()) {
            statement = makeMYSQLDBConnection();
            checkDbConnection(statement);
            prepMYSQLDB(statement);
        } else {
            statement = makeHSQLDBConnection();
            checkDbConnection(statement);
            prepHSQLDB(statement);
        }

        savePerson(statement);
    }

    private boolean chooseDb() {
        Scanner input = new Scanner(System.in);
        String answer;
        do {
            System.out.println("Change DB(y/n)?");
            System.out.println("MYSQLDB --> y");
            System.out.println("HSQLDB --> n");
            answer = input.nextLine();
        } while (!(answer.equals("y") || answer.equals("n")));

        return answer.equals("y");
    }

}
