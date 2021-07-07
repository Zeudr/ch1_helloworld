public class Main {

    public static void main(String[] args) {
        CustomerController customerController = new CustomerController();
        customerController.url = "jdbc:hsqldb:file:%s";
        customerController.process();
    }

}
