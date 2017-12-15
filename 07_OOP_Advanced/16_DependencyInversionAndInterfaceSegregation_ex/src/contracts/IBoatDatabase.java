package contracts;

public interface IBoatDatabase {
	
	IRepository<IBoat> getBoats();
    
    IRepository<IEngine> getEngines();
    
}
