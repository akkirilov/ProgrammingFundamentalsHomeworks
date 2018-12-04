import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Internship {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		Integer problemsCount = Integer.parseInt(scr.nextLine());
		Integer candidatesCount = Integer.parseInt(scr.nextLine());
		Deque<String> problems = new ArrayDeque<>();
		Deque<String> candidates = new ArrayDeque<>();
		for (int i = 0; i < problemsCount; i++) {
			problems.push(scr.nextLine());
		}
		Pattern pattern = Pattern.compile("[A-Z][a-z]+ [A-Z][a-z]+");
		for (int i = 0; i < candidatesCount; i++) {
			String line = scr.nextLine();
			Matcher matcher = pattern.matcher(line);
			if(matcher.find()) {
				candidates.push(line);
			}
		}
		while(true) {
			if(candidates.size() == 1) {
				System.out.println(candidates.removeLast() + " gets the job!");
				break;
			} else if(problems.size() == 0) {
				Internship.printCandidates(candidates);
				break;
			}
			
			String candidate = candidates.removeLast();
			String problem = problems.removeFirst();
			Integer candidateSum = Internship.sumOfASCI(candidate);
			Integer problemSum = Internship.sumOfASCI(problem);

			if(candidateSum >= problemSum) {
				System.out.println(candidate + " solved " + problem + ".");
				candidates.addFirst(candidate);
			} else {
				System.out.println(candidate + " failed " + problem + ".");
				problems.addLast(problem);
			}
		}
		scr.close();
	}
	
	private static Integer sumOfASCI(String str) {
		Integer sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += str.charAt(i);
		}
		return sum;
	}
	
	private static void printCandidates(Deque<String> candidates) {
		while(true) {
			if(candidates.size() > 1) {
				System.out.print(candidates.removeLast() + ", ");
			} else {
				System.out.print(candidates.removeLast());
				break;
			}
		}
	}

}
