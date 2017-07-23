package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.WizardDeposits;

public class App {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitName");
		EntityManager em = emf.createEntityManager();
		
		WizardDeposits wizardDeposits = new WizardDeposits();
		wizardDeposits.setFirstName("Gandalf");
		wizardDeposits.setLastName("Gray");
		wizardDeposits.setAge(850);
		wizardDeposits.setDepositAmount(1000.56);
		wizardDeposits.setDepositCharge(24.32);
		wizardDeposits.setDepositInterest(2.33);
		wizardDeposits.setDepositGroup("wizards");
		wizardDeposits.setMagicWandCreator("Master");
		wizardDeposits.setNotes("The best");
		wizardDeposits.setMagicWandSize((short) 54);
		
		em.getTransaction().begin();
		em.persist(wizardDeposits);
		em.getTransaction().commit();
		
		em.close();
		emf.close();

	}

}
