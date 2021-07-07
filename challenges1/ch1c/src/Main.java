import common.CustomerService;


public class Main {

    public static void main(String[] args) {
        CustomerController customerController = new CustomerController();
        customerController.url = chooseDb();
        customerController.process();
    }

    protected static String chooseDb() {
        CustomerService customerService = new CustomerService();
        String answer = customerService.getUserValue("Change DB(y/n)? (MYSQLDB --> y | HSQLDB --> n)");

        String url;
        if (answer.equals("y")) {
            url = "jdbc:mysql://127.0.0.1:3306/%s";
        } else {
            url = "jdbc:hsqldb:file:%s";
        }

        return url;
    }

}
