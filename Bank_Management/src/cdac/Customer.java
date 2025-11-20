package cdac;

public class Customer {
	private String name;
	private String customerId;
	private BankAccount bankAccount;
	public Customer(String name,String customerId,BankAccount account) {
		this.name=name;
		this.customerId=customerId;
		this.bankAccount = account;
    }

    public void displayInfo() {
        System.out.println("Customer Name: " + name);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Account Number: " + bankAccount.getAccountNumber());
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
	
