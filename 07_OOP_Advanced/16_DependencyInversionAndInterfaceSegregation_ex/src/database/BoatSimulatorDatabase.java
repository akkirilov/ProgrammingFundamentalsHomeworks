package database;

import contracts.IBoat;
import contracts.IBoatDatabase;
import contracts.IEngine;
import contracts.IRepository;

public class BoatSimulatorDatabase implements IBoatDatabase {
	
	private IRepository<IBoat> boats;
	
	private IRepository<IEngine> engines;

    public BoatSimulatorDatabase() {
        this.setBoats(new Repository<IBoat>());
        this.setEngines(new Repository<IEngine>());
    }
    
    private void setBoats(IRepository<IBoat> boats) {
        this.boats = boats;
    }

    private void setEngines(IRepository<IEngine> engines) {
        this.engines = engines;
    }

    @Override
    public IRepository<IBoat> getBoats() {
        return this.boats;
    }

    @Override
    public IRepository<IEngine> getEngines() {
        return this.engines;
    }

}
