import common.AbstractController;


public class CustomerController extends AbstractController {

    @Override
    public String getCreateTableSyntax() {
        if (url.equals("jdbc:mysql://127.0.0.1:3306/%s")) {
            return "CREATE TABLE Customer(Id int NOT NULL AUTO_INCREMENT, Firstname varchar(255) NOT NULL, Lastname varchar(255) NOT NULL, PRIMARY KEY (Id));";
        } else {
            return "CREATE TABLE Customer(Id int NOT NULL IDENTITY, Firstname varchar(255) NOT NULL, Lastname varchar(255) NOT NULL, PRIMARY KEY (Id));";
        }
    }

}
