import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MagicSum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int divider = Integer.parseInt(scanner.nextLine());
		
		List<Integer> numbers = new ArrayList<>();
		
		String token = scanner.nextLine();
		while (!token.equals("End")) {
			numbers.add(Integer.parseInt(token));
			
			token = scanner.nextLine();
		}
		
		int sum = Integer.MIN_VALUE;
		String result = "";
		
		for (int i = 0; i < numbers.size(); i++) {
			for (int j = i + 1; j < numbers.size(); j++) {
				for (int k = j + 1; k < numbers.size(); k++) {
					if ((numbers.get(i) + numbers.get(j) + numbers.get(k)) % divider == 0 
							&& (numbers.get(i) + numbers.get(j) + numbers.get(k)) > sum) {
						
						sum = numbers.get(i) + numbers.get(j) + numbers.get(k);
						
						result = String.format("(%d + %d + %d) %% %d = 0", 
								numbers.get(i), numbers.get(j), numbers.get(k), divider);
					} 
				}
			}
		}
		
		if (result.equals("")) {
			System.out.println("No");
		}
		else {
			System.out.println(result);			
		}
	}
}