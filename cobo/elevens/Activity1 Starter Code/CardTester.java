/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card qos = new Card("Queen", "Spades", 100);
		System.out.println(qos);

		Card toh = new Card("Two", "Hearts", 10);
		System.out.println(toh);

		Card aoc = new Card("Ace", "Clubs", 100);
		System.out.println(aoc);

		Card qos2 = new Card("Queen", "Spades", 100);

		System.out.println(qos2.matches(qos));
		System.out.println(aoc.matches(qos));
	}
}
