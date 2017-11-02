package nfs.entities.race;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import nfs.entities.car.Car;

public class DriftRace extends Race {

	public DriftRace(int length, String route, int prizePool) {
		super(length, route, prizePool);
	}

	@Override
	public String getWinners() {
		int count = 1;
		StringBuilder sb = new StringBuilder();
		LinkedHashMap<Integer, Car> orderedParticipants = super.getParticipants().entrySet().stream()
				.sorted((e1, e2) -> Integer.compare(e2.getValue().getSuspensionPerformance(),
						e1.getValue().getSuspensionPerformance()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x1, x2) -> {
					throw new AssertionError();
				}, LinkedHashMap::new));
		for (Map.Entry<Integer, Car> entry : orderedParticipants.entrySet()) {
			if (count == 4) {
				break;
			}

			sb.append(count).append(". ").append(entry.getValue().getBrand()).append(" ")
					.append(entry.getValue().getModel()).append(" ").append(entry.getValue().getSuspensionPerformance())
					.append("PP - $").append(super.countPrize(count)).append("\r\n");

			count++;
		}
		return sb.toString();

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append(this.getWinners());
		return sb.toString();
	}
}
