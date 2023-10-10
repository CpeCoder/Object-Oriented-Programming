package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.IOException;

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
	 * Constructs a new Library object by reading data from a BufferedReader.
	 * This constructor initializes the Library object by reading the library's
	 * name,
	 * publications, and patrons from the BufferedReader. It handles different types
	 * of
	 * publications (Publication or Video) and their respective data during the
	 * process.
	 *
	 * @param br The BufferedReader from which library data is read.
	 * @throws IOException           If an IOException occurs while reading data
	 *                               from the BufferedReader.
	 * @throws NumberFormatException If there is an issue parsing numeric data.
	 */
	public Library(BufferedReader br) {
		try {
			this.name = br.readLine();
			this.publications = new ArrayList<>();
			int publicationSize = Integer.parseInt(br.readLine());
			String publicationType;

			for (int i = 0; i < publicationSize; i++) {
				publicationType = br.readLine();
				if (publicationType.equals("Publication")) {
					addPublication(new Publication(br));

				} else if (publicationType.equals("Video")) {
					addPublication(new Video(br));
				}
			}

			int patronSize = Integer.parseInt(br.readLine());
			patrons = new ArrayList<>();

			for (int i = 0; i < patronSize; i++) {
				addPatron(new Patron(br));
			}
		} catch (IOException | NumberFormatException e) {
			System.err.println("Error reading library - " + e.getMessage());
		}
	}

	/**
	 * Saves the data of this Library object to a BufferedWriter.
	 * This method writes the library's name, the count of publications, the list of
	 * publications (including their types), the count of patrons, and the list of
	 * patrons
	 * to the BufferedWriter. It invokes the save method of each publication and
	 * patron
	 * to write their respective data.
	 *
	 * @param bw The BufferedWriter to which the library data is saved.
	 * @throws IOException If an IOException occurs while writing data to the
	 *                     BufferedWriter.
	 */
	public void save(BufferedWriter bw) {
		try {
			bw.write(name + "\n");
			bw.write(String.valueOf(publications.size()) + "\n");
			for (Publication p : publications) {
				if (p instanceof Video) {
					bw.write("Video" + "\n");
				} else if (p instanceof Publication) {
					bw.write("Publication" + "\n");
				}
				p.save(bw);
			}
			bw.write(String.valueOf(patrons.size()) + "\n");
			for (Patron p : patrons) {
				p.save(bw);
			}
			bw.flush();
		} catch (IOException e) {
			System.err.println("Error saving library - " + e.getMessage());
		}
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
