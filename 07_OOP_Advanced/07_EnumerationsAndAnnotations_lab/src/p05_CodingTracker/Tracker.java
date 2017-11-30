package p05_CodingTracker;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {

	@Author(name = "Pesho")
	public static void printMethodsByAuthor(Class<?> clazz) {
		
		Map<String, List<String>> methodsByAuthors = new HashMap<>();
		
		Method[] methods = clazz.getMethods();
		for (Method m : methods) {
			Annotation[] annotations = m.getAnnotations();
			for (Annotation a : annotations) {
				if (a instanceof Author) {
					Author tempAuthor = (Author) a;
					List<String> tempMethods = new ArrayList<>();
					if (methodsByAuthors.containsKey(tempAuthor.name())) {
						tempMethods = methodsByAuthors.get(tempAuthor.name());
					}
					tempMethods.add(m.getName() + "()");
					methodsByAuthors.put(tempAuthor.name(), tempMethods);
				}
			}
		}
		
		for (Map.Entry<String, List<String>> e : methodsByAuthors.entrySet()) {
			System.out.println(e.getKey() + ": " + String.join(", ", e.getValue()));
		}
	}
	
	@Author(name = "Pesho")
	public static void main(String[] args) {
		
	}
}
