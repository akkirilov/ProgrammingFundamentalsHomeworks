import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private String name;
	private String birthDate;
	private List<Parent> parents;
	private List<Child> children;
	
	public Person() {
		super();
		this.name = "";
		this.birthDate = "";
		this.parents = new ArrayList<>();
		this.children = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public List<Parent> getParents() {
		return parents;
	}

	public void addParent(Parent parent) {
		this.parents.add(parent);
	}

	public List<Child> getChildren() {
		return children;
	}

	public void addChild(Child child) {
		this.children.add(child);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(this.name + " " + this.birthDate + "%n");
		sb.append("Parents:%n");
		if (this.parents.size() > 0) {
			sb.append(parents.toString().replaceAll("\\[|\\]", "").replaceAll(", ", "\r\n") + "%n");
		}
		sb.append("Children:%n");
		if (this.children.size() > 0) {
			sb.append(children.toString().replaceAll("\\[|\\]", "").replaceAll(", ", "\r\n") + "%n");
		}
		return String.format(sb.toString());
	}
	
}
