import java.util.ArrayList;

public class Library {
	private String name;
	private ArrayList<Publication> publications = new ArrayList<>();

	public Library(String name) {
		this.name = name;
	}

	public void addPublication(Publication publication) {
		publications.add(publication);
	}

	public void checkOut(int publicationIndex, String patron) {
		Publication checkOutPublication = publications.get(publicationIndex);
		checkOutPublication.checkOut(patron);
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(name).append("\n");
		for (int i = 0; i <= publications.size() - 1; i++) {
			output.append(String.format("%d) %s\n", i, publications.get(i)));
		}
		return output.toString();
	}
}
