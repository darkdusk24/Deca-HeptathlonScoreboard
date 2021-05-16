package sprint1;

import java.util.List;

public class ConsoleOutput {

	public static void printResultTable(List<Contestant> contestants) {
		System.out.println("###########################################################");
		System.out.println("###############          RESULT TABLE         #############");
		System.out.println("###########################################################");
		// should be added sort by total score after merging issue 27
		for (int i = 0; i < contestants.size(); i++) {
			System.out.println((i + 1) + ". " + contestants.get(i).toString()); // print place + Contestant details
		}
		System.out.println("###########################################################");
	}
}
