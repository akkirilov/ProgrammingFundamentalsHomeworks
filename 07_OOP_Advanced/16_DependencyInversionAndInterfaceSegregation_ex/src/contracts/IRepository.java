package contracts;

import java.util.Map;

import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;

public interface IRepository<T extends IModelable> {
	
    void add(T item) throws DuplicateModelException;

    T getItem(String model) throws NonExistantModelException;
    
    Map<String, T> getItemsByModel();
    
}
