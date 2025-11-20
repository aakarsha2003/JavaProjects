package cdac;
public class BankAccount {
private String accountNumber;
private double balance;

public BankAccount(String accountNumber) {
	this.accountNumber=accountNumber;
	this.balance=balance;
}
public void deposit(double amount) {
	if(amount>0) {
		balance+=amount;
		System.out.println("Deposited:"+amount);
	}else {
		System.out.println("Amount must be positive.");
	}
}
public void withdraw(double amount) {
	if(amount>balance) {
		System.out.println("Insufficient Balance.");
	}else if(amount<=0) {
		System.out.println("Invalid withdrawal amount");
	}else {
		balance-=amount;
		System.out.println("Withdrew:"+amount);
	}
}
public void checkBalance() {
	System.out.println("Account Balance:"+balance);
}
public String getAccountNumber() {
	return accountNumber;
}
}