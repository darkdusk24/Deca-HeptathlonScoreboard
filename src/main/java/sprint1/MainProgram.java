package sprint1;

//import java.io.*;
import java.util.*;
import java.util.List;
import java.util.Scanner;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class MainProgram {

	private static Scanner scan = new Scanner(System.in);
	private static PasswordHandler pass = new PasswordHandler();
	private static List<Contestant> scoreboard = new ArrayList<>();
	private static String[] decathlonEvents = { "100 m", "Long jump", "Shot put", "High jump", "400 m", "110 m hurdles",
			"Discus throw", "Pole vault", "Javelin throw", "1500 m" };
	private static String[] heptathlonEvents = { "100 m hurdles", "High jump", "Shot put", "200 m", "Long jump",
			"Javelin throw", "800 m" };
	private static ScoreCalculator calc = new ScoreCalculator();
	private static MainEventType mainEvent = MainEventType.HEPTATHLON;
	private static Excel excel = new Excel("Deca-HeptathlonScoreboard");
	
	//Creating an instance is not allowed, so constructor is private
	private MainProgram() {
		throw new UnsupportedOperationException("This class cannot be instantiated");		   
	}

	public static void main(String[] args) {
		//logIn();
		mainEventInput();
		contestantInput();
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
			System.out.println("Default Main Event is " + mainEvent.eventName 
			+ ". Type 1 to keep, 2 for Decathlon");
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
	}

	private static void contestantInput() {
		int amountOfContestants = 0;

		while (true) {
			if (amountOfContestants < 40) {
				System.out.println("Input the contestants name. Or input Exit to stop inputting contestants.");
				String name = scan.nextLine();

				if (name.equalsIgnoreCase("exit")) {
					break;
				}

				System.out.println("Input the contestants countrys alpha-3 code.");
				String country = scan.nextLine();

				System.out.println("Input the contestants number.");
				int number = Integer.valueOf(scan.nextLine());

				Contestant contestant = new Contestant(name, number, country);
				scoreboard.add(contestant);
				

				if (mainEvent.eventName.equalsIgnoreCase("Decathlon")) {
					excel.decaContestantRegistration(contestant);
				} else if (mainEvent.eventName.equalsIgnoreCase("Heptathlon")) {
					excel.heptaContestantRegistration(contestant);
				}
			} else {
				break;
			}

			amountOfContestants++;
		}

	}

	private static void resultInput() {
		System.out.println(
				"The result should be measured in seconds (running), metres (throwing) or centimetres (jumping). \n");
		if (mainEvent == MainEventType.DECATHLON) {
			for (int i = 0; i < decathlonEvents.length; i++) {
				for (int j = 0; j < scoreboard.size(); j++) {
					System.out.println("Input the result " + scoreboard.get(j).getName() + " got on the " + decathlonEvents[i]
							+ " event. Or write exit to stop the program.");

					String input = scan.nextLine();

					if (input.equalsIgnoreCase("exit")) {
						i = 15;
						break;
					} else {
						double result = Double.valueOf(input);
						int score = calc.eventScoreCalculation(mainEvent.eventName, decathlonEvents[i], result);
						scoreboard.get(j).addSportEvent(decathlonEvents[i], score, result);
						excel.setDecaContestantEventResultAndScore(scoreboard.get(j), decathlonEvents[i]);
						excel.printContestantTotalScore(scoreboard.get(j), mainEvent.eventName);
					}
				}
				Collections.sort(scoreboard);
				excel.printContestantPlacing(scoreboard, mainEvent);
				inputScoreboardChoice();
			}
		} else if (mainEvent == MainEventType.HEPTATHLON) {
			for (int i = 0; i < heptathlonEvents.length; i++) {
				for (int j = 0; j < scoreboard.size(); j++) {
					System.out.println("Input the result " + scoreboard.get(j).getName() + " got on the "
							+ heptathlonEvents[i] + " event. Or write exit to stop the program.");

					String input = scan.nextLine();

					if (input.equalsIgnoreCase("exit")) {
						i = 15;
						break;
					} else {
						double result = Double.valueOf(input);
						int score = calc.eventScoreCalculation(mainEvent.eventName, heptathlonEvents[i], result);
						scoreboard.get(j).addSportEvent(heptathlonEvents[i], score, result);
						excel.setHeptaContestantEventResultAndScore(scoreboard.get(j), heptathlonEvents[i]);
						excel.printContestantTotalScore(scoreboard.get(j), mainEvent.eventName);
					}
				}//for int = j
				//Sort here
				Collections.sort(scoreboard);
				excel.printContestantPlacing(scoreboard, mainEvent);
				inputScoreboardChoice();
			}//for int = i
		}
	}

	private static void inputScoreboardChoice() {
		System.out.println("Input scoreboard if you want to see the scores. "
				+ "Input anything else to continue.");
		String choice = scan.nextLine();
		if (choice.equalsIgnoreCase("scoreboard")) {
			ConsoleOutput.printResultTable(scoreboard);	
		}
	}

	public static MainEventType getMainEvent() {
		return mainEvent;
	}

	public static String[] getDecathlonEvents() {
		return decathlonEvents;
	}

	public static String[] getHeptathlonEvents() {
		return heptathlonEvents;
	}

	public static ScoreCalculator getScoreCalculator() {
		return calc;
	}
}