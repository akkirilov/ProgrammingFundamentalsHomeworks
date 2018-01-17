package app.core;

import app.contracts.Action;
import app.contracts.ActionFactory;
import app.contracts.Battlefield;
import app.contracts.Targetable;
import app.contracts.TargetableFactory;
import app.contracts.Writer;
import app.io.ConsoleWriter;
import app.models.actions.OneVsOne;
import app.models.participants.Warrior;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BattlefieldImplementation implements Battlefield {

    private Map<String, Targetable> participants;
    private List<Action> executedActions;
    private Writer writer;
    private TargetableFactory targetableFactory;
    private ActionFactory actionFactory;

    public BattlefieldImplementation(Writer writer, TargetableFactory targetableFactory
    		, ActionFactory actionFactory) {
        this.executedActions = new ArrayList<>();
        this.participants = new TreeMap<>();
        this.writer = writer;
        this.targetableFactory = targetableFactory;
        this.actionFactory = actionFactory;
    }

    @Override
    public void createAction(String actionName, String... participantNames) {
    	Action action = null;
		try {
			action = this.actionFactory.create(actionName, participantNames);
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException
				| InvocationTargetException e) {
		}
    	if (action == null) {
			this.writer.writeLine("Action does not exist.");
		}
    	List<Targetable> targetables = new ArrayList<>();
    	for (String targetable : participantNames) {
			if (participants.containsKey(targetable)) {
				targetables.add(participants.get(targetable));
			} else {
				 this.writer.writeLine(String.format("%s is not on the battlefield. %s failed.", targetable, actionName));
//                 return;
			}
		}
    	this.writer.writeLine(action.executeAction(targetables));
    	checkForDeadParticipants();
        this.executedActions.add(action);
//    	this.writer.writeLine(text);
//        try {
//            Action actgion = new OneVsOne();
//
//            List<Targetable> actionParticipants = new ArrayList<>();
//            for (String name : participantNames){
//                if (this.participants.containsKey(name)){
//                    actionParticipants.add(this.participants.get(name));
//                } else {
//                   
//                }
//            }
//
//            System.out.println(action.executeAction(actionParticipants));
//            checkForDeadParticipants();
//            this.executedActions.add(action);
//        } catch (Exception e) {
//            System.out.println("Action does not exist.");
//        }
    }

    @Override
    public void createParticipant(String name, String className) {

        if (this.participants.containsKey(name)){
        	this.writer.writeLine("Participant with that name already exists.");
            return;
        }

        Targetable targetable = null;
		try {
			targetable = this.targetableFactory.create(name, className);
			this.participants.put(targetable.getName(), targetable);
			this.writer.writeLine(
                    String.format("%s %s entered the battlefield.",
                            targetable.getClass().getSimpleName(),
                            targetable.getName()));
		} catch (NullPointerException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException
				| InvocationTargetException e) {
//			this.writer.writeLine("Participant class does not exist.");
		}
		if (targetable == null) {
			this.writer.writeLine("Participant class does not exist.");
		}
		
    }

    @Override
    public void createSpecial(String name, String specialName) {
//        throw new UnsupportedOperationException();
    }

    @Override
    public void reportParticipants(){
        if (this.participants.size() < 1) {
        	this.writer.writeLine("There are no participants on the battlefield.");
            return;
        }

        for (String name : this.participants.keySet()) {
        	this.writer.writeLine(this.participants.get(name).toString());
        	this.writer.writeLine("* * * * * * * * * * * * * * * * * * * *");
        }
    }

    @Override
    public void reportActions(){
        if (this.executedActions.size() < 1) {
        	this.writer.writeLine("There are no actions on the battlefield.");
            return;
        }

        for (Action executedAction : executedActions) {
        	this.writer.writeLine(executedAction.getClass().getSimpleName());
        }
    }

    private void checkForDeadParticipants(){
        Map<String, Targetable> aliveParticipants = new TreeMap<>();

        for (String name : this.participants.keySet()) {
            if (!this.participants.get(name).isAlive()){
            	this.writer.writeLine(String.format("%s has been removed from the battlefield.", name));
            }else {
                aliveParticipants.put(name, this.participants.get(name));
            }
        }

        this.participants = aliveParticipants;
    }
}
