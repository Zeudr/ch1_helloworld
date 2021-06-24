public class Main {

   private static String url;

    public static void main(String[] args) {
        chooseDb();

        CustomerController customerController = new CustomerController();
        customerController.process(url);
    }

    protected static String chooseDb() {
        CustomerService customerService = new CustomerService();
        String answer = customerService.getUserValue("Change DB(y/n)? (MYSQLDB --> y | HSQLDB --> n)");

        if (answer.equals("y")) {
            url = "jdbc:mysql://127.0.0.1:3306/%s";
        } else {
            url = "jdbc:hsqldb:file:%s";
        }

        return url;
    }

}
