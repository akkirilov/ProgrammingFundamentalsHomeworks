package contracts;

public interface IBoat extends IModelable {
	
	String getModel();
	
    int getWeight();
    
    double getRaceSpeed(IRace race);
    
    boolean isMotorBoat();

}
