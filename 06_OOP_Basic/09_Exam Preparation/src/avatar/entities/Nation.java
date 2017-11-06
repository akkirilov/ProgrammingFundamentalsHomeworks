package avatar.entities;

import java.util.ArrayList;
import java.util.List;

import avatar.entities.benders.Bender;
import avatar.entities.monuments.Monument;

public class Nation {

	private List<Bender> benders;
	private List<Monument> monuments;
	
	public Nation() {
		this.benders = new ArrayList<>();
		this.monuments = new ArrayList<>();
	}

	public List<Bender> getBenders() {
		return benders;
	}

	public void addBender(Bender bender) {
		this.benders.add(bender);
	}

	public List<Monument> getMonuments() {
		return monuments;
	}

	public void addMonuments(Monument monument) {
		this.monuments.add(monument);
	}
	
	public long countTotalPower() {
		long bendersPower = 0L;
		for (Bender b : this.benders) {
			bendersPower += (b.getPower() * b.getSecondaryParameter());
		}
		
		long affinitiesPower = 0L;
		for (Monument m : this.monuments) {
			affinitiesPower += m.getAffinity();
		}
		
		return bendersPower + ((bendersPower / 100) * affinitiesPower);
	}
	
	public void loseWar() {
		this.benders = new ArrayList<>();
		this.monuments = new ArrayList<>();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Benders: ");
		if (this.benders.size() == 0) {
			sb.append("None\r\n");
		} else {
			sb.append("\r\n");
			for (Bender b : this.benders) {
				sb.append("###").append(b.toString()).append("\r\n");
			}
		}
		sb.append("Monuments: ");
		if (this.monuments.size() == 0) {
			sb.append("None\r\n");
		} else {
			sb.append("\r\n");
			for (Monument m : this.monuments) {
				sb.append("###").append(m.toString()).append("\r\n");
			}
		}
		
		return sb.toString();
	}
	
}
