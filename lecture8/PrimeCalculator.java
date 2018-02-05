package lecture8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		System.out.println(Runtime.getRuntime().maxMemory());
		
		// Setup reading from console
		InputStreamReader consoleInputStreamReader = new InputStreamReader(System.in);
		BufferedReader consoleInputBufferedReader = new BufferedReader(consoleInputStreamReader);
		while (true) {
			System.out.print("Number to test:");
			String inputFromUser = consoleInputBufferedReader.readLine();
			long numberToCheck;
			try {
				numberToCheck = Long.parseLong(inputFromUser);
			} catch (NumberFormatException e) {
				System.out.println("ERROR! Please input a number!");
				continue;
			}
			boolean isPrime = isNumberPrime(numberToCheck);
			System.out.println(numberToCheck + " is" + (isPrime ? "" : " not") + " a prime");
		}
		
	}
	
    private static boolean isNumberPrime(long i) {
        int factors = 0;
        long j = 1;
        while(j <= i)
        {
            if(i % j == 0)
            {
                factors++;
            }
            j++;
        }
        return (factors == 2);
    }
}
