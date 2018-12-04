import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Snake {

	public static void main(String[] args) {
		Integer row = 0;
		Integer col = 0;
		Integer size = 1;
		Integer totalFood = 0;
		Boolean findStart = false;
		Boolean gameover = false;
		
		Scanner scr = new Scanner(System.in);
		Integer n = Integer.parseInt(scr.nextLine());
		Deque<String> commands = new ArrayDeque<>(Arrays.asList(scr.nextLine().split(", ")));
		
		char[][] screen = new char[n][n];
		for (int i = 0; i < n; i++) {
			screen[i] = scr.nextLine().replaceAll("\\s+", "").toCharArray();
			for (int j = 0; j < screen[i].length; j++) {
				if(!findStart && screen[i][j] == 's') {
					row = i;
					col = j;
					findStart = true;
				} else if(screen[i][j] == 'f') {
					totalFood++;
				}
			}
		}

		while (!commands.isEmpty()) {
			String command = commands.removeFirst();
			switch (command) {
			case "left":
				col--;
				if(col < 0) {
					col = n - 1;
				}
				break;
			case "right":
				col++;	
				if(col == n) {
					col = 0;
				}
				break;
			case "up":
				row--;
				if(row < 0) {
					row = n - 1;
				}
				break;
			case "down":
				row++;
				if(row == n) {
					row = 0;
				}
				break;
			default:
				break;
			}
			
			char box = screen[row][col];
			if(box == 'e') {
				System.out.println("You lose! Killed by an enemy!");
				gameover = true;
				break;
			} else if(box == 'f') {
				size++;
				totalFood--;
			}
			
			if(totalFood == 0) {
				System.out.println("You win! Final snake length is " + size);
				gameover = true;
				break;
			}
		}
		
		if(!gameover) {
			System.out.println("You lose! There is still " + totalFood + " food to be eaten.");
		}
		
		scr.close();
	}

}
