package p04_WorkForce.models;

import java.util.ArrayList;

import p04_WorkForce.contracts.Handler;
import p04_WorkForce.contracts.Job;
import p04_WorkForce.events.EventType;

public class JobList extends ArrayList<Job> {

	private static final long serialVersionUID = 1L;
	
	private Handler handler;
	
	public JobList(Handler handler) {
		this.handler = handler;
	}

	public void addJob(Job job) {
		super.add(job);
	}
	
	public void passWeek() {
		for (int i = 0; i < super.size(); i++) {
			handler.handle(super.get(i).update(), super.get(i));
			if (super.get(i).getRemainingHours() <= 0) {
				super.remove(i);
				i--;
			}
		}
	}

	public void getJobStatus() {
		for (int i = 0; i < super.size(); i++) {
			handler.handle(EventType.STATUS, super.get(i));
		}
	}

}
