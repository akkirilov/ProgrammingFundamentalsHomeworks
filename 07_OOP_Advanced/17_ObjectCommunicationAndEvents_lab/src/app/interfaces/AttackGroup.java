package app.interfaces;

import java.util.List;

public interface AttackGroup {
	
	void addMember(Attacker attacker);
	
	List<Attacker> getAttackers();
	
	void groupTarget(Target target);
	
	void groupAttack();

}
