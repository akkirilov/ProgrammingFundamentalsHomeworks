package App;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Customer;
import entity.Product;
import entity.Sale;
import entity.StoreLocation;

public class App 
{
    public static void main( String[] args )
    {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitName");
    	EntityManager em = emf.createEntityManager();
    			
    	Product product = new Product();
    	product.setNama("Tikva");
    	product.setPrice(4.32);

    	Customer customer = new Customer();
    	customer.setName("Gosho");
    	customer.setEmail("gosho@goshov.go");
    	customer.setCreditCardNumber("555555555555555");
    	
    	StoreLocation storeLocation = new StoreLocation();
    	storeLocation.setName("Zilla");

    	Sale sale = new Sale();
    	sale.setProduct(product);
    	sale.setStoreLocation(storeLocation);
    	sale.setCustomer(customer);
    	sale.setDate(Date.valueOf(LocalDate.now()));
    	
    	em.getTransaction().begin();
    	em.persist(sale);
    	em.getTransaction().commit();
    	em.close();
    	emf.close();
    	
    }
}
