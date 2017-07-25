package app;

import app.model.*;
import app.service.impl.BasicIngredientService;
import app.service.impl.BatchService;
import app.service.impl.ChemicalIngredientService;
import app.service.impl.LabelService;
import app.service.impl.ShampooService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ConsoleRunner implements CommandLineRunner{

    @Autowired
    private BatchService productionBatchService;

    @Autowired
    private BasicIngredientService basicIngredientService;
    
    @Autowired
    private ChemicalIngredientService chemicalIngredientService;

    @Autowired
    private ShampooService basicShampoosService;
    
    @Autowired
    private LabelService labelService;

    @Override
    public void run(String... strings) throws Exception {
        BasicIngredient ingredient1 = new Mint();
        BasicIngredient ingredient2 = new Nettle();
        BasicIngredient ingredient3 = new Levander();
        BasicIngredient ingredient4 = new Strawberry();
        BasicChemicalIngredient ingredient5 = new AmmoniumChloride();
        basicIngredientService.save(ingredient1);
        basicIngredientService.save(ingredient2);
        basicIngredientService.save(ingredient3);
        basicIngredientService.save(ingredient4);
        chemicalIngredientService.save(ingredient5);

        ClassicLabel label1 = new ClassicLabel("FreshNuke");
        ClassicLabel label2 = new ClassicLabel("PinkPanther");
        ClassicLabel label3 = new ClassicLabel("FiftyShades");
        labelService.save(label1);
        labelService.save(label2);
        labelService.save(label3);
        
        ProductionBatch batch1 = new ProductionBatch();
        ProductionBatch batch2 = new ProductionBatch();
        ProductionBatch batch3 = new ProductionBatch();
        productionBatchService.save(batch1);
        productionBatchService.save(batch2);
        productionBatchService.save(batch3);
        
        Set<BasicIngredient> ingredients1 = new HashSet<BasicIngredient>();
        ingredients1.add(ingredient1);
        ingredients1.add(ingredient2);
        
        Set<BasicIngredient> ingredients2 = new HashSet<BasicIngredient>();
        ingredients2.add(ingredient2);
        ingredients2.add(ingredient3);
        
        Set<BasicIngredient> ingredients3 = new HashSet<BasicIngredient>();
        ingredients3.add(ingredient4);
        ingredients3.add(ingredient5);
        
        BasicShampoo shampoo1 = new ShampooFreshNuke();
        shampoo1.setBatch(batch1);
        shampoo1.setIngredients(ingredients1);
        shampoo1.setLabel(label1);
        
        BasicShampoo shampoo2 = new ShampooPinkPanther();
        shampoo2.setBatch(batch2);
        shampoo2.setIngredients(ingredients2);
        shampoo2.setLabel(label2);
        
        BasicShampoo shampoo3 = new ShampooFiftyShades();
        shampoo3.setBatch(batch3);
        shampoo3.setIngredients(ingredients3);
        shampoo3.setLabel(label3);
        
        basicShampoosService.save(shampoo1);      
        basicShampoosService.save(shampoo2);   
        basicShampoosService.save(shampoo3);   
        
        List<BasicShampoo> shampoos = basicShampoosService.findAllShampoosContainsbasicIngredient(ingredient2);
        for (BasicShampoo basicShampoo : shampoos) {
			System.out.println(basicShampoo.getLabel().getTitle());
			for (Ingredient i : basicShampoo.getIngredients()) {
				System.out.println("-- " + i.getName());
			}
		}
        
    }
    
}
