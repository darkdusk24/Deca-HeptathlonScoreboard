package sprint1;

public class ScoreCalculator {

	public int eventScoreCalculation(String combinedEvent, String event, double result) {
		int score = 0;

		switch (event) {
		case "100 m":
			score = (int) (25.4347 * Math.pow((18 - result), 1.81));
			break;
		case "Long jump":
			if (combinedEvent.equalsIgnoreCase("Decathlon")) {
				score = (int) (0.14354 * Math.pow((result - 220), 1.4));
			} else if (combinedEvent.equalsIgnoreCase("Heptathlon")) {
				score = (int) (0.188807 * Math.pow((result - 210), 1.41));
			}
			break;
		case "Shot put":
			if (combinedEvent.equalsIgnoreCase("Decathlon")) {
				score = (int) (51.39 * Math.pow((result - 1.5), 1.05));
			} else if (combinedEvent.equalsIgnoreCase("Heptathlon")) {
				score = (int) (56.0211 * Math.pow((result - 1.5), 1.05));
			}
			break;
		case "High jump":
			if (combinedEvent.equalsIgnoreCase("Decathlon")) {
				score = (int) (0.8465 * Math.pow((result - 75.0), 1.42));
			} else if (combinedEvent.equalsIgnoreCase("Heptathlon")) {
				score = (int) (1.84523 * Math.pow((result - 75.0), 1.348));
			}
			break;
		case "400 m":
			score = (int) (1.53775 * Math.pow((82.0 - result), 1.81));
			break;
		case "110 m hurdles":
			score = (int) (5.74352 * Math.pow((28.5 - result), 1.92));
			break;
		case "Discus throw":
			score = (int) (12.91 * Math.pow((result - 4.0), 1.1));
			break;
		case "Pole vault":
			score = (int) (0.2797 * Math.pow((result - 100.0), 1.35));
			break;
		case "Javelin throw":
			if (combinedEvent.equalsIgnoreCase("Decathlon")) {
				score = (int) (10.14 * Math.pow((result - 7.0), 1.08));
			} else if (combinedEvent.equalsIgnoreCase("Heptathlon")) {
				score = (int) (15.9803 * Math.pow((result - 3.8), 1.04));
			}
			break;
		case "1500 m":
			score = (int) (0.03768 * Math.pow((480.0 - result), 1.85));
			break;
		case "200 m":
			score = (int) (4.99087 * Math.pow((42.5 - result), 1.81));
			break;
		case "800 m":
			score = (int) (0.11193 * Math.pow((254.0 - result), 1.88));
			break;
		case "100 m hurdles":
			score = (int) (9.23076 * Math.pow((26.7 - result), 1.835));
			break;
		}

		return score;
	}
	
	public int totalScoreCalculation(int[] scores) {
		int totalScore = 0;
		
		for(int i = 0; i < scores.length; i++) {
			totalScore += scores[i];
		}
		
		return totalScore;
	}
}
