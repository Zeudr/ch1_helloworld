import common.DBapi;
import common.IDBApi;


public class HSqlApi extends DBapi implements IDBApi {


    public HSqlApi() { // TODO: remove
    }

    @Override
    public void createCustomerTable() {
        execute("CREATE TABLE Customer(Id int NOT NULL IDENTITY, Firstname varchar(255) NOT NULL, Lastname varchar(255) NOT NULL, PRIMARY KEY (Id));");
    }

    @Override
    public void connect(String dbName, String dbUser, String dbPassword) {
        makeDBConnection(String.format("jdbc:hsqldb:mem:%s", dbName), dbUser, dbPassword);
    }

    public void showDatabase() {
        // for debugging: (bp must not suspend all threads)
        // System.setProperty("java.awt.headless", "false");
        // DatabaseManagerSwing.main(new String[]{
        //         "--url", "jdbc:hsqldb:mem:carvoInMem", "--noexit"
        // });
    }

}
