package p08_PetClinics.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClinicImpl implements Clinic, Iterable<Room> {

	private String name;
	private List<Room> roomsList;
	private RoomIterator roomIterator;

	public ClinicImpl(String name, Integer roomsCount) {
		this.name = name;
		this.setRooms(roomsCount);
		this.roomIterator = new RoomIterator();
	}

	public String getName() {
		return this.name;
	}

	private void setRooms(Integer roomsCount) {
		roomsList = new ArrayList<>();
		for (int i = 0; i < roomsCount; i++) {
			roomsList.add(new Room());
		}
	}

	@Override
	public boolean hasEmptyRooms() {
		for (int i = 0; i < roomsList.size(); i++) {
			if (roomsList.get(i).isEmpty()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean addPet(Pet pet) {
		while (this.roomIterator.hasNext()) {
			Room room = this.roomIterator.next();
			if (room.isEmpty()) {
				room.setPet(pet);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean release() {
		Integer startIndex = roomsList.size() / 2;
		boolean reachEnd = false;
		boolean result = false;
		while (true) {
			if (startIndex >= roomsList.size() / 2 && reachEnd) {
				break;
			} else if (startIndex > roomsList.size() - 1 && !reachEnd) {
				reachEnd = true;
				startIndex = 0;
			}
			if (!roomsList.get(startIndex++).isEmpty()) {
				roomsList.get(startIndex - 1).setPet(null);
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public void printClinic() {
		for (int i = 0; i < roomsList.size(); i++) {
			if (roomsList.get(i).isEmpty()) {
				System.out.println("Room empty");
			} else {
				System.out.println(roomsList.get(i));
			}
		}
	}

	@Override
	public void printRoom(Integer index) {
		index--;
		if (index < 0) {
			System.out.println("Invalid Operation!");
			return;
		} else if (roomsList.get(index).isEmpty()) {
			System.out.println("Room empty");
		} else {
			System.out.println(roomsList.get(index));
		}
	}

	@Override
	public Iterator<Room> iterator() {
		return new RoomIterator();
	}
	
	private final class RoomIterator implements Iterator<Room> {
		
		Integer center = roomsList.size() / 2;
		Integer addLeft = 0;
		Integer addRight = 1;
		Integer index;
		boolean toLeft = true;
		boolean start = true;
		
		private void setNextIndex() {
			if (!this.start && this.toLeft) {
				this.index = this.center - this.addLeft;
				this.addLeft++;
				this.toLeft = false;
			} else if (!this.start && !this.toLeft) {
				this.index = this.center + this.addRight;
				this.addRight++;
				this.toLeft = true;
			} else {
				this.index = this.center - this.addLeft;
				this.addLeft++;
				this.start = false;
			}
		}

		@Override
		public boolean hasNext() {
			this.setNextIndex();
			if (this.index < 0 || this.index > roomsList.size() - 1) {
				return false;
			} else {
				return true;
			}
		}

		@Override
		public Room next() {
			return roomsList.get(this.index);
		}
		
	}

}
