/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
	/**
	 * Get a default greeting
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}


	public static String trim(String statement) {
		String result = "";
		for (int i=0; i<statement.length(); i++) {
			if (statement.substring(i, i+1).equals(" ")) {
				result = statement.substring(i);
			} else {
				break;
			}
		}
		for (int i=statement.length()-1; i<=0; i--) {
			if (statement.substring(i, i+1).equals(" ")) {
				result = result.substring(0, i);
			} else {
				break;
			}
		}
		return result;
	}
	/**
	 * Gives a response to a user statement
	 *
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.indexOf("no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if (statement.indexOf("cat") >= 0
				|| statement.indexOf("dog") >= 0
				|| statement.indexOf("fish") >= 0
				|| statement.indexOf("bird") >= 0)
		{
			response = "Tell me more about your pet.";
		}
		else if (statement.indexOf("Mykolyk") >= 0)
		{
			response = "He sounds like a good teacher.";
		}
		else if (statement.equals(""))
		{
			response = "Say something, please.";
		}
		else if (statement.indexOf("abc") >= 0)
		{
			response = "abcdefghijklmnopqrstuvwxyz";
		}
		else if (statement.indexOf("hola") >= 0)
		{
			response = "que paso?";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		else if (whichResponse == 4)
		{
			response = "*laughs*";
		}
		else if (whichResponse == 5)
		{
			response = "kekw";
		}

		return response;
	}
}

/*
Qs and As:
- To prioritize a response in the reply method, put it earlier in the chain of else ifs in getResponse.
- Statements that include a keyword within another word will reply with the message corresponding to that keyword anyway.
*/
