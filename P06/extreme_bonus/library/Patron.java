package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

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
	 * Constructs a patron by reading data from a BufferedReader.
	 *
	 * @param br the BufferedReader from which to read patron data.
	 * @throws IOException if there is an error reading from the BufferedReader.
	 */
	public Patron(BufferedReader br) throws IOException {
		this.name = br.readLine();
		this.email = br.readLine();
	}

	/**
	 * Saves the patron's name and email to the provided BufferedWriter.
	 *
	 * @param bw the BufferedWriter to which the data will be written.
	 * @throws IOException if there is an error writing to the BufferedWriter.
	 */
	public void save(BufferedWriter bw) throws IOException {
		bw.write(name + "\n");
		bw.write(email + "\n");
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
