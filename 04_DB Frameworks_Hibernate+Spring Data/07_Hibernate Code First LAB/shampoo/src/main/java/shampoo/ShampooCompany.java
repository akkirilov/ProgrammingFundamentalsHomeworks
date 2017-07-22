package shampoo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.AmmoniumChloride;
import model.BasicIngredient;
import model.BasicShampoo;
import model.ClassicLabel;
import model.Levander;
import model.Mint;
import model.Nettle;
import model.ProductionBatch;
import model.Shampoo;
import model.ShampooFiftyShades;
import model.ShampooFreshNuke;
import model.ShampooPinkPanther;
import model.Strawberry;
import service.BasicDao;

public class ShampooCompany {

	private static BasicDao dao = new BasicDao();
	
	public static void main(String[] args) {
		
		Mint mint = new Mint();
		Levander levander = new Levander();
		Nettle nettle = new Nettle();
		Strawberry strawberry = new Strawberry();
		AmmoniumChloride ammoniumChloride = new AmmoniumChloride();
		
		ClassicLabel label1 = new ClassicLabel("Pink Panter");
		ClassicLabel label2 = new ClassicLabel("Fresh Nuke");
		ClassicLabel label3 = new ClassicLabel("Fifty Shades");
		
		ProductionBatch batch = new ProductionBatch();
		
		Set<BasicIngredient> ingredients1 = new HashSet<BasicIngredient>();
		ingredients1.add(levander);
		ingredients1.add(nettle);
		Shampoo pinkPanter = new ShampooPinkPanther(label1, batch, ingredients1);
		
		Set<BasicIngredient> ingredients2 = new HashSet<BasicIngredient>();
		ingredients2.add(mint);
		ingredients2.add(nettle);
		ingredients2.add(ammoniumChloride);
		Shampoo freshNuke = new ShampooFreshNuke(label2, batch, ingredients2);
		
		Set<BasicIngredient> ingredients3 = new HashSet<BasicIngredient>();
		ingredients3.add(strawberry);
		ingredients3.add(nettle);
		Shampoo fiftyShades = new ShampooFiftyShades(label3, batch, ingredients3);
				
		dao.beginTransaction();
		
		dao.save(mint);
		dao.save(levander);
		dao.save(nettle);
		dao.save(strawberry);
		dao.save(ammoniumChloride);
		
		dao.save(label1);		
		dao.save(label2);	
		dao.save(label3);	
		
		dao.save(batch);
		
		dao.save(pinkPanter);
		dao.save(freshNuke);
		dao.save(fiftyShades);
		
		dao.commit();
		System.out.println(Shampoo.class.getSimpleName());
		List<BasicShampoo> sh = (List<BasicShampoo>) dao.findAll(BasicShampoo.class);
		System.out.println(sh);
		
		dao.closeDao();

	}

}
