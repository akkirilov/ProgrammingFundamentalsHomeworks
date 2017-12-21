package hell.core;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import hell.interfaces.Engine;
import hell.interfaces.InputReader;
import hell.interfaces.Manager;
import hell.interfaces.OutputWriter;
import hell.utils.Constants;

public class EngineImpl implements Engine {
	
	private InputReader reader;
	private OutputWriter writer;
	private Manager manager;
	
	public EngineImpl(InputReader reader, OutputWriter writer, Manager manager) {
		this.reader = reader;
		this.writer = writer;
		this.manager = manager;
	}

	@Override
	public void run() {
		
		while (true) {
			String input = this.reader.readLine();
			if (input.equals(Constants.TERMINATION_COMMAND)) {
				this.writer.writeLine(this.manager.quit());
				break;
			}
			
			List<String> tokens = Arrays.stream(input.split("\\s+"))
					.collect(Collectors.toList());
			switch (tokens.get(0)) {
			case Constants.REGISTER_HERO_COMMAND:
				this.writer.writeLine(this.manager.registerHero(tokens.get(1), tokens.get(2)));
				break;
			case Constants.REGISTER_ITEM_COMMAND:
				this.writer.writeLine(this.manager.registerItem(tokens.get(1), tokens.get(2), 
						Integer.parseInt(tokens.get(3)), Integer.parseInt(tokens.get(4)),
						Integer.parseInt(tokens.get(5)), Integer.parseInt(tokens.get(6)), 
						Integer.parseInt(tokens.get(7))));
				break;
			case Constants.REGISTER_RECIPE_COMMAND:
				tokens.remove(0);
				this.writer.writeLine(this.manager.registerRecipe(tokens.remove(0), tokens.remove(0), 
						Integer.parseInt(tokens.remove(0)), Integer.parseInt(tokens.remove(0)),
						Integer.parseInt(tokens.remove(0)), Integer.parseInt(tokens.remove(0)), 
						Integer.parseInt(tokens.remove(0)), tokens));
				break;
			case Constants.INSPECT_HERO_COMMAND:
				this.writer.writeLine(this.manager.inspectHero(tokens.get(1)));
				break;
			default:
				break;
			}
			
		}
		
	}

}
