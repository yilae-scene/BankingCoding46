import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank (String name){
        this.name = name;
        branches = new ArrayList<>();
    }

    public  boolean addBranch(String name){
        Branch branch = findBranch(name);
        if(branch == null){
            branches.add(new Branch(name));
            return true;
        }
        return false;
    }

    private  Branch findBranch(String name) {
        for(var branche : branches){
            if(branche.getName().equalsIgnoreCase(name)){
                return branche;
            }
        }
        return null;
    }

    public boolean addCustomer(String branchName, String customerName,
                                double initialTransaction){
        Branch branch = findBranch(branchName);
        if(branch != null){
            branch.newCustomer(customerName, initialTransaction);
            return true;

        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName,
    double transaction){
        Branch branch = findBranch(branchName);
        if(branch == null){
            return false;
        }
        return branch.addCustomerTransaction(customerName, transaction);
    }

//    public boolean listCustomers(String branchName, boolean printTransactions){
//        Branch branch = findBranch(branchName);
//        public boolean listCustomers(String branchName, boolean showTransactions) {
//
//                Branch branch = findBranch(branchName);
//                if (branch != null) {
//                    System.out.println("Customer details for branch " + branch.getName());
//                    ArrayList<Customer> branchCustomers = branch.getCustomers();
//                    for (int i = 0; i < branchCustomers.size(); i++) {
//                        Customer branchCustomer = branchCustomers.get(i);
//                        System.out.println("Customer: " + branchCustomer.getName() + "[" + (i+1) + "]");
//                        if (showTransactions) {
//                            System.out.println("Transactions");
//                            ArrayList<Double> transactions = branchCustomer.getTransaction();
//                            for (int j = 0; j < transactions.size(); j++) {
//                                System.out.println("[" + (j+1) + "] Amount " + transactions.get(j));
//                            }
//                        }
//                    }
//                    return true;
//                }
//                return false;
        //    }
//        if(branch == null){
//            return false;
//        }
//        if(printTransactions){
//            System.out.println("Customer details for branch "+branchName);
//            int index = 1;
//            for(Branch br : branches){
//                if(br.getName().equalsIgnoreCase(branchName)){
//                    System.out.println("Customer: "+br.getCustomers()+"["+index+"]");
//                    System.out.println("Transactions");
//                    System.out.println("["+index+"] Amount "+br.getCustomers());
//                    index++;
//                }
//            }
//        }
//
//        for(int i = 0; i < branches.size(); i++){
//            System.out.println("Customer details for branch "+branchName);
//            if(branches.get(i).getName().equalsIgnoreCase(branchName)){
//                System.out.println("Customer: "+branches.toString()+"["+i+"]");
//            }
//        }
//        return true;
 //   }
    public boolean listCustomers(String branchName, boolean printTransaction){
        Branch branch = findBranch(branchName);
        if(branch != null){
            ArrayList<Customer> collectCustomers = branch.getCustomers();
            int index = 1;
            for(Customer cust: collectCustomers) {
                System.out.println("customer details for branch "+branchName);
                System.out.println("Customer: "+cust+"["+index+"]");
                ArrayList<Double> customerTransaction = cust.getTransaction();
                if(printTransaction){
                    System.out.println("Transactions");
                    int index2 = 1;
                    for(Double d : customerTransaction){
                        System.out.println("["+index2+"] Amount "+ d);
                        index2++;
                    }
                }
                index++;
            }
            return true;
        }
        return false;
    }

}
