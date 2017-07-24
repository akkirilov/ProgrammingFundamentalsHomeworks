package app;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Vehicle;
import model.motorVehicles.cars.Car;
import model.motorVehicles.planes.Plane;
import model.motorVehicles.ships.CargoShip;
import model.motorVehicles.ships.CruiseShip;
import model.motorVehicles.trains.Locomotive;
import model.motorVehicles.trains.Train;
import model.motorVehicles.trains.carriages.Carriage;
import model.motorVehicles.trains.carriages.PassengerCarriage;
import model.motorVehicles.trains.carriages.RestaurantCarriage;
import model.motorVehicles.trains.carriages.SleepingCarriage;
import model.nonMotorVehicles.bikes.Bike;

public class App 
{
	
    public static void main( String[] args )
    {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitName");
    	EntityManager em = emf.createEntityManager();
    		
    	Vehicle vehicle1 = 
    			new Car("Mercedes", "S 55", 105582.23, 300, "DS545SD5454DSD", "BiTurbo", 120, 4, true);   	
    	Vehicle vehicle2 = 
    			new Bike("Ram", "HT1", 799.99, 55, 24, "White");  	
    	Vehicle vehicle3 = 
    			new Plane("Boeing", "747", 1000000.99, 1000, "SDSD5545SDCX65", "Turbo", 10000, 
    					"MelnicAir", "White", 250);	
    	Vehicle vehicle4 = 
    			new CargoShip("VarnaKorab", "Morski Tank", 600500.54, 60, "SD44ZD456D", "Koraben", 
    					1000000, "Bulgarian", "Marko Polo", 25, 10005677);	
    	Vehicle vehicle5 = 
    			new CruiseShip("VarnaKorab", "Morsko Party 2000", 1200500.54, 60, "48ERTY5441PLMN5", 
    					"Koraben", 1000000, "Bulgarian", "Gosheto Peshevsky", 154, 955);
    	
    	Carriage carriage1 = new PassengerCarriage(50, 20);
    	Carriage carriage2 = new PassengerCarriage(60, 20);
    	Carriage carriage3 = new PassengerCarriage(70, 20);
    	Carriage carriage4 = new PassengerCarriage(80, 20);
    	Carriage carriage5 = new PassengerCarriage(90, 20);
    	Carriage carriage6 = new RestaurantCarriage(50, 12);
    	Carriage carriage7 = new SleepingCarriage(50, 50);
    	Carriage carriage8 = new SleepingCarriage(70, 50);
    	
    	Set<Carriage> carriages = new HashSet<Carriage>();
    	carriages.add(carriage1);
    	carriages.add(carriage2);
    	carriages.add(carriage3);
    	carriages.add(carriage4);
    	carriages.add(carriage5);
    	carriages.add(carriage6);
    	carriages.add(carriage7);
    	carriages.add(carriage8);
    	
    	Locomotive locomotive = new Locomotive("Locomotivenstain", 1500);
    	
    	Vehicle vehicle6 = new Train("BDZ", "old fashion groove", 250000.00, 75, "BDZ4547HGF454OPI5", "Elecric", 500, locomotive, carriages);
    	
    	em.getTransaction().begin();

    	em.persist(vehicle1);
    	em.persist(vehicle2);
    	em.persist(vehicle3);
    	em.persist(vehicle4);
    	em.persist(vehicle5);
    	em.persist(vehicle6);
    	
    	em.getTransaction().commit();

    	em.close();
    	emf.close();
    	
    }
    
}
