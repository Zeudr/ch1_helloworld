package common;

public class DBConnection {

    private String dbName;
    private String dbUser;
    private String dbPw;


    public DBConnection(String dbName, String dbUser, String dbPw) {
        this.dbName = dbName;
        this.dbUser = dbUser;
        this.dbPw = dbPw;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPw() {
        return dbPw;
    }

    public void setDbPw(String dbPw) {
        this.dbPw = dbPw;
    }

}
