package mdi;

import library.*;
import java.util.Scanner;

/**
 * The {@code LibraryManager} class represents a simple library management
 * program.
 * It allows users to interact with a library system by adding publications,
 * patrons, and checking out publications to patrons.
 */
public class LibraryManager {
	/**
	 * The main method that serves as the entry point for the library management
	 * program.
	 *
	 * @param args command-line arguments (not used in this program).
	 */
	public static void main(String[] args) {
		try {
			Library myLib = new Library("\nDeep's Library");

			Publication book1 = new Publication("The Road", "Cormac McCarthy", 2006);
			Publication book2 = new Publication("A Long Way Gone", "Ishmael Beah", 2007);
			Publication book3 = new Publication("Harry Potter and the Half-Blood Prince", "J. K. Rowling", 2005);

			myLib.addPublication(book1);
			myLib.addPublication(book2);
			myLib.addPublication(book3);

			Publication video1 = new Video("The Godfather", "Francis Coppalo", 1972, 175);
			Publication video2 = new Video("The Shawshank Redemption", "Frank Darabont", 1994, 154);
			Publication video3 = new Video("Titanic", "James Camerson", 1997, 195);

			myLib.addPublication(video1);
			myLib.addPublication(video2);
			myLib.addPublication(video3);

			System.out.print(myLib);

			Scanner in = new Scanner(System.in);

			System.out.print("Which publication to check-out? ");
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
		} catch (Exception e) {
			System.err.println("Unable to check out a publication\n" + e);
		}
	}
}
