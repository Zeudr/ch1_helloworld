import common.CustomerService;
import common.PresentationLayer;


public class Main {

    public static void main(String[] args) {
        String answer = PresentationLayer.getUserValue("Change DB(y/n)? (MYSQLDB --> y | HSQLDB --> n)");

        CustomerService customerService;
        if (answer.equals("y")) {
            customerService = new CustomerService(new MySqlApi());
        } else {
            customerService = new CustomerService(new HSqlApi());
        }
        customerService.process();
    }

}
