package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;

import java.util.List;
import java.util.stream.Collectors;

public class BossFight implements Action {
	
	private Targetable boss;

    @Override
    public String executeAction(List<Targetable> participants) {
    	if (participants.size() <= 1) {
    		return "There should be at least 1 participant for boss fight!";
		}
    	this.findBoss(participants);
    	StringBuilder sb = new StringBuilder();
    	boolean fightOver = false;
    	while (true) {
			for (int i = 0; i < participants.size(); i++) {
				Targetable hero = participants.get(i);
				hero.attack(boss);
				if (boss.isAlive()) {
					boss.attack(hero);
					if (!hero.isAlive()) {
						participants.remove(i);
						i--;
						boss.receiveReward(hero.getGold());
						boss.levelUp();
					}
				} else {
					hero.receiveReward(boss.getGold());
//					hero.levelUp();
					sb.append("Boss has been slain by: " + System.lineSeparator());
					sb.append(this.getOrderedHeroes(participants));
					fightOver = true;
					break;
				} 
			}
			
			if (fightOver) {
				break;
			}
		}
//    	if (!boss.isAlive()) {
//		} else {
//			sb.append("Boss has slain them all!");
//		}
    	if (this.boss.isAlive()) {
    		sb.append(System.lineSeparator());
			sb.append("Boss has slain them all!");
		}
        return sb.toString();
    }

	private Object getOrderedHeroes(List<Targetable> participants) {
		StringBuilder sb = new StringBuilder();
		
		for (Targetable p : participants) {
			p.levelUp();
			boss.giveReward(p);
		}
		List<Targetable> ordered = participants.stream()
				.sorted((a, b) -> a.getName().compareTo(b.getName()))
				.collect(Collectors.toList());
		for (int i = 0; i < ordered.size(); i++) {
			Targetable h = ordered.get(i);
//			h.levelUp();
//			boss.giveReward(h);
			sb.append(h);
			if (i < participants.size() - 1) {
				sb.append(System.lineSeparator());
			}
		}
		return sb.toString();
	}

	private void findBoss(List<Targetable> participants) {
		this.boss = participants.remove(0);
	}
	
}
