import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LibraryManager
{
	public static void main(String[] args)
	{

		Library myLib = new Library("\nDeep's Library");
		
                try
                {

                        BufferedReader br = new BufferedReader(new FileReader("publications.txt"));
                        String rdLine;
                        while((rdLine = br.readLine()) != null)
                        {
                                String[] lines = rdLine.split(",");
				
				if(lines.length == 3)
				{
                                	String title = lines[0].trim();
                                	String author = lines[1].trim();
					int copyright = Integer.parseInt(lines[2].trim());

                                	Publication book = new Publication(title, author, copyright);
                                	myLib.addPublication(book);
                        	}
			}
                }
                catch(IOException e)
                {
                        e.printStackTrace();
                }


		//Publication book1 = new Publication("The Road", "Cormac McCarthy", 2006);
		//Publication book2 = new Publication("A Long Way Gone", "Ishmael Beah", 2007);
		//Publication book3 = new Publication("Harry Potter and the Half-Blood Prince", "J. K. Rowling", 2005);

		//myLib.addPublication(book1);
		//myLib.addPublication(book2);
		//myLib.addPublication(book3);

		System.out.print(myLib);
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Which book to check-out? ");
		int bookIndex = in.nextInt();
		in.nextLine();
		
		System.out.println("\nPatrons");
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("patrons.txt"));
			String rdLine;
			while((rdLine = br.readLine()) != null)
			{
				String[] lines = rdLine.split(",");
				
				if(lines.length == 2)
				{
					String name = lines[0].trim();
					String email = lines[1].trim();
					Patron patron = new Patron(name, email);
					myLib.addPatron(patron);
				}
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		//Patron patron1 = new Patron("Charles Chaplin", "theCircus@best.world");
		//myLib.addPatron(patron1);
		System.out.println(myLib.patronMenu());

		System.out.print("Who are you? ");
		int patronIndex = in.nextInt();
		
		myLib.checkOut(bookIndex, patronIndex);
		
		System.out.print(myLib);

		in.close();
	}
}
