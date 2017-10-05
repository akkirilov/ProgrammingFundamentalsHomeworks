import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class lab05_RecursiveDrawing {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bfr.readLine());

		bfr.close();
		
		recursiveDrawing(n);
		
	}

	private static void recursiveDrawing(int n) {
		
		if (n == 0) {
			return;
		}
		
		System.out.println(String.join("", Collections.nCopies(n, "*")));
		recursiveDrawing(n - 1);
		System.out.println(String.join("", Collections.nCopies(n, "#")));
		
	}

}
