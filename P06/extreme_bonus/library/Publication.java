package library;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.time.LocalDate;

/**
 * The {@code Publication} class represents a publication, such as a book, with
 * properties including title, author, copyright year, and loan information.
 */
public class Publication {
	private String title, author;
	private Patron loanedTo;
	private int copyright;
	private LocalDate dueDate;

	/**
	 * Constructs a new {@code Publication} with the specified title, author, and
	 * copyright year.
	 *
	 * @param title     the title of the publication.
	 * @param author    the author of the publication.
	 * @param copyright the copyright year of the publication.
	 * @throws IllegalArgumentException if the copyright year is before 1900 or
	 *                                  after the current year.
	 */
	public Publication(String title, String author, int copyright) {
		this.title = title;
		this.author = author;
		this.copyright = copyright;

		if (copyright < 1900 || copyright > (LocalDate.now()).getYear()) {
			throw new IllegalArgumentException("The year of copyright is before 1900 or after today's year");
		}
	}

	/**
	 * Constructs a new Publication object by reading data from a BufferedReader.
	 * This constructor initializes the Publication object by reading title, author,
	 * copyright, and loan status information from the BufferedReader.
	 *
	 * @param br The BufferedReader from which publication data is read.
	 * @throws IOException              If an IOException occurs while reading data
	 *                                  from the BufferedReader.
	 * @throws IllegalArgumentException If the loan status read from the
	 *                                  BufferedReader is invalid.
	 */
	public Publication(BufferedReader br) {
		try {
			this.title = br.readLine();
			this.author = br.readLine();
			this.copyright = Integer.parseInt(br.readLine());

			String line = br.readLine();
			if (line.equals("checked in")) {
				this.loanedTo = null;
				this.dueDate = null;
			} else if (line.equals("checked out")) {
				this.loanedTo = new Patron(br);
				this.dueDate = LocalDate.parse(br.readLine());
			} else {
				throw new IllegalArgumentException("Invalid status: " + line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Saves the data of this Publication object to a BufferedWriter.
	 * This method writes the title, author, copyright, and loan status (checked in
	 * or checked out)
	 * of the publication to the BufferedWriter. If the publication is checked out,
	 * it also saves
	 * information about the patron it is loaned to and the due date.
	 *
	 * @param bw The BufferedWriter to which the publication data is saved.
	 * @throws IOException If an IOException occurs while writing data to the
	 *                     BufferedWriter.
	 */
	public void save(BufferedWriter bw) {
		try {
			bw.write(title + "\n");
			bw.write(author + "\n");
			bw.write(Integer.toString(copyright) + "\n");
			if (loanedTo == null) {
				bw.write("checked in\n");
			} else {
				bw.write("checked out\n");
				loanedTo.save(bw);
				bw.write(dueDate.toString() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Checks out the publication to a patron, setting the due date.
	 *
	 * @param patron the patron to whom the publication is being checked out.
	 */
	public void checkOut(Patron patron) {
		loanedTo = patron;
		dueDate = (LocalDate.now()).plusDays(14);
	}

	/**
	 * Helper method to build a part of the string representation.
	 *
	 * @param pre the prefix string.
	 * @param mid the middle string.
	 * @return a StringBuilder containing the formatted publication information.
	 */

	protected StringBuilder toStringBuilder(String pre, String mid) {
		StringBuilder output = new StringBuilder();
		output.append(pre);
		output.append(String.format("\"%s\" by %s, copyright %d", title, author, copyright));
		output.append(mid);
		if (loanedTo != null) {
			output.append(String.format("\n\tLoned by: %s. Due by: %s\n", loanedTo, dueDate));
		}
		return output;
	}

	/**
	 * Generates a string representation of the publication.
	 *
	 * @return a string representation of the publication.
	 */
	@Override
	public String toString() {
		return toStringBuilder("Book ", "").toString() + "\n";
	}
}
