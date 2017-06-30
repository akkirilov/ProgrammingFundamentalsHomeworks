import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		StringBuffer sb = new StringBuffer(scanner.nextLine());
		scanner.close();
		
		System.out.println(sb.reverse());
		
	}

}
