package p02_GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator <T> {

	@SuppressWarnings("unchecked")
	public static <T> T[] create(int length, T item){
		Object[] res = new Object[length];
		for (int i = 0; i < res.length; i++) {
			res[i] = item;
		}
		return (T[]) res;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[] create(Class<T> clazz, int length, T item){
		T[] res = (T[]) Array.newInstance(clazz, length);
		for (int i = 0; i < res.length; i++) {
			res[i] = item;
		}
		return res;
	}
	
}
