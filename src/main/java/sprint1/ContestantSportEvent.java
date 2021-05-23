package sprint1;

public class ContestantSportEvent {
	private String sportEvent;
	private Double score;
	private Double result;
	
	public ContestantSportEvent(String sportEvent, Double result, Double score) {
		this.sportEvent = sportEvent;
		this.score = score;
		this.result = result;
	}
	
	public Double getResult() {
		return result;
	}

	public String getSportEvent() {
		return sportEvent;
	}

	public Double getScore() {
		return score;
	}

	@Override
	public String toString() {
		return sportEvent + ": score=" + score + ", result=" + result + "; ";
	}
	
	
}
