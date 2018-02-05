package lecture8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeCheckerApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		// Setup reading from console
		InputStreamReader consoleInputStreamReader = new InputStreamReader(System.in);
		BufferedReader consoleInputBufferedReader = new BufferedReader(consoleInputStreamReader);
		
		// Read from console continuously
		while (true) {
			String inputFromUser = consoleInputBufferedReader.readLine();
			long numberToCheck;
			try {
				numberToCheck = Long.parseLong(inputFromUser);
			} catch (NumberFormatException e) {
				System.out.println("ERROR! Please input a number!");
				continue;
			}
			
			// We have received a valid number from user, now check if it is prime
			
			// 1) Using the main thread:
			// Create an instance of PrimeCalculator and call its calculate method
			PrimeCalculator primeCalculator = new PrimeCalculator(numberToCheck);
			primeCalculator.calculate();
			
			// 2) Using a new thread via subclassing of Thread: 
			// Create an instance of PrimeCalculatorThread which inherits from Thread, and start it
//			(new PrimeCalculatorThread(numberToCheck)).start();
			
			// 3) Using a new thread and a Runnable interface:
//			// Create a new Thread object and give a new PrimeCalculatorRunnable interface to its constructor
//			(new Thread(new PrimeCalculatorRunnable(numberToCheck))).start();
		}
	}
}
