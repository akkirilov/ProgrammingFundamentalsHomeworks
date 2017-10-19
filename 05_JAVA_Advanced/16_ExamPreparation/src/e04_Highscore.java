import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class e04_Highscore {
	
	private static Map<String, List<String>> highscores = new LinkedHashMap<>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<String> temp;
		String[] input = reader.readLine().split("<->");
		String[] tokens;
		String winName;
		String loseName;
		Long winScore;
		Long loseScore;
		Long dif;
		while (!input[0].equals("osu!")) {
			
			tokens = input[0].split("\\s+");
			winName = tokens[1];
			winScore = Long.parseLong(tokens[0]);
			
			tokens = input[1].split("\\s+");
			loseName = tokens[0];
			loseScore = Long.parseLong(tokens[1]);
			
			if (winScore < loseScore) {
				loseScore = winScore;
				loseName = winName;
				winName = tokens[0];
				winScore = Long.parseLong(tokens[1]);
			}
			
			dif = winScore - loseScore;
			if (highscores.containsKey(loseName)) {
				temp = highscores.get(loseName);
			} else {
				temp = new ArrayList<>();
			}
			temp.add("*   " + winName + " <-> " + (dif * -1));
			highscores.put(loseName, temp);
			
			if (highscores.containsKey(winName)) {
				temp = highscores.get(winName);
			} else {
				temp = new ArrayList<>();
			}
			temp.add("*   " + loseName + " <-> " + dif);
			highscores.put(winName, temp);
			
			input = reader.readLine().split("<->");
			
		}
		
		reader.close();
		
		StringBuilder result = new StringBuilder();
		highscores.entrySet()
				.stream()
				.sorted((a, b) -> {
					return countScores(b.getValue()).compareTo(countScores(a.getValue()));
				})
				.forEach(v -> {
                    result.append(v.getKey()).append(" - (").append(countScores(v.getValue())).append(")").append("\n");
                    v.getValue().forEach(s -> result.append(s).append("\n"));
                });
		System.out.println(result);
		
	}

	private static Long countScores(List<String> value) {
		Long res = 0L;
		String[] tokens;
		for (String s : value) {
			tokens = s.split(" <-> ");
			res += Long.parseLong(tokens[1]);
		}
		return res;
	}

}
