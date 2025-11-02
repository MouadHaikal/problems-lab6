package problem2;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public boolean addCustomer(String customerName, double initialTransaction) {
        if (findCustomer(customerName) == null) {
            customers.add(new Customer(customerName, initialTransaction));
            System.out.println("Customer " + customerName + " added successfully.");
            return true;
        } else {
            System.out.println("Customer " + customerName + " already exists.");
            return false;
        }
    }

    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            System.out.println("Transaction added for " + customerName + ": " + amount);
            return true;
        }
        System.out.println("Customer not found.");
        return false;
    }

    private Customer findCustomer(String customerName) {
        for (Customer c : customers) {
            if (c.getName().equalsIgnoreCase(customerName)) {
                return c;
            }
        }
        return null;
    }

    public void printStatements() {
        System.out.println("=== Bank Statement for " + name + " ===");
        for (Customer c : customers) {
            System.out.println("Customer: " + c.getName());
            System.out.println("Transactions:");
            for (Double amount : c.getTransactions()) {
                // Using unboxing
                double value = amount;
                System.out.println("  " + value);
            }
            System.out.println();
        }
    }
}
