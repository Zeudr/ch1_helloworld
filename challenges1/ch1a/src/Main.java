public class Main {

    public static void main(String[] args) {
        CustomerController customerController = new CustomerController();
        customerController.process(true, "jdbc:mysql://127.0.0.1:3306/%s");
    }

}
