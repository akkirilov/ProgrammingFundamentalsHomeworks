import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class ex01_ConsumerPrint {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] consumer = bfr.readLine().split("\\s+");
		bfr.close();
		
		Consumer<String> consumerPrint = x -> System.out.println(x);
		for (int i = 0; i < consumer.length; i++) {
			consumerPrint.accept(consumer[i]);
		}
		
	}

}
