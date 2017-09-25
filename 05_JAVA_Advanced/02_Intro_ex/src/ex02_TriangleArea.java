import java.util.Scanner;

public class ex02_TriangleArea {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Integer pointAX = scanner.nextInt();
		Integer pointAY = scanner.nextInt();
		
		Integer pointBX = scanner.nextInt();
		Integer pointBY = scanner.nextInt();
		
		Integer pointCX = scanner.nextInt();
		Integer pointCY = scanner.nextInt();
		
		scanner.close();
		
		Integer area = Math.abs(((pointAX * (pointBY - pointCY))
						+ (pointBX * (pointCY - pointAY)) 
						+ (pointCX * (pointAY - pointBY))) / 2);
		
		System.out.println(area);
		
	}

}
