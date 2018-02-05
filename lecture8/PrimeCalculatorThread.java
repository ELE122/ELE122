package lecture8;

public class PrimeCalculatorThread extends Thread {

	private long numberToCheck;
	
	public PrimeCalculatorThread (long numberToCheck) {
		this.numberToCheck = numberToCheck;
	}
	
	public void run() {
		calculate();
	}
	
	private void calculate() {
		boolean isPrime = isNumberPrime(numberToCheck);
		System.out.println(numberToCheck + " is" + (isPrime ? "" : " not") + " a prime");
	}
	
    private static boolean isNumberPrime(long i) {
       	System.out.println("Calculating for " + i);
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
