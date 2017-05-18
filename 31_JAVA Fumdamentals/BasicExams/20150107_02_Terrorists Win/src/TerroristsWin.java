import java.util.Scanner;

public class TerroristsWin {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] field = scanner.nextLine().toCharArray();
		
		int bombIndex;
		int bombPower;
		String bomb = "";
		StringBuilder bombScanner = new StringBuilder();
		for (int i = 0; i < field.length; i++) {
			if (field[i] == '|') {
				bombPower = 0;
				bombIndex = i + 1;
				while (field[bombIndex] != '|') {
					bombScanner.append(field[bombIndex]);
					bombIndex++;
				}
				
				bomb = bombScanner.toString();
				bombScanner.setLength(0);
				for (int b = 0; b < bomb.length(); b++) {
					bombPower += bomb.charAt(b);
				}
				
				bombPower %= 10;
				for (int b = Math.max((i - bombPower), 0); b < Math.min((bombIndex + bombPower + 1), field.length); b++) {
					field[b] = '.';
				}
				
				i += bomb.length() + bombPower + 1;
			}
		}
		
		System.out.println(bombScanner.append(field).toString());
	}
}