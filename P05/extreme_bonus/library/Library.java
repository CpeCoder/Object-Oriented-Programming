package library;

import java.util.ArrayList;

/**
 * The {@code Library} class represents a library with a collection of
 * publications and patrons.
 */
public class Library {
	private String name;
	private ArrayList<Publication> publications = new ArrayList<>();
	private ArrayList<Patron> patrons;

	/**
	 * Constructs a new library with the given name.
	 *
	 * @param name the name of the library.
	 */
	public Library(String name) {
		this.name = name;
		patrons = new ArrayList<>();
	}

	/**
	 * Adds a publication to the library's collection.
	 *
	 * @param publication the publication to be added.
	 */
	public void addPublication(Publication publication) {
		publications.add(publication);
	}

	/**
	 * Adds a patron to the library's list of patrons.
	 *
	 * @param patron the patron to be added.
	 */
	public void addPatron(Patron patron) {
		patrons.add(patron);
	}

	/**
	 * Generates a menu listing all patrons in the library.
	 *
	 * @return a formatted string containing the list of patrons.
	 */
	public String patronMenu() {
		StringBuilder patronList = new StringBuilder();
		for (int i = 0; i <= patrons.size() - 1; i++) {
			patronList.append(String.format("%d) %s\n", i, patrons.get(i)));
		}
		return patronList.toString();
	}

	/**
	 * Checks out a publication to a patron.
	 *
	 * @param publicationIndex the index of the publication to be checked out.
	 * @param patronIndex      the index of the patron who is checking out the
	 *                         publication.
	 */
	public void checkOut(int publicationIndex, int patronIndex) {
		Publication checkOutPublication = publications.get(publicationIndex);
		checkOutPublication.checkOut(patrons.get(patronIndex));
	}

	/**
	 * Checks out a publication to a patron.
	 *
	 * @param publicationIndex the index of the publication to be checked in.
	 * 
	 */
	public void checkIn(int publicationIndex) {
		Publication checkInPublication = publications.get(publicationIndex);
		checkInPublication.checkOut(null);
	}

	/**
	 * Returns a string representation of the library, including its name and a list
	 * of publications.
	 *
	 * @return a string representation of the library.
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(name).append("\n");
		for (int i = 0; i <= publications.size() - 1; i++) {
			output.append(String.format("%d) %s\n", i, publications.get(i)));
		}
		return output.toString();
	}
}
