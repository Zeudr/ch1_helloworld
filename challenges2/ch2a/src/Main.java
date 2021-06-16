public class Main {

    public static void main(String[] args) {
        CustomerController customerController = new CustomerController();
        customerController.process(false, "jdbc:hsqldb:file:%s");
    }

}
