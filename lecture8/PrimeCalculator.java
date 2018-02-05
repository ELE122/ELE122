package lecture8;

public class PrimeCalculator {

	private long numberToCheck;
	
	public PrimeCalculator (long numberToCheck) {
		this.numberToCheck = numberToCheck;
	}
	
	public void calculate() {
		boolean isPrime = isNumberPrime(numberToCheck);
		if(isPrime) {
			System.out.println(numberToCheck + " is a prime");
		}
		else {
			System.out.println(numberToCheck + " is not a prime");
		}
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
