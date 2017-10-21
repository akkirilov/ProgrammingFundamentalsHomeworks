import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class e01_JediMeditation {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringBuilder sbInput = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sbInput.append(reader.readLine() + " ");
		}
		reader.close();
		
		String[] jedis = sbInput.toString().split("\\s+");
		StringBuilder sb = new StringBuilder();
		
		boolean isMasterJodaHere = false;
		for (int i = 0; i < jedis.length; i++) {
			if (jedis[i].charAt(0) == 'y') {
				isMasterJodaHere = true;
			}
		}
		if (!isMasterJodaHere) {
			for (int i = 0; i < jedis.length; i++) {
				if (jedis[i].charAt(0) == 't' || jedis[i].charAt(0) == 's') {
					sb.append(jedis[i] + " ");
				}
			}
		}
		for (int i = 0; i < jedis.length; i++) {
			if (jedis[i].charAt(0) == 'm') {
				sb.append(jedis[i] + " ");
			}
		}
		for (int i = 0; i < jedis.length; i++) {
			if (jedis[i].charAt(0) == 'k') {
				sb.append(jedis[i] + " ");
			}
		}
		if (isMasterJodaHere) {
			for (int i = 0; i < jedis.length; i++) {
				if (jedis[i].charAt(0) == 't' || jedis[i].charAt(0) == 's') {
					sb.append(jedis[i] + " ");
				}
			}
		}
		for (int i = 0; i < jedis.length; i++) {
			if (jedis[i].charAt(0) == 'p') {
				sb.append(jedis[i] + " ");
			}
		}
		
		System.out.println(sb.toString());
		
	}

}
