package sprint1;


public class CompetitorsScore {
	
	private Competitor competitor;
	private String sportsEvent;
	private Double score;
	

	public CompetitorsScore(String name) {
		competitor = new Competitor(name);
	}

	public void updateName(String name) {
		this.competitor.setName(name);
	}
	
	public void setSportsEvent(String sportsEvent) {
		this.sportsEvent = sportsEvent;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getName() {
		return competitor.getName();
	}
	
	public String getSportsEvent() {
		return sportsEvent;
	}

	public Double getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		String objectData = getName() + ", ";
		objectData +=  getSportsEvent() + ", ";
		objectData += getScore();
		return objectData;
	}
	
}
