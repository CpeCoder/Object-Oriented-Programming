import java.util.Scanner;

public class LibraryManager
{
	public static void main(String[] args)
	{

		Library myLib = new Library("Deep's Library");

		Publication book1 = new Publication("The Road", "Cormac McCarthy", 2006);
		Publication book2 = new Publication("A Long Way Gone", "Ishmael Beah", 2007);
		Publication book3 = new Publication("Harry Potter and the Half-Blood Prince", "J. K. Rowling", 2005);
		
		myLib.addPublication(book1);
		myLib.addPublication(book2);
		myLib.addPublication(book3);

		System.out.println(myLib);
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Which book to check out? ");
		int bookIndex = in.nextInt();
		in.nextLine();
		System.out.print("Who are you? ");
		String name = in.nextLine();

		myLib.checkOut(bookIndex, name);
		
		System.out.print(myLib);

		in.close();
	}
}
