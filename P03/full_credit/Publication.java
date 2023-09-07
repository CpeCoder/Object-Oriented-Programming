import java.time.LocalDate;


public class Publication{
	private String title, author, loanedTo;
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

	public String checkOut(String patron)
	{
		loanedTo = patron;
		dueDate = (LocalDate.now()).plusDays(14);
	}

	@Override
	public String toString()
	{

	}
}
