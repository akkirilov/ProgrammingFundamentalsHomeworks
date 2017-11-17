package p08_MilitaryElite.soldiers.privates.leutenantGenerals;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import p08_MilitaryElite.soldiers.privates.Private;

public class LeutenantGeneral extends Private implements LeutenantGeneralApi {

	private List<Private> privates;

	public LeutenantGeneral(String id, String firstName, String lastName, double salary, List<Private> privates) {
		super(id, firstName, lastName, salary);
		this.privates = privates;
	}
	
	@Override
	public String getPrivates() {
		StringBuilder sb = new StringBuilder("\r\n");
		if (this.privates.size() > 0) {
            List<Private> sorted = this.privates.stream()
                    .sorted(Comparator.comparing(Private::getId).reversed())
                    .collect(Collectors.toList());
            for (Private p : sorted) {
            	sb.append("  ").append(p.toString());
            }
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return String.format("%s"
				+ "Privates:%s", super.toString(),
				this.getPrivates());
	}
	
}
