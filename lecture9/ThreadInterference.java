package lecture9;

class BankAccount {
	int balance = 0;
	
	public void increment() {
		balance++;
	}
}

public class ThreadInterference {

	public static void main(String[] args) throws InterruptedException {

		BankAccount myBankAccount = new BankAccount();
		
		Thread thread1 = new Thread(new MoneyMaker(myBankAccount));
		Thread thread2 = new Thread(new MoneyMaker(myBankAccount));

		// What does this do? Why do we need it?
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		
		System.out.println("Balance is " + myBankAccount.balance);
	}
}
