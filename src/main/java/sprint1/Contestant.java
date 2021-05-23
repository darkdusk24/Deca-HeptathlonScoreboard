package sprint1;

import java.util.ArrayList;
import java.util.List;

public class Contestant {

	private String name;
	private int number;
	private int place;
	private String country;
	private List<ContestantSportEvent> sportEvents = new ArrayList<>();

	public Contestant(String name) {
		this.name = name;
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
	
	public void addSportEvent(ContestantSportEvent sportEvent) {
		this.sportEvents.add(sportEvent);
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
		for (ContestantSportEvent sportEvent : getSportEvents()) {
			scores += sportEvent.toString();
		}
		return place + ". " + name + "(" + number + ") " + country + ": " + scores;
	}
	
	
}
