package lecture9;

public class MoneyMaker implements Runnable {

	BankAccount bankAccount;
	
	public MoneyMaker(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	public void run() {
		for(int i = 0; i < 1000; i++) {
			bankAccount.increment();
		}
	}
}
