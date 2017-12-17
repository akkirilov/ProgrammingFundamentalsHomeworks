package app;
import java.util.List;

import app.commands.CommandExecutor;
import app.commands.groups.GroupAttackCommand;
import app.commands.groups.GroupTargetCommand;
import app.commands.individuals.AttackCommand;
import app.commands.individuals.TargetCommand;
import app.interfaces.AttackGroup;
import app.interfaces.Attacker;
import app.interfaces.Command;
import app.interfaces.Executor;
import app.interfaces.Handler;
import app.interfaces.Target;
import app.loggers.CombatLogger;
import app.loggers.EventLogger;
import app.mediators.Group;
import app.models.Dragon;
import app.models.Warrior;

public class Main {
	
	public static void main(String[] args) {
		
		Handler combatLogger = new CombatLogger();
		Handler eventLogger = new EventLogger();
		
		combatLogger.setSuccessor(eventLogger);
		
		Target target = new Dragon("dragon", 29, 5, combatLogger);
		
		Attacker attacker0 = new Warrior("Pesho", 10, combatLogger);
		Attacker attacker1 = new Warrior("Gosho", 10, combatLogger);
		Attacker attacker2 = new Warrior("Stamat", 10, combatLogger);
		
		Executor executor = new CommandExecutor();
		
		AttackGroup group = new Group();
		group.addMember(attacker0);
		group.addMember(attacker1);
		group.addMember(attacker2);
		
		Command groupTargetCommand = new GroupTargetCommand(group, target);
		Command groupAttackCommand = new GroupAttackCommand(group);
		
		executor.executeCommand(groupTargetCommand);
		executor.executeCommand(groupAttackCommand);
		
	}

}
