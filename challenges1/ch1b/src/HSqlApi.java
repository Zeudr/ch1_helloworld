import common.DBConnection;
import common.DBapi;

public class HSqlApi extends DBapi {

    @Override
    public void createTable() {
        execute("CREATE TABLE Customer(Id int NOT NULL IDENTITY, Firstname varchar(255) NOT NULL, Lastname varchar(255) NOT NULL, PRIMARY KEY (Id));");
    }

    @Override
    public void connect(DBConnection dbConnection) throws Exception {
        makeDBConnection(dbConnection);
    }

    public void showDatabase() {
        // for debugging: (bp must not suspend all threads)
        // System.setProperty("java.awt.headless", "false");
        // DatabaseManagerSwing.main(new String[]{
        //         "--url", "jdbc:hsqldb:mem:carvoInMem", "--noexit"
        // });
    }

}
