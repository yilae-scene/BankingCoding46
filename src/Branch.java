import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialTransaction) {
        Customer customer = findCustomer(customerName);
        if (customer == null) {
            return customers.add(new Customer(customerName, initialTransaction));
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double transaction) {
        Customer customer = findCustomer(customerName);
        if (customer != null) {
            customer.addTransaction(transaction);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String customerName) {
        for (Customer cust : customers) {
            if (cust.getName().equalsIgnoreCase(customerName)) {
                return cust;
            }
        }
        return null;
    }

    public String toString(){
        for (Customer customer : customers) {
            System.out.println(customer.getName());
        }
        return null;
    }
}
