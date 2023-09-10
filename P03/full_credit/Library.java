import java.util.ArrayList;

public class Library
{
	private String name;
	private ArrayList<Publication> publications = new ArrayList<>();

	class Library(String name)
	{
		this.name = name;
	}
	
	public void addPublication(Publication publication)
	{
		publications.add(publication);
	}

	public void checkOut(int publicationIndex, String patron)
	{
		try
		{
			Publication checkOutPublication = publications.get(publicationIndex);
			checkOutPublication.checkOut(patron);
		}
		catch(IndexOutOfBoundsException e)
		{
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());	
		}
	}

}
