import javax.swing.text.PlainDocument;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"A", "B", "C"};
		String[] suits = {"Red", "Blue", "Green"};
		int[] values = {3, 2, 1};
		Deck d = new Deck(ranks, suits, values);
		System.out.println(d);
		System.out.println(d.isEmpty());
		System.out.println(d.size());
		System.out.println(d.deal());
		System.out.println(d.size());
		System.out.println(d);

		String[] lotOfRanks = {"A", "B", "C", "D", "E", "F", "G", "H"};
		int[] lotOfValues = {1, 2, 3, 4, 5, 6, 7, 8};
		Deck q = new Deck(lotOfRanks, suits, lotOfValues);
		System.out.println(q);
		q.deal();
		System.out.println(q);
	}
}
