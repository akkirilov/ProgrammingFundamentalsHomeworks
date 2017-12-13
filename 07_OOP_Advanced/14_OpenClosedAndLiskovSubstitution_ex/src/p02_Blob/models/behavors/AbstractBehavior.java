package p02_Blob.models.behavors;

import p02_Blob.interfaces.Behavior;
import p02_Blob.models.Blob;

public abstract class AbstractBehavior implements Behavior {

    private boolean isTriggered;
    private boolean toDelayRecurrentEffect;

    public AbstractBehavior() {
    	this.isTriggered = false;
        this.toDelayRecurrentEffect = true;
    }

    @Override
    public boolean isTriggered() {
        return this.isTriggered;
    }

    @Override
    public void triggerBehavior(Blob source) {
    	if (!this.isTriggered) {
    		this.isTriggered = true;
    		this.applyTriggerEffect(source);
		}
    }

    protected boolean toDelayRecurrentEffect() {
        return this.toDelayRecurrentEffect;
    }

    protected void setToDelayRecurrentEffect(boolean toDelayRecurrentEffect){
        this.toDelayRecurrentEffect = toDelayRecurrentEffect;
    }
	
	protected abstract void applyTriggerEffect(Blob source);

}
