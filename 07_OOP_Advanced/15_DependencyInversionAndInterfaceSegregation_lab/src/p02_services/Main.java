package p02_services;

import p02_services.interfaces.NotificationService;
import p02_services.interfaces.Sender;
import p02_services.models.ConsoleSender;
import p02_services.models.EmailNotificationService;
import p02_services.models.OnlineStoreOrder;
import p02_services.models.SmsNotificationService;

public class Main {

	public static void main(String[] args) {

		Sender sender = new ConsoleSender();
		NotificationService smsNotification = new SmsNotificationService(sender, true);
	    NotificationService emailNotification = new EmailNotificationService(sender, true);
	    
	    OnlineStoreOrder order = new OnlineStoreOrder(emailNotification, smsNotification);
	    order.process();
		
	}

}
