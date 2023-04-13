package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String, Integer> database = new HashMap<>();
		database.put("Ethan", 67);
		database.put("Danny", 77);
		database.put("Nathan", 70);
		database.put("Andy", 70);
		database.put("Emily", 64);
		
		int count = 0;
		while (count==0) {
			System.out.println("Who's height are you looking for?");
			String name = in.next();
			if (name.equalsIgnoreCase("quit")) {
				count++;
			}
			else if (database.get(name) == null) {
				System.out.println("Sorry, this person doesn't exist in this database.");
			}
			else {
				System.out.println(name + "'s height is " + database.get(name) + " inches.");
			}
		}

	}
}
