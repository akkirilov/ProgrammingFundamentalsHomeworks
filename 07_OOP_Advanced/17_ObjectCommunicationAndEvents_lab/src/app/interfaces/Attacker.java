package app.interfaces;
public interface Attacker extends Observer {
	
    void attack();
    
    void setTarget(Target target);
    
}
