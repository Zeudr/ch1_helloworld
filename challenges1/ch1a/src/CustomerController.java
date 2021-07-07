import common.AbstractController;


public class CustomerController extends AbstractController {

    @Override
    public String getCreateTableSyntax() {
        return "CREATE TABLE Customer(Id int NOT NULL AUTO_INCREMENT, Firstname varchar(255) NOT NULL, Lastname varchar(255) NOT NULL, PRIMARY KEY (Id));";
    }

}
