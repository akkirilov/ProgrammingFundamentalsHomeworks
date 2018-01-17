package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;

import java.util.List;

public class OneVsOne implements Action {

    public String executeAction(List<Targetable> participants) {

    	if (participants.size() != 2) {
			return "There should be exactly 2 participants for OneVsOne!";
		}
    	
        StringBuilder sb = new StringBuilder();
        Targetable firstHero = participants.get(0);
        Targetable secondHero = participants.get(1);

        while (true){
            sb.append(firstHero.attack(secondHero))
            		.append(System.lineSeparator());
            if (secondHero.isAlive()) {
                sb.append(secondHero.attack(firstHero))
                		.append(System.lineSeparator());
                if (!firstHero.isAlive()) {
                	secondHero.receiveReward(firstHero.getGold());
                	secondHero.levelUp();
                	sb.append(String.format("%s is victorious!%s%s", secondHero.getName(), System.lineSeparator(),secondHero.toString()));
//                	secondHero.receiveReward(firstHero.getGold());
//                	secondHero.levelUp();
                	break;
				}
            } else {
            	firstHero.receiveReward(secondHero.getGold());
            	firstHero.levelUp();
            	sb.append(String.format("%s is victorious!%s%s", firstHero.getName(), System.lineSeparator(),firstHero.toString()));
                break;
            }
        }

        return sb.toString();
    }
}
