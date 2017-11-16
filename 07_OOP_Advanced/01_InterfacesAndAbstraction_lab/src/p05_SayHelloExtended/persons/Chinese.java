package p05_SayHelloExtended.persons;

public class Chinese extends BasePerson implements Person {

	public Chinese(String name) {
		super(name);
	}

	@Override
	public void sayHello() {
		System.out.println("Djydjybydjy");
	}
	
}
