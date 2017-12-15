package database;

import contracts.IModelable;
import contracts.IRepository;
import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;
import utilities.Constants;

import java.util.HashMap;
import java.util.Map;

public class Repository<T extends IModelable> implements IRepository<T> {
	
    private Map<String, T> itemsByModel;

    public Repository() {
        this.setItemsByModel(new HashMap<String, T>());
    }
    
    private void setItemsByModel(Map<String, T> itemsByModel) {
        this.itemsByModel = itemsByModel;
    }

    @Override
    public Map<String, T> getItemsByModel() {
        return this.itemsByModel;
    }

    @Override
    public void add(T item) throws DuplicateModelException {
        if (this.itemsByModel.containsKey(item.getModel())) {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }
        this.itemsByModel.put(item.getModel(), item);
    }

    @Override
    public T getItem(String model) throws NonExistantModelException {
        if (!this.itemsByModel.containsKey(model)) {
            throw new NonExistantModelException(Constants.NonExistantModelMessage);
        }
        return this.itemsByModel.get(model);
    }

}
