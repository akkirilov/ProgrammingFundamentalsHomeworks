import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		
		List<Person> persons = new ArrayList<>();
		
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader reader = new BufferedReader(isr);

	    int n = Integer.parseInt(reader.readLine());
	    for (int i = 0; i < n; i++) {
			String[] tokens = reader.readLine().split("\\s+");
			Person temp = new Person(tokens[0], Integer.parseInt(tokens[1]));
			persons.add(temp);
		}
	    
	    reader.close();
	    
	    persons.stream()
	    .filter(x -> x.getAge() > 30)
	    		.sorted((a, b) -> a.getName().compareTo(b.getName()))
	    		.forEach(x -> {
	    			System.out.printf("%s - %d%n", x.getName(), x.getAge());
	    		});

	}

}
