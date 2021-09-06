package sprint1;

import java.util.*;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

	private static Scanner scan = new Scanner(System.in);
	private static PasswordHandler pass = new PasswordHandler();
	public static List<Contestant> scoreboard = new ArrayList<>();
	private static String[] decathlon = { "100 m", "Long jump", "Shot put", "High jump", "400 m", "110 m hurdles",
			"Discus throw", "Pole vault", "Javelin throw", "1500 m" };
	private static String[] heptathlon = { "100 m hurdles", "High jump", "Shot put", "200 m", "Long jump",
			"Javelin throw", "800 m" };
	private static ScoreCalculator calc = new ScoreCalculator();
	private static MainEventType mainEvent = MainEventType.HEPTATHLON;
	private static boolean contin = false;
	private static boolean scoreboardAsk = true;
	private static Excel excel;

	public static void main(String[] args) {
		logIn();
		mainEventInput();
		if (contin == false) {
			contestantInput();
		}
		resultInput();
	}

	private static void logIn() {
		while (true) {
			System.out.println("Input the password.");
			String password = scan.nextLine();

			if (pass.passwordCheck(password)) {
				break;
			} else {
				System.out.println("Wrong password");
			}
		}
	}

	private static void mainEventInput() {
		while (true) {
			System.out.println("Type 1 to create a new contest. Type 2 to continue an old contest.");
			int choice = Integer.valueOf(scan.nextLine());

			if (choice == 2) {
				contin = true;
			}

			System.out.println("Default Main Event is " + mainEvent.eventName + ". Type 1 to keep, 2 for Decathlon");
			String eventSelection = scan.nextLine();

			if (eventSelection.matches("1|h")) {
				break;
			}
			if (eventSelection.matches("2|d")) {
				mainEvent = MainEventType.DECATHLON;
				System.out.println("Main Event is now " + mainEvent.eventName);
				break;
			} else {
				System.out.println("Please type 1 for Heptahlon, 2 for Decathlon");
			}
		}

		excel = new Excel("Deca-HeptathlonScoreboard", contin);
		if (contin == true) {
			scoreboard = excel.continuingEvent(mainEvent.eventName);
			System.out.println(scoreboard.get(0).getName());
		}
	}

	private static void contestantInput() {
		int contestants = 0;
		while (true) {
			if (contestants < 40) {
				System.out.println("Input the contestants name. Or input Exit to stop inputting contestants.");
				String name = String.valueOf(scan.nextLine());

				if (name.equalsIgnoreCase("Exit")) {
					break;
				}

				System.out.println("Input the contestants countrys alpha-3 code.");
				String country = scan.nextLine();

				System.out.println("Input the contestants number.");
				int number = Integer.valueOf(scan.nextLine());

				Contestant competitor = new Contestant(name, number, country);
				scoreboard.add(competitor);

				if (mainEvent.eventName.equalsIgnoreCase("Decathlon")) {
					excel.decaContestantRegistration(competitor);
				} else if (mainEvent.eventName.equalsIgnoreCase("Heptathlon")) {
					excel.heptaContestantRegistration(competitor);
				}
			} else {
				break;
			}

			contestants++;
		}

	}

	private static void resultInput() {
		Boolean error;
		System.out.println(
				"The result should be measured in seconds (running), metres (throwing) or centimetres (jumping). \n");
		if (contin == false) {
			if (mainEvent.eventName.equalsIgnoreCase("Decathlon")) {
				for (int i = 0; i < decathlon.length; i++) {
					for (int j = 0; j < scoreboard.size(); j++) {
						error = false;
						System.out.println("Input the result " + scoreboard.get(j).getName() + " got on the "
								+ decathlon[i] + " event. Or write exit to stop the program.");

						String input = scan.nextLine();

						if (input.equalsIgnoreCase("Exit")) {
							i = 15;
							scoreboardAsk = false;
							break;
						} else {
							try {
								double result = Double.valueOf(input);
								int score = calc.eventScoreCalculation("Decathlon", decathlon[i], result);
								scoreboard.get(j).addSportEvent(decathlon[i], score, result);
								excel.setDecaContestantEventResultAndScore(scoreboard.get(j), decathlon[i]);
								excel.setContestantsTotalScore(scoreboard.get(j), "Decathlon");
							} catch (Exception e) {
								System.out.println(
										"\n **Incorrect input** \nThe result should be measured in seconds (running), metres (throwing) or centimetres (jumping). \n");
								j -= 1;
								error = true;
							}
						}

						if (error == false && scoreboardAsk == true) {
							System.out.println(
									"Input scoreboard if you want to see the scores. Input anything else to continue.");
							String choice = scan.nextLine();
							if (choice.equalsIgnoreCase("Scoreboard")) {
								ConsoleOutput.printResultTable(scoreboard);
							}
						}
					}
				}
			} else if (mainEvent.eventName.equalsIgnoreCase("Heptathlon")) {
				for (int i = 0; i < heptathlon.length; i++) {
					for (int j = 0; j < scoreboard.size(); j++) {
						error = false;
						System.out.println("Input the result " + scoreboard.get(j).getName() + " got on the "
								+ heptathlon[i] + " event. Or write exit to stop the program.");

						String input = scan.nextLine();

						if (input.equalsIgnoreCase("Exit")) {
							i = 15;
							scoreboardAsk = false;
							break;
						} else {
							try {
								double result = Double.valueOf(input);
								int score = calc.eventScoreCalculation("Heptathlon", heptathlon[i], result);
								scoreboard.get(j).addSportEvent(heptathlon[i], score, result);
								excel.setHeptaContestantEventResultAndScore(scoreboard.get(j), heptathlon[i]);
								excel.setContestantsTotalScore(scoreboard.get(j), "Heptathlon");
							} catch (Exception e) {
								System.out.println(
										"\n **Incorrect input** \nThe result should be measured in seconds (running), metres (throwing) or centimetres (jumping). \n");
								j -= 1;
								error = true;

							}

						}
						if (error == false && scoreboardAsk == true) {
							System.out.println(
									"Input scoreboard if you want to see the scores. Input anything else to continue.");
							String choice = scan.nextLine();
							if (choice.equalsIgnoreCase("Scoreboard")) {
								ConsoleOutput.printResultTable(scoreboard);
							}
						}
					}
				}
			} else if (contin == true) {
				int eventContinue = eventToContinueFrom();
				int contestantContinue = contestantToContinueFrom();

				if (mainEvent.eventName.equalsIgnoreCase("Decathlon")) {
					for (int i = eventContinue; i < decathlon.length; i++) {
						for (int j = contestantContinue; j < scoreboard.size(); j++) {
							error = false;
							System.out.println("Input the result " + scoreboard.get(j).getName() + " got on the "
									+ decathlon[i] + " event. Or write exit to stop the program.");

							String input = scan.nextLine();

							if (input.equalsIgnoreCase("Exit")) {
								i = 15;
								scoreboardAsk = false;
								break;
							} else {
								try {
									double result = Double.valueOf(input);
									int score = calc.eventScoreCalculation("Decathlon", decathlon[i], result);
									scoreboard.get(j).addSportEvent(decathlon[i], score, result);
									excel.setDecaContestantEventResultAndScore(scoreboard.get(j), decathlon[i]);
									excel.setContestantsTotalScore(scoreboard.get(j), "Decathlon");
								} catch (Exception e) {
									System.out.println(
											"\n **Incorrect input** \nThe result should be measured in seconds (running), metres (throwing) or centimetres (jumping). \n");
									j -= 1;
									error = true;

								}
							}

							if (error == false && scoreboardAsk == true) {
								System.out.println(
										"Input scoreboard if you want to see the scores. Input anything else to continue.");
								String choice = scan.nextLine();
								if (choice.equalsIgnoreCase("Scoreboard")) {
									ConsoleOutput.printResultTable(scoreboard);
								}
							}
						}
						contestantContinue = 0;
					}
				} else if (mainEvent.eventName.equalsIgnoreCase("Heptathlon")) {
					for (int i = eventContinue; i < heptathlon.length; i++) {
						for (int j = contestantContinue; j < scoreboard.size(); j++) {
							error = false;
							System.out.println("Input the result " + scoreboard.get(j).getName() + " got on the "
									+ heptathlon[i] + " event. Or write exit to stop the program.");

							String input = scan.nextLine();

							if (input.equalsIgnoreCase("Exit")) {
								i = 15;
								scoreboardAsk = false;
								break;
							} else {
								try {
									double result = Double.valueOf(input);
									int score = calc.eventScoreCalculation("Heptathlon", heptathlon[i], result);
									scoreboard.get(j).addSportEvent(heptathlon[i], score, result);
									excel.setHeptaContestantEventResultAndScore(scoreboard.get(j), heptathlon[i]);
									excel.setContestantsTotalScore(scoreboard.get(j), "Heptathlon");
								} catch (Exception e) {
									System.out.println(
											"\n **Incorrect input** \nThe result should be measured in seconds (running), metres (throwing) or centimetres (jumping). \n");
									j -= 1;
									error = true;

								}
							}

							if (error == false && scoreboardAsk == true) {
								System.out.println(
										"Input scoreboard if you want to see the scores. Input anything else to continue.");
								String choice = scan.nextLine();
								if (choice.equalsIgnoreCase("Scoreboard")) {
									ConsoleOutput.printResultTable(scoreboard);
								}
							}
						}
						contestantContinue = 0;
					}
				}
			}
		}
	}

	private static int eventToContinueFrom() {
		int nextEvent = 20;

		for (int i = 0; i < scoreboard.size(); i++) {

			int completedEvents = scoreboard.get(i).getSportEvents().size();

			if (completedEvents < nextEvent) {
				nextEvent = completedEvents;
			}
		}

		return nextEvent;
	}

	private static int contestantToContinueFrom() {
		int nextContestant = 0;
		int completedEvents = 20;
		for (int i = 0; i < scoreboard.size(); i++) {
			int contestantsCompletedEvents = scoreboard.get(i).getSportEvents().size();

			if (contestantsCompletedEvents < completedEvents) {
				completedEvents = contestantsCompletedEvents;
				nextContestant = i;
			}
		}

		return nextContestant;
	}
}