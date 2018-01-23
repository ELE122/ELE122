package ExceptionExcercise;

//This class tests the sumVector() method placed in the ArrayManipulations class
//
public class TesterClass {
	public static void main(String[] args) {
		System.out.println("This program pairwise summarizes to vectors:");
		
		//Create two arrays
		int[] array1 = ArrayManipulations.makeArray(10,15);
		int[] array2 = ArrayManipulations.makeArray(5,10);
		
		int[]arraySum = null;
		
		try {
			//Compute the sum
			arraySum = ArrayManipulations.sumVector(array1,array2);
		} catch (ArraySizeException e) {
			// We go here if the dimensions are wrong
			System.out.println(e.getMessage());
		}
		
		//If the array object was created print the results nicely to the screen
		if (arraySum != null) {
			System.out.println("Success:");
			ArrayManipulations.printArray(array1);
			System.out.print(" + ");
			ArrayManipulations.printArray(array2);
			System.out.print(" = ");
			ArrayManipulations.printArray(arraySum);
		}
		
	
		
	}
	

}
