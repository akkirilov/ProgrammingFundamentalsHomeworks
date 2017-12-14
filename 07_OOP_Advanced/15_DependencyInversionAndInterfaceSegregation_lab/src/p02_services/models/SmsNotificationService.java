package p02_services.models;

import p02_services.interfaces.Sender;

public class SmsNotificationService extends NotificationAbstract {

	public SmsNotificationService(Sender sender, boolean isActive) {
		super(sender, isActive);
	}

	public void sendNotification() {
		super.getSender().send("send sms...");
    }

}
