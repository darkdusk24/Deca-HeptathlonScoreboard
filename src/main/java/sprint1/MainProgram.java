package sprint1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

	private static Scanner scan = new Scanner(System.in);
	private static PasswordHandler pass = new PasswordHandler();
	private static List<Contestant> scoreboard = new ArrayList<>();

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

}
