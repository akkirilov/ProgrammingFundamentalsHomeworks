package p02_services.models;

import p02_services.interfaces.Sender;

public class ConsoleSender implements Sender {

	@Override
	public void send(String string) {
		System.out.println(string);
	}

}
