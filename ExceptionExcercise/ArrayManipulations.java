package ExceptionExcercise;


//This class provides utility methods for creating and manipulating arrays
//The 'final' keyword and the private constructor makes sure that class can not be instantiated
public final class ArrayManipulations {
	
	//Private constructor
	private ArrayManipulations() {
		throw new UnsupportedOperationException();
	}
	
	
	//The sumVector() method
	public static int[] sumVector(int[] array1, int[] array2) throws ArraySizeException {
		int[] sumArray = null;
		if(array1.length != array2.length) {
			throw new ArraySizeException("ArraySizeException: The array dimensions are incompatible. Array1 is " + array1.length + " and array2 is " + array2.length);
		}else {
			sumArray = new int[array1.length];
			for(int i =0; i < array1.length;i++) {
				sumArray[i] = array1[i] + array2[i];
			}
		}
		
		return sumArray;
	}
	
	
	//Method that creates an array with numbers from 'start' to 'end'
	public static int[] makeArray(int start, int end) {
		//By throwing an IllegalArgumentException if end<start I state that this is an invalid use of this method
		//Otherwise the user would be fronted with an NegativeArraySizeException
		if (end<start) {
			throw new IllegalArgumentException("The 'end' parameter must be larger than 'start'");
		}
		
		 int size = end - start + 1;
		 
		 int[] array = new int[size];
		 for (int i=0; i<size; i++) {
			array[i] = start + i;	
		 }
		return array;
	}
	
	
	//Method that prints an array to the console. For example: [1,2,3]
	public static void printArray(int[] array) {
		System.out.print("[");
		for (int i=0; i<array.length; i++) {
			if (i == array.length -1) {
				System.out.print(array[i]);
			}else {
				System.out.print(array[i] + ",");
			}		
		}
		System.out.print("]");
	}
		
	
}
