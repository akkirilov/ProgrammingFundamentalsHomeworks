package app.utils;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class JsonParser {
	
	private Gson gson = new GsonBuilder()
			.excludeFieldsWithoutExposeAnnotation()
			.setPrettyPrinting()
			.create();

    private FileParser fileParser = new FileParser();
	
	public <T> T importJsonOne(Class<T> clazz, String path) throws IOException {
		String file = fileParser.readFile(path);
        
		T object = gson.fromJson(file, clazz);
        
		return object;		
	}
	
	public <T> List<T> importJsonList(Class<T> clazz, String path) throws IOException {
		String file = fileParser.readFile(path);
		
		Object [] arr = (Object[])Array.newInstance(clazz, 1);
		arr = gson.fromJson(file, arr.getClass());
		
	    List<T> list = new ArrayList<T>();
	    for (int i=0 ; i<arr.length ; i++) {
	        list.add((T)arr[i]);
	    }
	    
	    return list;
    }

    public <T> void exportJson(T object, String path) throws IOException {
        String content = gson.toJson(object);
        
		fileParser.writeFile(path, content);
    }

}
