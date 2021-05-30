package sprint1;

public class ContestantSportEvent {
	private String sportEvent;
	private int score;
	private Double result;
	
	public ContestantSportEvent(String sportEvent, Double result, int score) {
		super();
		this.sportEvent = sportEvent;
		this.score = score;
		this.result = result;
	}
	
	public ContestantSportEvent() {
		super();
	}

	public Double getResult() {
		return result;
	}

	public String getSportEvent() {
		return sportEvent;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return sportEvent + ": score=" + score + ", result=" + result + "; ";
	}
}