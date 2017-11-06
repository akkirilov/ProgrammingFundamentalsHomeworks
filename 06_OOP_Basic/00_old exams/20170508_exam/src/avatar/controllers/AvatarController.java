package avatar.controllers;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

import avatar.entities.Nation;
import avatar.entities.benders.Bender;
import avatar.entities.monuments.Monument;
import avatar.factories.*;
import avatar.io.ConsoleOutputWriter;

public class AvatarController {
	
	private Map<String, Nation> nations;
	private List<String> wars;
	private ConsoleOutputWriter consoleOutputWriter;
	private BenderFactory benderFactory;
	private MonumentFactory monumentFactory;
	
	public AvatarController() {
		super();
		this.nations = new LinkedHashMap<>();
		this.initalizeNations();
		this.benderFactory = new BenderFactory();
		this.monumentFactory = new MonumentFactory();
		this.consoleOutputWriter = new ConsoleOutputWriter();
		this.wars = new ArrayList<>();
	}
	
	private void initalizeNations() {
		this.nations.put("Air", new Nation());
		this.nations.put("Fire", new Nation());
		this.nations.put("Earth", new Nation());
		this.nations.put("Water", new Nation());
	}

	public void createBender(String type, String name, int power, double secondaryParameter) {
		Bender bender = benderFactory.create(type, name, power, secondaryParameter);
		this.nations.get(type).addBender(bender);
	}
	
	public void createMonument(String type, String name, int affinity) {
		Monument monument = monumentFactory.create(type, name, affinity);
		this.nations.get(type).addMonuments(monument);
	}
	
	public void status(String nation) {
		consoleOutputWriter.writeLine(nation + " Nation");
		consoleOutputWriter.write(nations.get(nation).toString());
	}
	
	public void war(String nation) {
		nations = nations.entrySet()
                .stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue().countTotalPower(), e1.getValue().countTotalPower()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x1, x2) -> {throw new AssertionError();},
                        LinkedHashMap::new
                ));
		int count = 0;
		for (Map.Entry<String, Nation> entry : nations.entrySet()) {
			if (count != 0) {
				entry.getValue().loseWar();
			}
			count++;
		}
		wars.add(nation);
	}
	
	public void quit() {
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for (String w : wars) {
			sb.append("War ").append(count++).append(" issued by ").append(w).append("\r\n");
		}
		consoleOutputWriter.writeLine(sb.toString());
	}
		
}
