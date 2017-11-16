package p05_SayHelloExtended.persons;

public class Bulgarian extends BasePerson implements Person {

	public Bulgarian(String name) {
		super(name);
	}

	@Override
	public void sayHello() {
		System.out.println("Здравей");
	}
	
}
