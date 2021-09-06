package sprint1;

import java.util.ArrayList;
import java.util.List;

public class Contestant implements Comparable<Contestant> {

	private String name;
	private int number;
	private int place;
	private String country;
	private List<ContestantSportEvent> sportEvents = new ArrayList<>();
	//private ScoreCalculator calc = MainProgram.getCalc();
	
	public Contestant(String name, int number, String country) {
		super();
		this.name = name;
		this.number = number;
		this.country = country;
	}

	public void setName(String string) {
		name = string;

	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public void addSportEvent(String sportEvent, int score, double result) {
		ContestantSportEvent event = new ContestantSportEvent(sportEvent, result, score);
		this.sportEvents.add(event);
	}
	
	public ContestantSportEvent getSportEvent(String event) {
		int num = 0;
		
		while(num < sportEvents.size()) {
			if(sportEvents.get(num).getSportEvent().equalsIgnoreCase(event)) {
				break;
			} else {
				num++;
			}
		}
		return sportEvents.get(num);
	}
	
	public List<ContestantSportEvent> getSportEvents() {
		return sportEvents;
	}
	
	public int getTotalScore() {
		int totalScore = 0;
		for(ContestantSportEvent event : sportEvents )
			totalScore += event.getScore();
		return totalScore;
		}	
	

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getNumber() + ": ")
		.append(getName() + " ")
		.append("(" + getCountry() + ")" +",");

		for(ContestantSportEvent event : sportEvents)
		sb.append(event.getSportEvent() + ": " + event.getScore());
		sb.append(" Total Score: " + getTotalScore());
		return sb.toString();
	}

	@Override
	public int compareTo(Contestant c) {
		return (getTotalScore() < c.getTotalScore() ? 1 : (getTotalScore() == c.getTotalScore() ? 0 : -1));
	}
  
}
