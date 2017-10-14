import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class ex09_StudentsEnrolledIn2014or2015 {

	public static void main(String[] args) throws IOException {
		
//		As Plain text = 100/100
//		2011:
//			-- Aaron Gibson
//			-- Anne Freeman
//			-- Beverly Clark
//			-- Billy Romero
//			-- Cheryl Gray
//			-- David Johnston
//			-- Ernest Banks
//			-- Eugene Lawson
//			-- Frances Fisher
//			-- Gary Foster
//			-- Gloria Schmidt
//			-- Heather Knight
//			-- Helen Hernandez
//			-- James Nelson
//			-- Jesse Howard
//			-- Kathryn Lee
//			-- Marilyn Clark
//			2012:
//			-- Catherine Diaz
//			-- Craig Flores
//			-- Gerald Diaz
//			-- Jane Lopez
//			-- Juan Ferguson
//			-- Nicholas Reyes
//			-- William Alexander
//			2013:
//			-- Alice Baker
//			-- Andrea Harper
//			-- Ann Anderson
//			-- Carolyn Grant
//			-- Edward Nelson
//			-- Edward Rose
//			-- Elizabeth James
//			-- Fred Andrews
//			-- Jacqueline Stewart
//			-- Joan Lee
//			-- Julie Cunningham
//			-- Justin Watkins
//			-- Marie Simpson
//			-- Sara Mills
//			-- Terry Pierce
//			-- William Garcia
//			2014:
//			-- Andrea Kelly
//			-- Craig Ellis
//			-- Daniel Carter
//			-- Kelly Woods
//			-- Mildred Hansen
//			-- Rebecca Torres
//			-- Richard Edwards
//			-- Ruby Lewis
//			-- Shirley Hall
//			-- Susan Dixon
//			2015:
//			-- Amanda Hernandez
//			-- Anne Powell
//			-- Antonio Gonzalez
//			-- Antonio Rodriguez
//			-- Ashley Lee
//			-- Billy Bowman
//			-- Diana Flores
//			-- Fred Simmons
//			-- Lawrence Hernandez
//			-- Lillian Hart
//			-- Marilyn Price
//			-- Nancy Patterson
//			-- Robin Long
//			-- Tina Olson
//			2016:
//			-- Albert Cruz
//			-- Arthur James
//			-- Daniel Ferguson
//			-- Jonathan Gibson
//			-- Margaret Peterson
//			-- Michelle Daniels
//			-- Mildred Hart
//			-- Theresa Simpson
//			-- Victor Harvey
//			2017:
//			-- Craig King
//			-- Emily Howard
//			-- Frances Peters
//			-- Gerald Watson
//			-- Gloria Harvey
//			-- Julie Riley
//			-- Kelly Vasquez
//			-- Rose Hernandez
//			-- Stephen Roberts
//			2018:
//			-- Bonnie Shaw
//			-- Charles Alvarez
//			-- Cynthia Olson
//			-- Lawrence Welch
//			-- Steven Cole
//			-- Terry Frazier
//			2019:
//			-- Catherine Porter
//			-- Helen Williamson
//			-- Jeffrey Gibson
//			-- Justin Reyes
//			-- Lawrence Evans
//			-- Lois Patterson
//			-- Maria Price
//			-- Melissa Robinson
//			-- Raymond Stewart
//			-- Roger Adams
//			-- Sean Castillo
//			-- Susan Boyd
		
//		Correct solution
		List<Student> students = new LinkedList<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = reader.readLine().split("\\s+");
		while (!input[0].equals("END")) {
			
			Student temp = new Student();
			temp.setFacultyNumber(input[0]);
			
			for (int i = 1; i < input.length; i++) {
				temp.addGrade(Integer.parseInt(input[i]));
			}
			
			students.add(temp);
			
			input = reader.readLine().split("\\s+");
			
		}
		
		reader.close();
		
		students.stream()
			.filter(Student.isEnrolledIn2014or2015)
			.forEach(x -> System.out.println(x.getGradesAsLine()));

	}

}
