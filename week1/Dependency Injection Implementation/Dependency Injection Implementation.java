// 1. Repository Interface
interface CustomerRepository {
    String findCustomerById(String id);
}

// 2. Concrete Repository Implementation
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String id) {
        // In a real application, this would query a database
        if ("C001".equals(id)) {
            return "John Doe (Premium Customer)";
        } else if ("C002".equals(id)) {
            return "Jane Smith (Standard Customer)";
        }
        return "Customer not found";
    }
}

// 3. Service Class with Dependency Injection
class CustomerService {
    private final CustomerRepository customerRepository;

   
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomerDetails(String customerId) {
        // Business logic can be added here
        return customerRepository.findCustomerById(customerId);
    }
}

// 4. Main class to demonstrate Dependency Injection
public class DependencyInjectionExample {
    public static void main(String[] args) {
      
        CustomerRepository repository = new CustomerRepositoryImpl();
        
       
        CustomerService customerService = new CustomerService(repository);
        
      
        System.out.println("Customer C001: " + customerService.getCustomerDetails("C001"));
        System.out.println("Customer C002: " + customerService.getCustomerDetails("C002"));
        System.out.println("Customer C003: " + customerService.getCustomerDetails("C003"));
        
       
        System.out.println("\nTesting with mock repository:");
        
     
        CustomerRepository testRepository = new CustomerRepository() {
            @Override
            public String findCustomerById(String id) {
                return "[MOCK] Customer " + id;
            }
        };
       
        CustomerService testService = new CustomerService(testRepository);
        System.out.println(testService.getCustomerDetails("TEST123"));
    }
}
