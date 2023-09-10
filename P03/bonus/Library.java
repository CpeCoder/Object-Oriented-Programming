import java.util.ArrayList;

public class Library
{
	private String name;
	private ArrayList<Publication> publications = new ArrayList<>();
	private ArrayList<Patron> patrons;

	public Library(String name)
	{
		this.name = name;
		patrons = new ArrayList<>();
	}
	
	public void addPublication(Publication publication)
	{
		publications.add(publication);
	}

	public void addPatron(Patron patron)
	{
		patrons.add(patron);
	}
	
	public String patronMenu()
	{
                StringBuilder patronList = new StringBuilder();
                for(int i=0; i <= patrons.size()-1; i++)
                {
                        patronList.append(String.format("%d) %s\n", i, patrons.get(i)));
                }
                return patronList.toString();
	}	

	public void checkOut(int publicationIndex, int patronIndex)
	{
		try
		{
			Publication checkOutPublication = publications.get(publicationIndex);
			checkOutPublication.checkOut(patrons.get(patronIndex));
		}
		catch(IndexOutOfBoundsException e)
		{
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());	
		}
	}
	
	@Override
	public String toString()
	{
		StringBuilder output = new StringBuilder();
		output.append(name).append("\n");	
		for(int i=0; i <= publications.size()-1; i++)
		{
			output.append(String.format("%d) %s\n", i, publications.get(i)));
		}
		return output.toString();
	}
}
