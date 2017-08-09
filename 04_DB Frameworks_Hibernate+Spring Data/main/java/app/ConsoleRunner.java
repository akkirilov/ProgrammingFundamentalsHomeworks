package app;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.config.*;
import app.services.api.*;
import app.domain.entities.*;
import app.utils.*;
import app.domain.enums.*;

@Component
public class ConsoleRunner implements CommandLineRunner{
    
	private static final Random random = new Random();
	
	private EntService entService;
	
	private JsonParser jsonParser;
	private XmlParser xmlParser;
	
	@Autowired
	public ConsoleRunner(EntService entService, 
							JsonParser jsonParser,
							XmlParser xmlParser) {
		this.entService = entService;
		this.jsonParser = jsonParser;
		this.xmlParser = xmlParser;
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
	
	private void importE() {
		
		String fileName = "";
		
	}
		
	private void exportE() {
		
		String fileName = "";
		
	}
	
}
