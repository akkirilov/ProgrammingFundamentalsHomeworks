package hell;

import java.io.InputStreamReader;

import hell.core.EngineImpl;
import hell.core.HellManager;
import hell.factories.HeroFactoryImpl;
import hell.factories.InventoryFactoryImpl;
import hell.factories.ItemFactoryImpl;
import hell.factories.RecipeFactoryImpl;
import hell.interfaces.Engine;
import hell.interfaces.HeroFactory;
import hell.interfaces.InputReader;
import hell.interfaces.InventoryFactory;
import hell.interfaces.ItemFactory;
import hell.interfaces.Manager;
import hell.interfaces.OutputWriter;
import hell.interfaces.RecipeFactory;
import hell.io.Reader;
import hell.io.Writer;

public class Main {
	
    public static void main(String[] args) {
    	
//    	int n = Integer.MAX_VALUE + 1;
//    	System.out.println(n);
//    	long nn = (long)(Integer.MAX_VALUE + (Math.abs(Integer.MIN_VALUE) - n) + 1L);
//    	long c = Integer.MAX_VALUE;
//    	System.out.println(nn);
//    	System.out.println(c);
    	
    	InputStreamReader isr = new InputStreamReader(System.in);
    	InputReader reader = new Reader(isr);
    	OutputWriter writer = new Writer();
    	
    	HeroFactory heroFactory = new HeroFactoryImpl();
    	ItemFactory itemFactory = new ItemFactoryImpl();
    	RecipeFactory recipeFactory = new RecipeFactoryImpl();
    	InventoryFactory inventoryFactory = new InventoryFactoryImpl();
    	Manager manager = new HellManager(heroFactory, itemFactory, recipeFactory, inventoryFactory);
    	
    	Engine engine = new EngineImpl(reader, writer, manager);
    	
    	engine.run();
    	
    }
    
}
