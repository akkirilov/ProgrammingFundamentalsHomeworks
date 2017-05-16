import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MirrorNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		List<Integer> numbers = new ArrayList<>();
		
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			numbers.add(scanner.nextInt());
		}
		
		numbers = numbers.stream().distinct().collect(Collectors.toList());
		
		String num1Str = "";
		String num2Str = "";
				
		for (int i = 0; i < numbers.size(); i++) {
			num1Str = numbers.get(i).toString();
			
			for (int j = i + 1; j < numbers.size(); j++) {
				num2Str = new StringBuffer(numbers.get(j).toString()).reverse().toString();
												
				if (isMirrorNums(num1Str, num2Str)) {
					System.out.printf("%s<!>%s%n", num1Str, numbers.get(j).toString());
					break;
				}
			}
		}
	}

	private static boolean isMirrorNums(String num1Str, String num2Str) {
		if (num1Str.length() != num2Str.length()) {
			return false;
		}
		
		for (int i = 0; i < num1Str.length(); i++) {
			if (num1Str.charAt(i) != num2Str.charAt(i)) {
				return false;
			}
		}
		
		return true;
	}
}