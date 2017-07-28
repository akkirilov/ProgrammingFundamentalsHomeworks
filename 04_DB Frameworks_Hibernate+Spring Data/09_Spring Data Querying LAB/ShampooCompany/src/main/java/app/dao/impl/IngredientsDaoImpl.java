package app.dao.impl;

import app.dao.api.IngedientsDaoCustom;
import app.model.BasicIngredient;
import app.model.BasicShampoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class IngredientsDaoImpl implements IngedientsDaoCustom {

    @Autowired
    private EntityManager em;

    @Override
    public List<BasicShampoo> shampoosWithIngredient(BasicIngredient ingredient) {
        List<BasicShampoo> allShampoos = em.createQuery("From BasicShampoos").getResultList();
        List<BasicShampoo> result =  allShampoos
                .stream()
                .filter(s -> s.getIngredients().contains(ingredient))
                .collect(Collectors.toList());
        return result;
    }
}
