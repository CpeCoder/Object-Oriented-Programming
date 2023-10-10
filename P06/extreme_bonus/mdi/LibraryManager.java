package mdi;

import library.Library;
import library.Patron;
import library.Publication;
import library.Video;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * The {@code LibraryManager} class represents a simple library management
 * program.
 * It allows users to interact with a library system by adding publications,
 * patrons, and checking out publications to patrons.
 */
class LibraryManager {
    private Library library;

    public LibraryManager(Library library) {
        this.library = library;
    }

    public void listPublications() {
        System.out.println(library);
    }

    public void addPublication() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Title<enter>Author<enter>Year\n");
        library.addPublication(new Publication(
                scanner.nextLine(), scanner.nextLine(),
                Integer.parseInt(scanner.nextLine())));
    }

    public void addVideo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nTitle<enter>Author<enter>Year<enter>Runtime");
        library.addPublication(new Video(
                scanner.nextLine(), scanner.nextLine(),
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine())));
    }

    public void checkOutPublication() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(library);
        System.out.print("Enter the publication number to check out: ");
        int selection = scanner.nextInt();
        scanner.nextLine();
        System.out.println(library.patronMenu());
        System.out.print("Enter the patron number: ");
        int patron = scanner.nextInt();
        scanner.nextLine();
        library.checkOut(selection, patron);
    }

    public void checkInPublication() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(library);
        System.out.print("Enter the publication number to check in: ");
        int selection = scanner.nextInt();
        scanner.nextLine();
        library.checkIn(selection);
    }

    public void listPatron() {
        System.out.println(library.patronMenu());
    }

    public void addPatron() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter patron name: ");
        String patronName = scanner.nextLine();
        System.out.print("Enter patron ID: ");
        String patronID = scanner.nextLine();
        library.addPatron(new Patron(patronName, patronID));
    }

    public void openLibrary() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            library = new Library(br);
            System.out.println("Library data loaded successfully from " + filename);
        } catch (IOException e) {
            System.err.println("Error opening " + filename + " - " + e);
        }
    }

    public void saveLibrary() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = scanner.nextLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            library.save(bw);
            System.out.println("Library data saved successfully to " + filename);

        } catch (IOException e) {
            System.err.println("Error writing in " + filename + " - " + e);
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Library library = new Library("Deep's Library");
            LibraryManager libraryManager = new LibraryManager(library);
            while (true) {
                System.out.println("========\nMain Menu\n========");
                System.out.println("\nDeep's Library\n");
                System.out.println("\nPublications\n1. List");
                System.out.println("2. Add");
                System.out.println("3. Check Out");
                System.out.println("4. Check In");
                System.out.println("\nPatrons\n5. List");
                System.out.print("6. Add");
                System.out.print("\n\nFiles\n7. Open File\n8. Save Library\n");
                System.out.print("0. Exit\n");
                System.out.print("\n\nChoose an option: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        libraryManager.listPublications();
                        break;
                    case 2:
                        System.out.print("Enter publication type (Publication/Video): ");
                        String pubType = scanner.nextLine();
                        if (pubType.equals("Publication")) {
                            libraryManager.addPublication();
                        } else if (pubType.equals("Video")) {
                            libraryManager.addVideo();
                        } else {
                            System.err.println("Invalid publication type");
                        }
                        break;
                    case 3:
                        libraryManager.checkOutPublication();
                        break;
                    case 4:
                        libraryManager.checkInPublication();
                        break;
                    case 5:
                        libraryManager.listPatron();
                        break;
                    case 6:
                        libraryManager.addPatron();
                        break;
                    case 7:
                        libraryManager.openLibrary();
                        break;
                    case 8:
                        libraryManager.saveLibrary();
                        break;
                    case 0:
                        System.out.println("Exiting the program.");
                        return;
                    default:
                        System.err.println("Invalid option");
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid copyright year - " + e);
        } catch (Exception e) {
            System.err.println("Unexpected exception - " + e);
        }
    }
}
