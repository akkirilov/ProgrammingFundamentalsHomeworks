package p02_Blob.core;

import java.util.Map;

import p02_Blob.factories.AttackFactory;
import p02_Blob.factories.BehaviorFactory;
import p02_Blob.interfaces.Attack;
import p02_Blob.interfaces.Behavior;
import p02_Blob.models.Blob;

public class BlobController {

	private Map<String, Blob> blobs;

	public BlobController(Map<String, Blob> blobs) {
		this.blobs = blobs;
	}

	public String create(String name, int health, int damage, String behaviorType, String attackType) {
		if (!blobs.containsKey(name)) {
			Behavior behavior = BehaviorFactory.create(behaviorType);
			if (behavior == null) {
				return "ERROR: can't create Behavior of type " + behaviorType + "!";
			}
			Attack attack = AttackFactory.create(attackType);
			if (attack == null) {
				return "ERROR: can't create Attack of type " + attackType + "!";
			}
			Blob blob = new Blob(name, health, damage, behavior, attack);
			blobs.put(name, blob);
		}
		return "Blob " + name + " was created!";
	}

	public String attack(String attackerName, String targetName) {
		if (blobs.containsKey(attackerName) && blobs.containsKey(targetName)) {
			blobs.get(attackerName).attack(blobs.get(targetName));
			if (blobs.get(targetName).getHealth() <= 0) {
				return "Blob " + targetName + " was killed";
			}
			if (blobs.get(targetName).getBehavior().isTriggered()) {
				return "Blob " + targetName + " toggled " + blobs.get(targetName).getBehavior().getClass().getSimpleName() + "Behavior";
			}
			return null;
		}
		return "ERROR: incorect Blob name!";
	}

	public String pass() {
		this.makeTurn();
		return "Turn passed!";
	}

	public String status() {
		String res = this.getBlobsStatus();
		this.makeTurn();
		return res;
	}

	private String getBlobsStatus() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Blob> blob : this.blobs.entrySet()) {
			sb.append(blob.getValue()).append(System.lineSeparator());
		}
		return sb.toString();
	}

	private void makeTurn() {
		for (Map.Entry<String, Blob> blob : this.blobs.entrySet()) {
			blob.getValue().makeTurn();
		}
	}

}
