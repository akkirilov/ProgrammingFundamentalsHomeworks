import java.util.Scanner;

public class ex11_GameOfNames {

	public static void main(String[] args) {
		
Scanner scanner = new Scanner(System.in);

		Integer n = scanner.nextInt();
		
		Integer winScore = Integer.MIN_VALUE;
		String winName = "";
		
		for (int i = 0; i < n; i++) {
			
			String tempName = scanner.next();
			Integer tempScore = scanner.nextInt();
			
			for (int j = 0; j < tempName.length(); j++) {
				if (tempName.charAt(j) % 2 == 0) {
					tempScore += tempName.charAt(j);
				} else {
					tempScore -= tempName.charAt(j);
				}
			}
			
			if (tempScore > winScore) {
				winScore = tempScore;
				winName = tempName;
			}
			
		}
		
		scanner.close();
		
		System.out.printf("The winner is %s - %d points%n", winName, winScore);
		
	}

}
