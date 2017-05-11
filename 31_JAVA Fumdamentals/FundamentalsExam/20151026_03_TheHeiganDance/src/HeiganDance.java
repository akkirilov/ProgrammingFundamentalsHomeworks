import java.util.Scanner;

public class HeiganDance {

	public static void main(String[] args) {
		int[] playerPosition = {7, 7};
		int playerHealth = 18500;
		double heiganHealth = 3000000;
		
		int[][] room = new int[16][16];
		
		Scanner scanner = new Scanner(System.in);
		double playerDamage = Double.parseDouble(scanner.nextLine());
		boolean plagueCloud = false;
		
		String spell;
		int row;
		int col;
		int heiganDamage;
		
		while (true) {
			String[] lineEll = scanner.nextLine().split(" ");
			spell = lineEll[0];
			if (spell.equals("Cloud")) {
				spell = "Plague Cloud";
			}
			
			row = Integer.parseInt(lineEll[1]);
			col = Integer.parseInt(lineEll[2]);
			
			heiganHealth -= playerDamage;
			
			if (plagueCloud) {
				playerHealth -= 3500;
				plagueCloud = false;
			}
			
			if (endGame(playerHealth, heiganHealth, "Plague Cloud", playerPosition)) {
				return;
			}
			
			if (spell.equals("Eruption")) {
				heiganDamage = 6000;
			}
			else {
				heiganDamage = 3500;
			}
			
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 15; j++) {
					room[i][j] = 0;
				}
			}
			
			if(row > 0) {
				if (col >= 0) {
					room[row][col] = 2;
					room[row - 1][col] = 2;
				}
				if(col > 0){
					room[row - 1][col - 1] = 2;
					room[row][col - 1] = 2;
				}
				if(col < 14){
					room[row - 1][col + 1] = 2;
					room[row][col + 1] = 2;
				}
			}
			if(row < 14){
				if (col >= 0) {
					room[row][col] = 2;
					room[row + 1][col] = 2;					
				}
				if(col > 0){
					room[row][col - 1] = 2;
					room[row + 1][col - 1] = 2;
				}
				if(col < 14){
					room[row + 1][col + 1] = 2;
					room[row][col + 1] = 2;
				}
			}
			
			if (playerPosition[0] == row && playerPosition[1] == col) {
				playerHealth -= heiganDamage;
				
				if(spell.equals("Plague Cloud")){
					plagueCloud = true;
				}
			}
			else if (playerPosition[0] - 1 == row 
					|| playerPosition[0] + 1 == row 
					|| playerPosition[1] - 1 == col 
					|| playerPosition[1] + 1 == col) {
				if(playerPosition[0] > 0 && room[playerPosition[0] - 1][playerPosition[1]] != 2){
					playerPosition[0] = playerPosition[0] - 1;
				}
				else if(playerPosition[1] < 14 && room[playerPosition[0]][playerPosition[1] + 1] != 2) {
					playerPosition[1] = playerPosition[1] + 1;
				}
				else if(playerPosition[0] < 14 && room[playerPosition[0] + 1][playerPosition[1]] != 2){
					playerPosition[0] = playerPosition[0] + 1;
					
				}
				else if(playerPosition[1] > 0 && room[playerPosition[0]][playerPosition[1] - 1] != 2) {
					playerPosition[1] = playerPosition[1] - 1;
				}
				else {
					playerHealth -= heiganDamage;
					
					if(spell.equals("Plague Cloud")){
						plagueCloud = true;
					}
				}
			}
			
			if (endGame(playerHealth, heiganHealth, spell, playerPosition)) {
				return;
			}	
		}
	}

	private static boolean endGame(int playerHealth, double heiganHealth, String spell, int[] playerPosition) {
		if (playerHealth <= 0 && heiganHealth <= 0) {
			System.out.println("Heigan: Defeated!");
			System.out.println("Player: Killed by " + spell);
			System.out.println("Final position: " + playerPosition[0] + ", " + playerPosition[1]);
			return true;
		}
		else if (playerHealth <= 0) {
			System.out.printf("Heigan: %.2f\n", heiganHealth);
			System.out.println("Player: Killed by " + spell);
			System.out.println("Final position: " + playerPosition[0] + ", " + playerPosition[1]);
			return true;
		}
		else if(heiganHealth <= 0) {
			System.out.println("Heigan: Defeated!");
			System.out.println("Player: " + playerHealth);
			System.out.println("Final position: " + playerPosition[0] + ", " + playerPosition[1]);
			return true;
		}
		return false;
	}
}