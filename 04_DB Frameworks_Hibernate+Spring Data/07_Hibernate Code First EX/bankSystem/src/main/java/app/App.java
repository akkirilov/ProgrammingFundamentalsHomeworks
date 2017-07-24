package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Account;
import model.CheckingAccount;
import model.SavingAccount;

public class App 
{
	
    public static void main( String[] args )
    {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitName");
    	EntityManager em = emf.createEntityManager();
    		
    	Account account1 = new SavingAccount("UNCR55 5454 5454 8877 99", 2000.23, 1.23);
    	Account account2 = new CheckingAccount("UNCR55 7894 5454 4123 02", 2500.29, 1.50);
    	
    	SavingAccount account3 = new SavingAccount("UNCR22 8877 7894 4123 77", 2000.23, 1.23);
    	account3.addInterest(1.01);
    	
    	CheckingAccount account4 = new CheckingAccount("UNCR55 7894 5454 4123 02", 2500.29, 1.50);
    	account4.deductFee(0.25);
    	
    	em.getTransaction().begin();

    	em.persist(account1);
    	em.persist(account2);
    	em.persist(account3);
    	em.persist(account4);

    	em.getTransaction().commit();

    	em.close();
    	emf.close();
    	
    }
    
}
