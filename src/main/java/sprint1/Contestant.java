package sprint1;

import java.util.ArrayList;
import java.util.List;

public class Contestant implements Comparable<Contestant> {

	private String name;
	private int number;
	private String country;
	private List<ContestantSportEvent> sportEvents = new ArrayList<>();
	
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
	
	@Override
	public String toString() {
		String scores = "";
		int totalScore = 0;
		for (ContestantSportEvent sportEvent : getSportEvents()) {
			scores += sportEvent.toString();
			totalScore = MainProgram.getScoreCalculator().totalScoreCalculation(sportEvents);
		}
		return name + "(" + number + ") " + country + ": " + scores + " Total Score: " + totalScore;
	}

	@Override
	public int compareTo(Contestant c) {
		return (getTotalScore() < c.getTotalScore() ? 1 : (getTotalScore() == c.getTotalScore() ? 0 : -1));
	}
  
}
