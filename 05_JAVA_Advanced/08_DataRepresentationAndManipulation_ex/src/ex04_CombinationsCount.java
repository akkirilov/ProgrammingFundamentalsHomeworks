import java.util.Scanner;

public class ex04_CombinationsCount {
	
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);

        Integer n = Integer.parseInt(scanner.nextLine());
        Integer k = Integer.parseInt(scanner.nextLine());

        scanner.close();
        
        Long x = binomial(n, k);
        System.out.println(x);
        
    }

    private static long binomial(int n, int k) {
    	
        if (k > n - k) {
            k = n - k;
        }
        
        long b = 1;
        for (int i = 1, m = n; i <= k; i++, m--) {
            b = b * m / i;
        }
        
        return b;
        
    }
    
}
