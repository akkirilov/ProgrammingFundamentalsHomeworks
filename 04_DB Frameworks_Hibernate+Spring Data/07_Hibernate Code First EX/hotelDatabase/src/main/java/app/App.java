package app;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.BedType;
import model.Customer;
import model.Employee;
import model.Occupancy;
import model.Payment;
import model.Room;
import model.RoomStatus;
import model.RoomType;

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
    	
    	Employee employee = new Employee();
    	employee.setFirstName("Gosho");
    	employee.setLastName("Goshovsky");
    	employee.setTitle("Mr.");

    	Customer customer = new Customer();
    	customer.setAccountNumber("55555-55555-5555");
    	customer.setFirstName("Pesho");
    	customer.setLastName("Peshevsdky");
    	customer.setEmergancyName("Marcho Marchev");
    	customer.setPhoneNumber("0888888888");
    	customer.setEmergancyPhone("0878777888");
    	
    	BedType bedType = new BedType();
    	bedType.setBedType("Double");
    	
    	RoomStatus roomStatus = new RoomStatus();
    	roomStatus.setRoomStatus("Non smoking");
    	
        RoomType roomType = new RoomType();
        roomType.setRoomType("Studio");
        
        Room room = new Room();
        room.setBedType(bedType);
        room.setPrice(250.00);
        room.setRoomNumber(408);
        room.setRoomStatus(roomStatus);
        room.setRoomType(roomType);
        
        Payment payment = new Payment();
        payment.setAmountCharged(room.getPrice());
        payment.setFirstDateOccupied(Date.valueOf(LocalDate.now()));
        payment.setLastDateOccupied(Date.valueOf(LocalDate.now().plusDays(3)));
        payment.setPaymentDate(Date.valueOf(LocalDate.now().minusDays(21)));
        payment.setTaxRate(0.2);
        payment.setTaxAmount(payment.getAmountCharged() * payment.getTaxRate());
        payment.setPaymentTotal(payment.getAmountCharged() + payment.getTaxAmount());
        payment.setCustomer(customer);
        
        Occupancy occupancy = new Occupancy();
        occupancy.setCustomer(customer);
        occupancy.setRoom(room);
        occupancy.setPayment(payment);
        occupancy.setDateOccupied(occupancy.getPayment().getFirstDateOccupied());
        occupancy.setEmployee(employee);
        occupancy.setPhoneCharge(958.32);
		
    	em.getTransaction().begin();
        em.persist(occupancy);
    	em.getTransaction().commit();
    	em.close();
    	emf.close();
    }
}
