package sprint1;

import java.util.List;

public class ConsoleOutput {

	public static void printResultTable(List<Contestant> contestants) {
		System.out.println("###########################################################");
		System.out.println("###############          RESULT TABLE         #############");
		System.out.println("###########################################################");
		for (int i = 0; i < contestants.size(); i++) {
			System.out.println(contestants.get(i).toString()); // Contestant details
		}
		System.out.println("###########################################################");
	}
}
