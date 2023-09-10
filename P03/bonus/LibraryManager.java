import java.util.Scanner;

public class LibraryManager
{
	public static void main(String[] args)
	{

		Library myLib = new Library("\nDeep's Library");

		Publication book1 = new Publication("The Road", "Cormac McCarthy", 2006);
		Publication book2 = new Publication("A Long Way Gone", "Ishmael Beah", 2007);
		Publication book3 = new Publication("Harry Potter and the Half-Blood Prince", "J. K. Rowling", 2005);

		myLib.addPublication(book1);
		myLib.addPublication(book2);
		myLib.addPublication(book3);

		System.out.print(myLib);
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Which book to check out? ");
		int bookIndex = in.nextInt();
		in.nextLine();
		
		System.out.println("\nPatrons");
		Patron patron1 = new Patron("Charles Chaplin", "theCircus@best.world");
		myLib.addPatron(patron1);
		System.out.println(myLib.patronMenu());

		System.out.print("Who are you? ");
		int patronIndex = in.nextInt();

		myLib.checkOut(bookIndex, patronIndex);
		
		System.out.print(myLib);

		in.close();
	}
}
