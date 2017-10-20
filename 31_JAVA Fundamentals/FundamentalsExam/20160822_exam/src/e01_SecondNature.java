import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class e01_SecondNature {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] flowers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		int[] buckets = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		reader.close();
		
		boolean waterEnd = false;
		List<Integer> remainingFlowers = new ArrayList<>();
		List<Integer> bloomFlowers = new ArrayList<>();
		List<Integer> remainingBuckets = new ArrayList<>();
		int bucketIndex = buckets.length - 1;
		for (int flowerIndex = 0; flowerIndex < flowers.length; flowerIndex++, bucketIndex--) {
			
			if (bucketIndex < 0) {
				for (int i = flowerIndex; i < flowers.length; i++) {
					remainingFlowers.add(flowers[i]);
				}
				waterEnd = true;
				break;
			}
			
			if (flowers[flowerIndex] < buckets[bucketIndex]) {
				if (bucketIndex == 0 && flowerIndex == flowers.length - 1) {
					buckets[bucketIndex] -= flowers[flowerIndex];
				} else if (bucketIndex == 0) {
					buckets[bucketIndex] -= flowers[flowerIndex];
					bucketIndex++;
				} else {
					buckets[bucketIndex - 1] += buckets[bucketIndex] - flowers[flowerIndex];
					buckets[bucketIndex] = Integer.MIN_VALUE;
				}
			} else if (flowers[flowerIndex] == buckets[bucketIndex]) {
				bloomFlowers.add(flowers[flowerIndex]);
				buckets[bucketIndex] = Integer.MIN_VALUE;
			} else {
				flowers[flowerIndex] -= buckets[bucketIndex];
				buckets[bucketIndex] = Integer.MIN_VALUE;
				flowerIndex--;
			}
			
		}
		
		if (waterEnd && remainingFlowers.size() > 0) {
			System.out.println(remainingFlowers.toString().replaceAll("\\[|\\]|,", ""));
		} else {
			for (int i = buckets.length - 1; i >= 0 ; i--) {
				if (buckets[i] != Integer.MIN_VALUE) {
					remainingBuckets.add(buckets[i]);
				}
			}
			if (remainingBuckets.size() > 0) {
				System.out.println(remainingBuckets.toString().replaceAll("\\[|\\]|,", ""));
			}
		}
		
		if (bloomFlowers.size() == 0) {
			System.out.println("None");
		} else {
			System.out.println(bloomFlowers.toString().replaceAll("\\[|\\]|,", ""));
		}
		
	}

}
