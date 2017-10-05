import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lab04_RecursiveFactorial {

	public static void main(String[] args) throws IOException {

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(bfr.readLine());

		bfr.close();

		Long factorial = recursiveFactorial(num);
		System.out.println(factorial);

	}

	private static Long recursiveFactorial(int num) {

		if (num <= 1) {
			return 1L;
		}

		return num * recursiveFactorial(num - 1);
		
	}

}
