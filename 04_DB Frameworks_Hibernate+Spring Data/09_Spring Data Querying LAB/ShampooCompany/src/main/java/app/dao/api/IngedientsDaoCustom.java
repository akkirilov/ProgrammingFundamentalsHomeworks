package app.dao.api;

import app.model.BasicIngredient;
import app.model.BasicShampoo;

import java.util.List;

public interface IngedientsDaoCustom {
	
    List<BasicShampoo> shampoosWithIngredient(BasicIngredient ingredient);
    
}
