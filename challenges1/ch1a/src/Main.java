import common.CustomerService;


public class Main {

    public static void main(String[] args) {
        CustomerService customerService = new CustomerService(new MySqlApi());
        customerService.process();
    }

}
