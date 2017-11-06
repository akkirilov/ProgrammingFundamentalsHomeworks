package nfs.entities.race;

import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import nfs.entities.car.Car;

public class TimeLimitRace extends Race {

	private int goldTime;

	public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
		super(length, route, prizePool);
		setGoldTime(goldTime);
	}

	private int getGoldTime() {
		return goldTime;
	}

	private void setGoldTime(int goldTime) {
		this.goldTime = goldTime;
	}

	@Override
	public String getWinners() {
		
		List<Entry<Integer, Car>> cars = super.getParticipants().entrySet().stream().limit(1).collect(Collectors.toList());
		Car car = cars.get(0).getValue();
		StringBuilder sb = new StringBuilder();
		int prize = 0;
		int performance = super.getLength() * car.getTimePerformance();
		String time;

		if (performance <= this.getGoldTime()) {
			prize = super.getPrizePool();
			time = "Gold Time";
		} else if (performance <= this.getGoldTime() + 15) {
			prize = (int) ((this.getPrizePool() * 50) / 100);
			time = "Silver Time";
		} else {
			prize = (int) ((this.getPrizePool() * 30) / 100);
			time = "Bronze Time";
		}

		sb.append(car.getBrand()).append(" ").append(car.getModel()).append(" - ")
				.append(performance).append(" s.\r\n").append(time).append(", $").append(prize).append(".\r\n");

		return sb.toString();

	}

	@Override
	public void addParticipant(Integer id, Car participant) {
		if (super.getParticipants().size() <= 1) {
			super.addParticipant(id, participant);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append(this.getWinners());
		return sb.toString();
	}

}
