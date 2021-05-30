package sprint1;

import java.util.List;

public class CompetitorsScore {

	private Contestant competitor;

	public CompetitorsScore() {
	}

//	public CompetitorsScore(String name) {
//		competitor = new Contestant(name);
//	}

	public void updateName(String name) {
		this.competitor.setName(name);
	}

//	public void addSportEvent(ContestantSportEvent sportEvent) {
//		this.competitor.addSportEvent(sportEvent);
//	}
//	
//	public void addSportEvent(String sportEvent, Double result, Double score) {
//		this.competitor.addSportEvent(new ContestantSportEvent(sportEvent, result, score));
//	}

	public String getName() {
		return competitor.getName();
	}

	public List<ContestantSportEvent> getSportsEvent() {
		return competitor.getSportEvents();
	}
	
	public Double getTotalScore() {
		Double totalScore = 0.0;
		for (ContestantSportEvent sportEvent : competitor.getSportEvents()) {
			totalScore += sportEvent.getScore();
		}
		return totalScore;
	}
	


	@Override
	public String toString() {
		String objectData = getName() + ", ";
		objectData += getTotalScore();
		return objectData;
	}
}