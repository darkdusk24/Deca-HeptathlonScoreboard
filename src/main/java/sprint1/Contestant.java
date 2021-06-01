package sprint1;

import java.util.ArrayList;
import java.util.List;

public class Contestant {

	private String name;
	private int number;
	private int place;
	private String country;
	private List<ContestantSportEvent> sportEvents = new ArrayList<>();
	private ScoreCalculator calc = new ScoreCalculator();
	
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

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	@Override
	public String toString() {
		String scores = "";
		int totalScore = 0;
		for (ContestantSportEvent sportEvent : getSportEvents()) {
			scores += sportEvent.toString();
			totalScore = calc.totalScoreCalculation(sportEvents);
		}
		return name + "(" + number + ") " + country + ": " + scores + " Total Score: " + totalScore;
	}
  
}
