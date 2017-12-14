package p02_services.models;

import p02_services.interfaces.NotificationService;

public class OnlineStoreOrder {

    private NotificationService[] notificationServices;

    public OnlineStoreOrder(NotificationService... notificationServices) {
        this.notificationServices = notificationServices;
    }

    public void process() {
    	for (NotificationService ns : notificationServices) {
			if (ns.isActive()) {
				ns.sendNotification();
			}
		}
    }
    
}
