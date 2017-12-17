package app.mediators;

import java.util.ArrayList;
import java.util.List;

import app.interfaces.AttackGroup;
import app.interfaces.Attacker;
import app.interfaces.Target;

public class Group implements AttackGroup {
	
	private List<Attacker> attackers;

	public Group() {
		this.attackers = new ArrayList<>();
	}

	@Override
	public void addMember(Attacker attacker) {
		this.attackers.add(attacker);
	}

	@Override
	public List<Attacker> getAttackers() {
		return this.attackers;
	}
	
	@Override
	public void groupTarget(Target target) {
		for (Attacker attacker : attackers) {
			attacker.setTarget(target);
		}
	}

	@Override
	public void groupAttack() {
		for (Attacker attacker : attackers) {
			attacker.attack();
		}
	}

}
