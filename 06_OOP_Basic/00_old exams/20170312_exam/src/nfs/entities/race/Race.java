package nfs.entities.race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import nfs.entities.car.Car;

public abstract class Race {
	
	private int length;
	private String route;
	private int prizePool;
	private Map<Integer, Car> participants;
	private List<Car> winners;
	
	public Race(int length, String route, int prizePool) {
		super();
		setLength(length);
		setRoute(route);
		setPrizePool(prizePool);
		this.participants = new LinkedHashMap<>();
		this.winners = new ArrayList<>();
	}
	
	protected int countPrize(int place) {
		switch (place) {
		case 1:
			return (this.getPrizePool() * 50) / 100;
		case 2:
			return (this.getPrizePool() * 30) / 100;
		case 3:
			return (this.getPrizePool() * 20) / 100;
		default:
			return 0;
		}
	}
	
	public void addWinner(Car winner) {
		this.winners.add(winner);
	}

	private int getLength() {
		return this.length;
	}

	private void setLength(int length) {
		this.length = length;
	}

	private String getRoute() {
		return this.route;
	}

	private void setRoute(String route) {
		this.route = route;
	}

	protected int getPrizePool() {
		return this.prizePool;
	}

	private void setPrizePool(int prizePool) {
		this.prizePool = prizePool;
	}

	public Map<Integer, Car> getParticipants() {
		return Collections.unmodifiableMap(this.participants);
	}

	public void addParticipant(Integer id, Car participant) {
		this.participants.put(id, participant);
	}

	protected abstract String getWinners();

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getRoute()).append(" - ").append(this.getLength()).append("\r\n");
		return sb.toString();
	}

}
