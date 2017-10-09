import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lab06_AcademyGraduation {

	public static void main(String[] args) throws IOException {
		
		Map<String, double[]> studentsData = new HashMap<>();
				
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		Integer n = Integer.parseInt(bfr.readLine());
		for (int i = 0; i < n; i++) {
			studentsData.put(bfr.readLine(), Arrays.stream(bfr.readLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray());
		}
		
		bfr.close();
		
		for (Map.Entry<String, double[]> pair : studentsData.entrySet()) {
			System.out.println(pair.getKey() + " is graduated with " + getAvarage(pair.getValue()));
		}

	}

	private static double getAvarage(double[] grades) {
		
		double sum = 0;
		int index = 0;
		
		for (; index < grades.length; index++) {
			sum += grades[index];
		}
		
		return sum / index;
		
	}

}
