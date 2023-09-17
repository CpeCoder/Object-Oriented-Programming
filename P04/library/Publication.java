package library;

import java.time.LocalDate;

public class Publication {
	private String title, author;
	private Patron loanedTo;
	private int copyright;
	private LocalDate dueDate;

	public Publication(String title, String author, int copyright) {
		this.title = title;
		this.author = author;
		this.copyright = copyright;

		// LocalDate todaysDate = LocalDate.now();

		if (copyright < 1900 || copyright > (LocalDate.now()).getYear()) {
			throw new IllegalArgumentException("The year of copyright is before 1900 or after today's year");
		}
	}

	public void checkOut(Patron patron) {
		loanedTo = patron;
		dueDate = (LocalDate.now()).plusDays(14);
	}

	protected StringBuilder toStringBuilder(String pre, String mid){
		StringBuilder output = new StringBuilder();
		output.append(pre);
		output.append(String.format("\"%s\" by %s, copyright %d", title, author, copyright));
		output.append(mid);
		if (loanedTo != null) {
                        output.append(String.format("\n\tLoned by: %s. Due by: %s\n", loanedTo, dueDate));
                }
		return output;
	}

	@Override
	public String toString() {
		return toStringBuilder("Book ", "").toString() + "\n";
	}
}
