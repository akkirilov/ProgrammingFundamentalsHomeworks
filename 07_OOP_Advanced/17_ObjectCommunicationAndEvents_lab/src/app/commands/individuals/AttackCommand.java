package app.commands.individuals;

import app.interfaces.Attacker;
import app.interfaces.Command;

public class AttackCommand implements Command {
	
	private Attacker attacker;
	
	public AttackCommand(Attacker attacker) {
		this.attacker = attacker;
	}

	@Override
	public void execute() {
		this.attacker.attack();
	}
	
}
