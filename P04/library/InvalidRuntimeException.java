package library;

public class InvalidRuntimeException extends ArithmeticException{
	public InvalidRuntimeException(){
		super();
	}
	public InvalidRuntimeException(String message){
		super(message);
	}
	public InvalidRuntimeException(String title, int runtime){
		super(title + " has invalid runtime " + runtime);
	}
}
