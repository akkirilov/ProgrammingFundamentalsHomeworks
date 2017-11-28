package p04_Froggy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String[] tokens = scanner.nextLine().split("\\s+");
		while (!tokens[0].equals("END")) {

			Integer[] nums = new Integer[tokens.length];
			for (int i = 0; i < tokens.length; i++) {
				nums[i] = Integer.parseInt(tokens[i].replaceAll(",", ""));
			}

			Lake lake = new Lake(nums);
			StringBuilder sb = new StringBuilder();
			for (Integer i : lake) {
				sb.append(i + ", ");
			}

			System.out.println(sb.toString().substring(0, sb.length() - 2));
			tokens = scanner.nextLine().split("\\s+");
		}
		scanner.close();
	}

}
