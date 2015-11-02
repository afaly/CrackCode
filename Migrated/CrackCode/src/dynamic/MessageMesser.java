package dynamic;

/*
 * TopCoder Single Round Match: 149 Division: 1 Level: 2 Points: 500
 * Description: http://community.topcoder.com/stat?c=problem_statement&pm=1331
 */

public class MessageMesser {

	public String restore(String[] dictionary, String message) {

		/*
		 * Holds the number of ways the message can be recreated up to a given
		 * point. numOfSolutions[0] = 1, represents the one starting state.
		 * numOfSolutions[x] is the number of ways the substring beginning with
		 * the first x characters of the message can be reached.
		 */
		int[] numOfSolutions = new int[message.length() + 1];
		numOfSolutions[0] = 1;

		/*
		 * Holds the restored string from the message recreated up to a given
		 * point. If no solutions exists to get to that character x, then
		 * solutions[x] holds IMPOSSIBLE!. If two or more solutions are found
		 * that lead to character x, then solutions[x] holds "AMBIGUOUS!".
		 */
		String[] solutions = new String[message.length() + 1];

		// Initialize the array.
		solutions[0] = "";
		for (int i = 1; i < solutions.length; i++) {
			solutions[i] = "IMPOSSIBLE!";
		}

		// Loop through each position in the message.
		for (int position = 0; position < message.length(); position++) {

			// Only process if positon can be reached once unambiguously.
			if (numOfSolutions[position] == 1) {

				for (String word : dictionary) {

					// The size the message would be if word were tacked on.
					int newSize = position + word.length();

					/*
					 * If adding this dictionary word to our current position
					 * would take us beyond the length of the message; or, the
					 * dictionary word does not match the next sequence in the
					 * message, then skip it.
					 */
					if ((newSize <= message.length())
							&& (word.equals(message
									.substring(position, newSize)))) {

						/*
						 * Set the number of ways to reach the new size to
						 * either 1 or 2 - depending on if it was 0 or 1 before.
						 * If it's now 2, mark it as ambiguous.
						 */

						if (numOfSolutions[newSize] == 0) {
							numOfSolutions[newSize] = 1;
							solutions[newSize] = solutions[position] + " "
									+ word;
						} else {
							numOfSolutions[newSize] = 2;
							solutions[newSize] = "AMBIGUOUS!";
						}
					}
				}
			}
		}

		return solutions[solutions.length - 1].trim();
	}
}