package p08_PetClinics.entities;

public class Room {
	
	private Pet pet;

	public Room() {   }

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	public boolean isEmpty() {
		return pet == null;
	}

	@Override
	public String toString() {
		return pet.toString();
	}
	
	

}
