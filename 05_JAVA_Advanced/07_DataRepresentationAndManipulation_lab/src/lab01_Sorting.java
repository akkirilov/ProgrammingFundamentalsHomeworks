import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class lab01_Sorting {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
		int[] seqArr = Arrays.stream(bfr.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		
		bfr.close();
		
		//bubbleSortAndPrint(seqArr);
		
		selectionSortAndPrint(seqArr);
		
	}

	private static void selectionSortAndPrint(int[] seqArr) {
		
		Integer temp;
		Integer index;
		
		for (int i = 0; i < seqArr.length - 1; i++) {
			index = i;
			for (int j = i + 1; j < seqArr.length; j++) {
				if (seqArr[j] < seqArr[index]) {
					index = j;
				}
			}
				temp = seqArr[i];
				seqArr[i] = seqArr[index];
				seqArr[index] = temp;
			
		}
		
		printArr(seqArr);
		
	}

	private static void bubbleSortAndPrint(int[] seqArr) {
		
		Integer temp;
		Boolean swaped;
		
		do {
			swaped = false;
			for (int i = 0; i < seqArr.length - 1; i++) {
				if (seqArr[i] > seqArr[i + 1]) {
					temp = seqArr[i];
					seqArr[i] = seqArr[i + 1];
					seqArr[i + 1] = temp;
					swaped = true;
				}
			}
		} while (swaped);
		
		printArr(seqArr);
		
	}

	private static void printArr(int[] seqArr) {
		
		System.out.println(Arrays.toString(seqArr)
                .replace(",","")
                .replace("]","")
                .replace("[",""));

	}

}
