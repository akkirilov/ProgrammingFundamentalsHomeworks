package p02_services.models;

import p02_services.interfaces.Sender;

public class EmailNotificationService extends NotificationAbstract {

    public EmailNotificationService(Sender sender, boolean isActive) {
    	super(sender, isActive);
    }
    
    @Override
    public void sendNotification() {
    	super.getSender().send("send mail...");
    }
    
}
