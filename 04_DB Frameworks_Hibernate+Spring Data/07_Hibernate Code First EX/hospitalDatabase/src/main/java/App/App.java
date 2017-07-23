package App;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Diagnose;
import model.Medicament;
import model.Patient;
import model.Visitation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitName");
    	EntityManager em = emf.createEntityManager();

    	Medicament medicament1 = new Medicament();
    	medicament1.setName("Aspirin");
    	Medicament medicament2 = new Medicament();
    	medicament2.setName("Analgin");
    	Set<Medicament> medicaments = new HashSet<Medicament>();
    	medicaments.add(medicament1);
    	medicaments.add(medicament2);
    	
    	Diagnose diagnose1 = new Diagnose();
    	diagnose1.setComment("Mahmorluk");
    	Diagnose diagnose2 = new Diagnose();
    	diagnose2.setComment("Prepivane");
    	Set<Diagnose> diagnoses = new HashSet<Diagnose>();
    	diagnoses.add(diagnose1);
    	diagnoses.add(diagnose2);
    	
    	Visitation visitation1 = new Visitation();
    	visitation1.setComment("Mahmorluk");
    	visitation1.setDate(Date.valueOf(LocalDate.now().minusDays(2)));
    	Visitation visitation2 = new Visitation();
    	visitation2.setComment("Prepivane");
    	visitation2.setDate(Date.valueOf(LocalDate.now().minusDays(1)));
    	Set<Visitation> visitations = new HashSet<Visitation>();
    	visitations.add(visitation1);
    	visitations.add(visitation2);    	
    	
    	Patient patient = new Patient();
    	patient.setFirstName("Gosho");
    	patient.setLastName("Goshevsky");
    	patient.setAddress("Piyqnovo, Piyanska 5");
    	patient.setDateOfBirth(Date.valueOf(LocalDate.now().minusDays(10000)));
    	patient.setEmail("gosho@goshoo.go");
    	patient.setHasInsurance(false);
    	patient.setDiagnoses(diagnoses);
    	patient.setMedicaments(medicaments);
    	patient.setVisitations(visitations);
    	
    	em.getTransaction().begin();
    	em.persist(patient);
    	em.getTransaction().commit();

    	em.close();
    	emf.close();
    }
}
