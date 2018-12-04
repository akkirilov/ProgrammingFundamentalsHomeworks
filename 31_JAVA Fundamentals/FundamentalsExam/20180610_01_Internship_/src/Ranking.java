import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ranking {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		List<Contest> contests = new ArrayList<>();
		List<User> users = new ArrayList<>();
		
		String line = scr.nextLine();
		while (!line.equals("end of contests")) {
			String[] lineArr = line.split(":");
			if (lineArr.length == 2) {
				contests.add(new Contest(lineArr[0], lineArr[1]));
			}
			
			line = scr.nextLine();
		}
		
		line = scr.nextLine();
		Integer index = -1;
		while (!line.equals("end of submissions")) {
			String[] lineArr = line.split("=>");
			if (lineArr.length == 4) {
				Contest curContest = new Contest(lineArr[0], lineArr[1]);
				if(contests.contains(curContest)) {
					User curUser = new User(lineArr[2]);
					Integer points = Integer.parseInt(lineArr[3]);
					index = users.indexOf(curUser);
					if(index!= null && index >= 0) {
						if(users.get(index).hasContest(curContest.getName()) 
								&& users.get(index).getContestPoints(curContest.getName()) < points) {
							users.get(index).addPoints(curContest.getName(), points);
						} else if(!users.get(index).hasContest(curContest.getName())) {
							users.get(index).addContest(curContest.getName(), points);
						}
					} else {
						curUser.addContest(curContest.getName(), points);
						users.add(curUser);
					}
				}
			}
			
			line = scr.nextLine();
		}
		
		User winner = users.get(0);
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getPoints() > winner.getPoints()) {
				winner = users.get(i);
			}
		}
		
		users.stream().forEach(x->{
			x.sortContests();
		});
		users = users.stream().sorted((a,b)->{
			return a.getName().compareTo(b.getName());
		}).collect(Collectors.toList());
		
		System.out.println("Best candidate is "+winner.getName()+" with total "+winner.getPoints()+" points.");
		System.out.println("Ranking: ");
		for (User user : users) {
			System.out.println(user.getName());
			user.printContests();
		}

		scr.close();

	}

}
