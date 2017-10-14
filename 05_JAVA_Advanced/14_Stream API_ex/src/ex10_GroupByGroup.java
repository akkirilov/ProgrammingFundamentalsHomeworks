import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ex10_GroupByGroup {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		List<Person> persons = new LinkedList<>();
		
		String[] tokens = reader.readLine().split("\\s+");
		while (!tokens[0].equals("END")) {
			
			Person person = new Person();
			person.setName(tokens[0] + " " + tokens[1]);
			person.setGroup(tokens[2]);
			
			persons.add(person);
			
			tokens = reader.readLine().split("\\s+");
		}
		
		reader.close();

		persons.
				stream()
				.collect(Collectors.groupingBy(Person::getGroup))
				.entrySet()
				.stream()
				.forEach(a -> {
					List<String> listP = new LinkedList<>();
					for (Person p : a.getValue()) {
						listP.add(p.getName());
					}
					System.out.println(a.getKey() + " - " + listP.toString().replaceAll("\\[|\\]", ""));
				});
	}

}
