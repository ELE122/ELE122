package ExceptionExcercise;

public class ArraySizeException extends Exception {
	String message = null;
	
	public ArraySizeException(String string) {
		this.message = string; 	
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	
}
