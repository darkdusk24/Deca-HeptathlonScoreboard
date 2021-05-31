package sprint1;

import java.io.*;
import java.util.*;
import java.util.List;
import java.util.Scanner;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.*;

//import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class MainProgram {

	private static Scanner scan = new Scanner(System.in);
	private static PasswordHandler pass = new PasswordHandler();
	public static List<Contestant> scoreboard = new ArrayList<>();
	private static String[] decathlon = { "100 m", "Long jump", "Shot put", "High jump", "400 m", "110 m hurdles",
			"Discus throw", "Pole vault", "Javelin throw", "1500 m" };
	private static String[] heptathlon = { "100 m hurdles", "High jump", "Shot put", "200 m", "Long jump",
			"Javelin throw", "800 m" };
	public static ScoreCalculator calc = new ScoreCalculator();
	private static String mainEvent = "Decathlon";
	public static Excel excel;
	
	public static void main(String[] args) throws IOException, InvalidFormatException  {
		logIn();
		contestantInput();
		resultInput();
	//Create Excel File and the methods from excel class
	excel = new Excel("Deca-HeptathlonScoreboard");
	excel.DecaColumnA();
	excel.DecaColumnBtoC(scoreboard);
	excel.HeptaColumnA();
	excel.HeptaColumnBtoC(scoreboard);
	excel.write();
	System.out.println("Excel-file is Completed");	
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

	public static void contestantInput() {
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

				Contestant competitor = new Contestant(name, number, country);
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
						scoreboard.get(j).addSportEvent(decathlon[i], score, result);
					}
				}
				System.out.println("Input scoreboard if you want to see the scores. Input anything else to continue.");
				String choice = scan.nextLine();
				if (choice.equalsIgnoreCase("Scoreboard")) {
					ConsoleOutput.printResultTable(scoreboard);
				}
			}
		} else if (mainEvent.equalsIgnoreCase("Heptathlon")) {
			for (int i = 0; i < heptathlon.length; i++) {
				for (int j = 0; j < scoreboard.size(); j++) {
					System.out.println("Input the result " + scoreboard.get(j).getName() + " got on the "
							+ heptathlon[i] + " event. Or write exit to stop the program.");

					String input = scan.nextLine();

					if (input.equalsIgnoreCase("Exit")) {
						i = 15;
						break;
					} else {
						double result = Double.valueOf(input);
						int score = calc.eventScoreCalculation("Heptathlon", heptathlon[i], result);
						scoreboard.get(j).addSportEvent(heptathlon[i], score, result);
					}
				}
				System.out.println("Input scoreboard if you want to see the scores. Input anything else to continue.");
				String choice = scan.nextLine();
				if (choice.equalsIgnoreCase("Scoreboard")) {
					ConsoleOutput.printResultTable(scoreboard);
				}
			}
		}
	}
}			