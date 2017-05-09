import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int health = 5800;
		int glowcaps = 0;
		
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		
		while(!line.equals("Sporeggar")){
			for(int i = 0; i < line.length(); i++){
				if(i == line.length() - 1){
					glowcaps += Integer.parseInt(line.charAt(i) + "");
				}
				else if(line.charAt(i) != 'L'){
					health -= line.charAt(i);
					
					if(health <= 0){
						System.out.printf("Died. Glowcaps: %d%n", glowcaps);
						return;
					}
				}
				else{
					health += 200;
				}
			}
			
			line = scanner.nextLine();
		}
				
		System.out.printf("Health left: %d%n", health);
		if(glowcaps >= 30){
			System.out.printf("Bought the sporebat. Glowcaps left: %d%n", glowcaps - 30);
		}
		else{
			System.out.printf("Safe in Sporeggar, but another %d Glowcaps needed.%n", 30 - glowcaps);
		}
	}
}