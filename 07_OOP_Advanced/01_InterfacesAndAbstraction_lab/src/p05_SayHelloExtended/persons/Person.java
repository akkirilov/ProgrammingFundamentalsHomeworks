package p05_SayHelloExtended.persons;

public interface Person {
	
	String getName();
	
	default void sayHello() { System.out.println("Hello");}
	
}
