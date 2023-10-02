package mdi;

import library.Library;
import library.Patron;
import library.Publication;
import library.Video;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The {@code LibraryManager} class represents a simple library management
 * program.
 * It allows users to interact with a library system by adding publications,
 * patrons, and checking out publications to patrons.
 */
class LibraryManager {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader((args[0])))) 
	{
            String name;
            Library library = new Library(br.readLine());

            while((name=br.readLine())!=null) 
	    {
                if(name.isEmpty()) break;
                if(name.equals("Publication")) 
		{
                    library.addPublication(new Publication(br.readLine(), br.readLine(),
                                           Integer.parseInt(br.readLine())));
                }
		else if(name.equals("Video")) 
		{
                    library.addPublication(new Video(br.readLine(), br.readLine(),
                                           Integer.parseInt(br.readLine()),
                                           Integer.parseInt(br.readLine())));
                } 
		else 
		{
                    throw new IOException("Can't load " + args[0]);
                }
            }
            
	    while((name=br.readLine())!=null) 
	    {
                if(name.isEmpty()) break;
                library.addPatron(new Patron(name, br.readLine()));
            }

            System.out.println(library);
            int selection = Integer.parseInt(System.console().readLine("\nWhich book to check out? "));
            System.out.println(library.patronMenu());
            int patron = Integer.parseInt(System.console().readLine("\nWho are you? "));
            
	    library.checkOut(selection, patron);
            System.out.println(library);
        } 
	catch(IllegalArgumentException e) 
	{
            System.err.println("Invalid copyright year - " + e);
        } 
	catch(ArrayIndexOutOfBoundsException e) 
	{
            System.err.println("Missing filename argument - " + e);
        } 
	catch(IOException e) 
	{
            System.err.println("Error reading file " + args[0] + " - " + e);
        } 
	catch(Exception e) 
	{
            System.err.println("Unexpected exception - " + e);
        }
    }
}
