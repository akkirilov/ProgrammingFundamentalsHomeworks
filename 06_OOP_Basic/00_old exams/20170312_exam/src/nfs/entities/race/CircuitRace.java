package nfs.entities.race;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import nfs.entities.car.Car;

public class CircuitRace extends Race {
	
	private int laps;

	public CircuitRace(int length, String route, int prizePool, int laps) {
		super(length * laps, route, prizePool);
		setLaps(laps);
	}

	private int getLaps() {
		return laps;
	}

	private void setLaps(int laps) {
		this.laps = laps;
	}

	@Override
	public String getWinners() {
		
		int decreaseParam = ((super.getLength() / laps) * (super.getLength() / laps)) * this.getLaps();
		for (Map.Entry<Integer, Car> entry : super.getParticipants().entrySet()) {
			entry.getValue().decreaseDurability(decreaseParam);
		}
		
		int count = 1;
		StringBuilder sb = new StringBuilder();
		LinkedHashMap<Integer, Car> orderedParticipants = super.getParticipants().entrySet().stream()
				.sorted((e1, e2) -> Integer.compare(e2.getValue().getOverallPerformance(),
						e1.getValue().getOverallPerformance()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x1, x2) -> {
					throw new AssertionError();
				}, LinkedHashMap::new));
		for (Map.Entry<Integer, Car> entry : orderedParticipants.entrySet()) {
			if (count == 5) {
				break;
			}

			sb.append(count).append(". ").append(entry.getValue().getBrand()).append(" ")
					.append(entry.getValue().getModel()).append(" ").append(entry.getValue().getOverallPerformance())
					.append("PP - $").append(this.countPrize(count)).append("\r\n");

			count++;
		}
		return sb.toString();

	}

	@Override
	protected int countPrize(int place) {
		switch (place) {
		case 1:
			return (this.getPrizePool() * 40) / 100;
		case 2:
			return (this.getPrizePool() * 30) / 100;
		case 3:
			return (this.getPrizePool() * 20) / 100;
		case 4:
			return (this.getPrizePool() * 10) / 100;
		default:
			return 0;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append(this.getWinners());
		return sb.toString();
	}
}
