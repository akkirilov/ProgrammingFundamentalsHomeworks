import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static Person person = new Person();
	private static List<String> input = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String info = reader.readLine();
		createPerson(info);
		
		info = reader.readLine();
		while (!info.equals("End")) {
			input.add(info);
			info = reader.readLine();
		}
		
		reader.close();

		String[] tokens;
		for (int i = 0; i < input.size(); i++) {
			if (input.get(i).contains("-")) {
				continue;
			}
			
			tokens = input.get(i).split("\\s+");
			if (person.getBirthDate().equals(tokens[2])) {
				person.setName(tokens[0] + " " + tokens[1]);
				input.remove(i);
				break;
			} else if (person.getName().equals(tokens[0] + " " + tokens[1])) {
				person.setBirthDate(tokens[2]);
				input.remove(i);
				break;
			}
		}
		
		boolean found = true;
		while (found) {
			found = false;
			for (int i = 0; i < input.size(); i++) {
				if (!input.get(i).contains("-")) {
					continue;
				}
				tokens = input.get(i).split("\\s+-\\s+");
				if (person.getBirthDate().equals(tokens[0]) || person.getName().equals(tokens[0])) {
					Child temp = new Child();
					if (tokens[1].contains("/")) {
						temp.setBirthDate(tokens[1]);
					} else {
						temp.setName(tokens[1]);
					}
					input.remove(i);
					i--;
					person.addChild(temp);
					found = true;
					break;
				} else if (person.getBirthDate().equals(tokens[1]) || person.getName().equals(tokens[1])) {
					tokens = input.get(i).split("\\s+-\\s+");
					Parent temp = new Parent();
					if (tokens[0].contains("/")) {
						temp.setBirthDate(tokens[0]);
					} else {
						temp.setName(tokens[0]);
					}
					input.remove(i);
					i--;
					person.addParent(temp);
					found = true;
					break;
				}
			}
		}
		
		found = true;
		while (found) {
			found = false;
			for (int i = 0; i < input.size(); i++) {
				if (input.get(i).contains("-")) {
					input.remove(i);
					i--;
					found = true;
					break;
				}
				
				tokens = input.get(i).split("\\s+");
				for (Child c : person.getChildren()) {
					if (c.getName().equals(tokens[0] + " " + tokens[1])) {
						c.setBirthDate(tokens[2]);
						input.remove(i);
						i--;
						found = true;
						break;
					} else if (c.getBirthDate().equals(tokens[2])) {
						c.setName(tokens[0] + " " + tokens[1]);
						input.remove(i);
						i--;
						found = true;
						break;
					}
				}
				
				for (Parent p : person.getParents()) {
					if (p.getName().equals(tokens[0] + " " + tokens[1]) && p.getBirthDate().equals("")) {
						p.setBirthDate(tokens[2]);
						input.remove(i);
						i--;
						found = true;
						break;
					} else if (p.getBirthDate().equals(tokens[2]) && p.getName().equals("")) {
						p.setName(tokens[0] + " " + tokens[1]);
						input.remove(i);
						i--;
						found = true;
						break;
					}
				}
				
				if (found) {
					break;
				}
			}
		}
		
		System.out.println(person);
		
	}

	private static void createPerson(String info) {
		if (info.contains("/")) {
			person.setBirthDate(info);
		} else {
			person.setName(info);
		}
	}

}
