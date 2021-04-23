package sprint1;

public class ScoreCalculator {
	
	public int OneHundredMeters(double performance) {
		int score = (int) (25.4347 * Math.pow((18 - performance), 1.81));
		
		return score;
	}
}
