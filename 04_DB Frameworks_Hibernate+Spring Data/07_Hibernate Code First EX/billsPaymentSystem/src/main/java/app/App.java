package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.BankAccount;
import model.BillingDetails;
import model.CreditCard;
import model.User;

public class App 
{
	
    public static void main( String[] args )
    {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitName");
    	EntityManager em = emf.createEntityManager();
    	
    	User user1 = new User("Gosho", "Goshovsky", "gosho@goshoo.go", "pass");
    	User user2 = new User("Gosho", "Goshovsky", "gosho@goshoo.go", "pass");
    	
    	BillingDetails billingDetails1 = new BankAccount("bank1", "555");
    	BillingDetails billingDetails2 = new CreditCard("VISA", 5, 2018);
    	
    	user1.setBillingDetails(billingDetails1);
    	user2.setBillingDetails(billingDetails2);
    	
    	em.getTransaction().begin();

    	em.persist(user1);
    	em.persist(user2);

    	em.getTransaction().commit();

    	em.close();
    	emf.close();
    	
    }
    
}
