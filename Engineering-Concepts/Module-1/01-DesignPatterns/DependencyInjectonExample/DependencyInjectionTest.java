public class DependencyInjectionTest {

    public static void main(String[] args) {

        CustomerRepository repository =
                new CustomerRepository();

        CustomerService service =
                new CustomerService(
                        repository
                );

        service.getCustomer();
    }
}