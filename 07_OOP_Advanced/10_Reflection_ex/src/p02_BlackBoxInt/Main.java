package p02_BlackBoxInt;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {

		Class clazz = BlackBoxInt.class;
		
		Constructor<BlackBoxInt> constructor;
        constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        
		BlackBoxInt blackBoxInt = constructor.newInstance();
		Field value = blackBoxInt.getClass().getDeclaredField("innerValue");
		value.setAccessible(true);
		
		Method addMethod = blackBoxInt.getClass().getDeclaredMethod("add", int.class);
		addMethod.setAccessible(true);
		
		Method subtractMethod = blackBoxInt.getClass().getDeclaredMethod("subtract", int.class);
		subtractMethod.setAccessible(true);
		
		Method divideMethod = blackBoxInt.getClass().getDeclaredMethod("divide", int.class);
		divideMethod.setAccessible(true);
		
		Method multiplyMethod = blackBoxInt.getClass().getDeclaredMethod("multiply", int.class);
		multiplyMethod.setAccessible(true);
		
		Method rightShiftMethod = blackBoxInt.getClass().getDeclaredMethod("rightShift", int.class);
		rightShiftMethod.setAccessible(true);
		
		Method leftShiftMethod = blackBoxInt.getClass().getDeclaredMethod("leftShift", int.class);
		leftShiftMethod.setAccessible(true);
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			String[] tokens = scanner.nextLine().split("_");
			if (tokens[0].equalsIgnoreCase("END")) {
				break;
			}
			
			Integer num = Integer.parseInt(tokens[1]);

			switch (tokens[0]) {
			case "add":
				addMethod.invoke(blackBoxInt, num);
				System.out.println(value.getInt(blackBoxInt));
				break;
			case "subtract":
				subtractMethod.invoke(blackBoxInt, num);
				System.out.println(value.getInt(blackBoxInt));
				break;
			case "divide":
				divideMethod.invoke(blackBoxInt, num);
				System.out.println(value.getInt(blackBoxInt));
				break;
			case "multiply":
				multiplyMethod.invoke(blackBoxInt, num);
				System.out.println(value.getInt(blackBoxInt));
				break;
			case "rightShift":
				rightShiftMethod.invoke(blackBoxInt, num);
				System.out.println(value.getInt(blackBoxInt));
				break;
			case "leftShift":
				leftShiftMethod.invoke(blackBoxInt, num);
				System.out.println(value.getInt(blackBoxInt));
				break;
			default:
				break;
			}
		}
		scanner.close();
		
	}
	
}
