import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;



public class MostFrequentNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
				.mapToInt(Integer::parseInt).toArray();
		scanner.close();
		
		Map<Integer, Integer> nums = new LinkedHashMap<>();
		
		for (int i = 0; i < arr.length; i++) {
			if (nums.containsKey(arr[i])) {
				nums.put(arr[i], nums.get(arr[i]) + 1);
			} else {
				nums.put(arr[i], 1);
			}
		}
		
		int num = arr[0];
		int maxCount = 0;
		for (Entry<Integer, Integer> entry : nums.entrySet()) {
			if (entry.getValue() > maxCount) {
				num = entry.getKey();
				maxCount = entry.getValue();
			}
		}
		
		System.out.println(num);
		
	}

}
