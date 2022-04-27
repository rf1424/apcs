import java.util.ArrayList;

/**
 * Subclass of Celebrity to show how methods can be overridden and super can be called while changing functionality.
 * @author cody.henrichsen
 * @version 1.0 15/09/2018
 */
public class SingerCelebrity extends Celebrity
{
	/**
	 * The list of clues for the Singer Celebrity.
	 */
	private ArrayList<String> clueList;

	/**
	 * Builds a LiteratureCelebrity instance with an answer and a series of clues as a String separated by commas.
	 * @param answer The literature celebrity
	 * @param clues Clues for the literature celebrity
	 */
	public SingerCelebrity(String answer, String clues)
	{
		super(answer, clues);
		processClues();
	}

	/**
	 * Processes the series of clues for the LiteratureCelebrity by adding all the values to an ArrayList<String> by
	 * splitting the original clue to an array of String.
	 * The original value is not impacted, thus preserving data and inheritance integrity.
	 */
	private void processClues()
	{
		String [] clues = super.getClue().split(",");
		clueList = new ArrayList<String>();
		for (String currentClue : clues)
		{
			clueList.add(currentClue);
		}
	}

	/**
	 * Overridden version of the getClue() method that cycles through each of the individual clues in the series.
	 * It recreates the clueList if the user has finished the series of clues.
	 */
	@Override
	public String getClue()
	{
		if (clueList.size() == 0)
		{
			processClues();
		}
		String currentClue = clueList.remove(0);

		return currentClue;
	}

	
	@Override
	public String toString()
	{
		String dsc = "This is the singer celebrity: " + getAnswer() + "\nThe clues are:\n";

		for (String word : super.getClue().split(","))
		{
			dsc += word + "\n";
		}

		return dsc;
	}

}
