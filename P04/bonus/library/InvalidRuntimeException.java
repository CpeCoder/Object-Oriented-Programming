package library;

/**
 * The {@code InvalidRuntimeException} class is a custom exception class that
 * extends the
 * standard {@link ArithmeticException} class. It is thrown when a {@code Video}
 * object is
 * created with an invalid runtime.
 */

public class InvalidRuntimeException extends ArithmeticException {
	/**
	 * Constructs a new {@code InvalidRuntimeException} with no detail message.
	 */
	public InvalidRuntimeException() {
		super();
	}

	/**
	 * Constructs a new {@code InvalidRuntimeException} with the specified detail
	 * message.
	 *
	 * @param message the detail message.
	 */
	public InvalidRuntimeException(String message) {
		super(message);
	}

	/**
	 * Constructs a new {@code InvalidRuntimeException} with a formatted detail
	 * message
	 * indicating that a title has an invalid runtime.
	 *
	 * @param title   the title associated with the invalid runtime.
	 * @param runtime the invalid runtime value.
	 */
	public InvalidRuntimeException(String title, int runtime) {
		super(title + " has invalid runtime " + runtime);
	}
}
