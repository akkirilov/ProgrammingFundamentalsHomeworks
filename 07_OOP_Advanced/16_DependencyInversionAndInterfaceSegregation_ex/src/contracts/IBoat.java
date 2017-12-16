package contracts;

public interface IBoat extends IModelable {
	
	String getModel();
	
    double getRaceSpeed(IRace race);
    
    boolean isMotorBoat();

}
