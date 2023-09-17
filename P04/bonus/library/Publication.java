package library;

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

		// LocalDate todaysDate = LocalDate.now();

		if (copyright < 1900 || copyright > (LocalDate.now()).getYear()) {
			throw new IllegalArgumentException("The year of copyright is before 1900 or after today's year");
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
