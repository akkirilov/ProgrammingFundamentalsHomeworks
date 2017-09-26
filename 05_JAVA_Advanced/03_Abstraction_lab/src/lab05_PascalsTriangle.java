import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lab05_PascalsTriangle {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Integer n = scanner.nextInt();
		
		scanner.close();

		if (n == 1) {
			System.out.println(1);
			return;
		}
		
		List<List<BigInteger>> triangle = new ArrayList<>();
		List<BigInteger> temp = new ArrayList<>();
		temp.add(BigInteger.ONE);
		triangle.add(temp);
		temp = new ArrayList<BigInteger>();
		temp.add(BigInteger.ONE);
		temp.add(BigInteger.ONE);
		triangle.add(temp);
		for (int i = 2; i < n; i++) {
			temp = new ArrayList<BigInteger>();
			temp.add(BigInteger.ONE);
			for (int j = 0; j < i-1; j++) {
				temp.add(triangle.get(i - 1).get(j).add(triangle.get(i - 1).get(j + 1)));
			}
			temp.add(BigInteger.ONE);
			triangle.add(temp);
		}
		
		for (int i = 0; i < triangle.size(); i++) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				System.out.print(triangle.get(i).get(j) + " ");
			}
			System.out.println();
		}
		
	}

}
