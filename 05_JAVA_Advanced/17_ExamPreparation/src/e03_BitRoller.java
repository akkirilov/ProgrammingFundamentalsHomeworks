import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class e03_BitRoller {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(reader.readLine());
		int f = 18 - Integer.parseInt(reader.readLine());
		int n = Integer.parseInt(reader.readLine());
		
		reader.close();
		
		StringBuffer sb = new StringBuffer(Integer.toBinaryString(num));
		while (sb.length() < 19) {
			sb.insert(0, "0");
		}
		
		if (f == 18) {
			for (int i = 0; i < n; i++) {
				sb.insert(0, sb.charAt(17));
				sb.deleteCharAt(18);
			}
			
			System.out.println(Integer.parseInt(sb.toString(), 2));
			return;
		}
		
		for (int i = 0; i < n; i++) {
			sb.insert(0, sb.charAt(18));
			sb.deleteCharAt(19);
			sb.insert(f, sb.charAt(f + 1));
			sb.deleteCharAt(f + 2);
		}
		
		System.out.println(Integer.parseInt(sb.toString(), 2));
		
	}

}
