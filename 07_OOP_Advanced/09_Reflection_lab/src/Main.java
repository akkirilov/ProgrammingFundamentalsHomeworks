import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {

		Class clazz = Reflection.class;

		// 1. Reflection
		// System.out.println(clazz);
		// System.out.println(clazz.getSuperclass());
		// Class[] interfaces = clazz.getInterfaces();
		// for (Class i : interfaces) {
		// System.out.println(i);
		// }
		// Reflection reflection = (Reflection) clazz.newInstance();
		// System.out.println(reflection);

		// 2. Getters and Setters
		// Map<String, String> getters = new TreeMap<>();
		// Map<String, String> setters = new TreeMap<>();
		//
		// Method[] methods = clazz.getDeclaredMethods();
		// for (Method method : methods) {
		// if (method.getName().startsWith("get")) {
		// getters.put(method.getName(),
		// method.getGenericReturnType().toString());
		// } else if (method.getName().startsWith("set")) {
		// StringBuilder sb = new StringBuilder();
		// Class[] parameters = method.getParameterTypes();
		// for (Class p : parameters) {
		// sb.append(p).append(", ");
		// }
		// setters.put(method.getName(), sb.substring(0, sb.length() - 2));
		// }
		// }
		//
		// for (Map.Entry<String, String> e : getters.entrySet()) {
		// System.out.println(e.getKey() + " will return " + e.getValue());
		// }
		// for (Map.Entry<String, String> e : setters.entrySet()) {
		// System.out.println(e.getKey() + " and will set field of " +
		// e.getValue());
		// }

		// 3. High Quality Mistakes
		List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
		fields.sort(new Comparator<Field>() {
			@Override
			public int compare(Field o1, Field o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		for (Field f : fields) {
			if (!Modifier.isPrivate(f.getModifiers())) {
				System.out.println(f.getName() + " must be private!");
			}
		}
		
		List<Method> methods = Arrays.asList(clazz.getDeclaredMethods());
		methods.sort(new Comparator<Method>() {
			@Override
			public int compare(Method o1, Method o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		for (Method m : methods) {
			if (m.getName().startsWith("get") && !Modifier.isPublic(m.getModifiers())) {
				System.out.println(m.getName() + " have to be public!");
			}
		}
		for (Method m : methods) {
			if (m.getName().startsWith("set") && !Modifier.isPrivate(m.getModifiers())) {
				System.out.println(m.getName() + " have to be private!");
			}
		}

	}

}
