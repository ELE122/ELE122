package lecture9;

class BankAccount {
	int balance = 0;
	
	// What does the synchronized keyword do?
	// What is the output if you remove it? Why?
	public synchronized void increment() {
		balance++;
	}
}

public class ThreadInterference {

	public static void main(String[] args) throws InterruptedException {

		// Create my bank account
		BankAccount myBankAccount = new BankAccount();
		
		// Create two MoneyMakers running in two separate threads
		// Each MoneyMaker stores a ref to my bank account and increments it 1000 times
		Thread thread1 = new Thread(new MoneyMaker(myBankAccount));
		Thread thread2 = new Thread(new MoneyMaker(myBankAccount));
		thread1.start();
		thread2.start();

		// What is the effect of these calls to join()? Why do we need it?
		thread1.join();
		thread2.join();
		
		System.out.println("Balance is " + myBankAccount.balance);
	}
}
