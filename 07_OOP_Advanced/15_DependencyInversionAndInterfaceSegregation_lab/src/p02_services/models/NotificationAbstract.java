package p02_services.models;

import p02_services.interfaces.NotificationService;
import p02_services.interfaces.Sender;

public abstract class NotificationAbstract implements NotificationService {
	
	private Sender sender;
	private boolean isActive;

	protected NotificationAbstract(Sender sender, boolean isActive) {
		setIsActive(isActive);
		this.sender = sender;
	}

	@Override
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public boolean isActive() {
		return this.isActive;
	}

    protected Sender getSender() {
    	return this.sender;
    }	
}
