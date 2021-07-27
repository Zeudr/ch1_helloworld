package common;

public class DBConnection {

    private final String dbName;
    private final String dbUser;
    private final String dbPw;


    public DBConnection(String dbName, String dbUser, String dbPw) {
        this.dbName = dbName;
        this.dbUser = dbUser;
        this.dbPw = dbPw;
    }

    public String getDbName() {
        return dbName;
    }
    public String getDbUser() {
        return dbUser;
    }
    public String getDbPw() {
        return dbPw;
    }

}
