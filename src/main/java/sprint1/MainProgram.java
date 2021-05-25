package sprint1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

	private static Scanner scan = new Scanner(System.in);
	private static PasswordHandler pass = new PasswordHandler();
	private static List<Contestant> scoreboard = new ArrayList<>();
	private static String[] decathlon = { "100 m", "Long jump", "Shot put", "High jump", "400 m", "110 m hurdles",
			"Discus throw", "Pole vault", "Javelin throw", "1500 m" };
	private static String[] heptathlon = { "100 m hurdles", "High jump", "Shot put", "200 m", "Long jump", "Javelin throw",
			"800 m" };
	private static ScoreCalculator calc = new ScoreCalculator();
	private static String mainEvent = "Heptathlon";

	public static void main(String[] args) {

		while (true) {
			System.out.println("Input the password.");
			String password = scan.nextLine();

			if (pass.passwordCheck(password)) {
				break;
			} else {
				System.out.println("Wrong password");
			}
		}

		contestantInput();
		resultInput();
	}

	private static void contestantInput() {
		int contestants = 0;

		while (true) {
			if (contestants < 40) {
				System.out.println("Input the contestants name. Or input Exit to stop inputting contestants.");
				String name = scan.nextLine();

				if (name.equalsIgnoreCase("Exit")) {
					break;
				}

				System.out.println("Input the contestants countrys alpha-3 code.");
				String country = scan.nextLine();

				System.out.println("Input the contestants number.");
				int number = Integer.valueOf(scan.nextLine());

				Contestant competitor = new Contestant(name);
				scoreboard.add(competitor);
			} else {
				break;
			}

			contestants++;
		}

	}

	private static void resultInput() {
		System.out.println(
				"The result should be measured in seconds (running), metres (throwing) or centimetres (jumping). \n");

		if (mainEvent.equalsIgnoreCase("Decathlon")) {
			for (int i = 0; i < decathlon.length; i++) {
				for (int j = 0; j < scoreboard.size(); j++) {
					System.out.println("Input the result " + scoreboard.get(j).getName() + " got on the " + decathlon[i]
							+ " event. Or write exit to stop the program.");

					String input = scan.nextLine();

					if (input.equalsIgnoreCase("Exit")) {
						i = 15;
						break;
					} else {
						double result = Double.valueOf(input);
						int score = calc.eventScoreCalculation("Decathlon", decathlon[i], result);
						System.out.println(score);
					}
				}
			}
		} else if (mainEvent.equalsIgnoreCase("Heptathlon")) {
			for (int i = 0; i < heptathlon.length; i++) {
				for (int j = 0; j < scoreboard.size(); j++) {
					System.out.println("Input the result " + scoreboard.get(j).getName() + " got on the " + heptathlon[i]
							+ " event. Or write exit to stop the program.");

					String input = scan.nextLine();

					if (input.equalsIgnoreCase("Exit")) {
						i = 15;
						break;
					} else {
						double result = Double.valueOf(input);
						int score = calc.eventScoreCalculation("Heptathlon", heptathlon[i], result);
						System.out.println(score);
					}
				}
			}
		}
	}

}
