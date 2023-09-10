import java.time.LocalDate;


public class Publication
{
	private String title, author;
	private Patron loanedTo;
	private int copyright;
	private LocalDate dueDate;

	public Publication(String title, String author, int copyright)
	{
		this.title = title;
		this.author = author;
		this.copyright = copyright;
	
		//LocalDate todaysDate = LocalDate.now();

		if(copyright < 1900  || copyright > (LocalDate.now()).getYear())
		{
			throw new IllegalArgumentException("The year of copyright is before 1900 or after today's year");
		}
	}

	public void checkOut(Patron patron)
	{
		loanedTo = patron;
		dueDate = (LocalDate.now()).plusDays(14);
	}

	@Override
	public String toString()
	{
		StringBuilder output = new StringBuilder();
		if(loanedTo != null)
		{
			output.append(String.format("\nLoaner: %s\n", loanedTo));		
		}
                output.append(String.format("\"%s\" by %s, copyright %d\n", title, author, copyright));
		if(loanedTo != null)
		{
			output.append(String.format("Due by: %s\n", dueDate));
		}

		return output.toString();
	}
}
