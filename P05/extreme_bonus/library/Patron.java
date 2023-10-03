package library;

/**
 * The {@code Patron} class represents a library patron with a name and email.
 */
public class Patron {
	private String name;
	private String email;

	/**
	 * Constructs a new patron with the given name and email.
	 *
	 * @param name  the name of the patron.
	 * @param email the email of the patron.
	 */
	public Patron(String name, String email) {
		this.name = name;
		this.email = email;
	}

	/**
	 * Returns a formatted string representation of the patron, including their name
	 * and email.
	 *
	 * @return a string representation of the patron.
	 */
	@Override
	public String toString() {
		return String.format("%s (%s)", name, email);
	}
}
