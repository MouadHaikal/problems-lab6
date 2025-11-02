package problem2;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Test Bank");

        bank.addCustomer("Adam", 100.0);
        bank.addCustomer("Bob", 50.0);

        bank.addCustomerTransaction("Adam", -20.0);
        bank.addCustomerTransaction("Adam", 40.0);
        bank.addCustomerTransaction("Bob", -10.0);

        bank.printStatements();
    }
}
