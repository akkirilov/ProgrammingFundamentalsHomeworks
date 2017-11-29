package p08_PetClinics.entities;

public interface Clinic extends Iterable<Room>{
	
	boolean release();
	
	boolean hasEmptyRooms();
	
	boolean addPet(Pet pet);
	
	void printClinic();
	
	void printRoom(Integer index);

}
