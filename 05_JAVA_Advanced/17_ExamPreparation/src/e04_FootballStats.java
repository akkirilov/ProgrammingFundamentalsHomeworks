import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class e04_FootballStats {

	public static void main(String[] args) throws IOException {
		
		String[] nextTokens;
		String[] scoreTokens;
		String team;
		String oponentAndResult;
		LinkedList<String> temp;
		LinkedHashMap<String, LinkedList<String>> stats = new LinkedHashMap<>();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = reader.readLine().split("\\s+-\\s+");
		while (!tokens[0].equals("Season End")) {
			
			team = tokens[0];
			oponentAndResult = tokens[1].replace("result", "->");
			if (stats.containsKey(team)) {
				temp = stats.get(team);
			} else {
				temp = new LinkedList<>();
			}
			temp.add(oponentAndResult);
			stats.put(team, temp);
			
			nextTokens = tokens[1].split("\\s+");
			team = nextTokens[0];
			scoreTokens = nextTokens[2].split(":");
			oponentAndResult = tokens[0] + " -> " + scoreTokens[1] + ":" + scoreTokens[0];
			if (stats.containsKey(team)) {
				temp = stats.get(team);
			} else {
				temp = new LinkedList<>();
			}
			temp.add(oponentAndResult);
			stats.put(team, temp);
			
			tokens = reader.readLine().split("\\s+-\\s+");
			
		}
		
		List<String> collection = Arrays.stream(reader.readLine().split(",\\s+"))
				.collect(Collectors.toList());
		
		reader.close();
		
		for (String key : collection) {
			
			if (!stats.containsKey(key)) {
				continue;
			}
			stats.get(key).stream()
					.sorted((a, b) ->  {
						return a.substring(0, a.length() - 7)
								.compareTo(b.substring(0, b.length() - 7));
					})
					.forEach(m -> {
						System.out.println(key + " - " + m);
					});
			
		}
		
	}

}
