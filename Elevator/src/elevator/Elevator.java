package elevator;

import java.util.PriorityQueue;

public class Elevator {
	private double location;
	private double speed;
	private Direction dir;
	private ElevStatus status;
	private PriorityQueue<Request> upQueue, downQueue, runQueue;
	private Thread runThread, monitorThread;
	private class RunElevator {
		
	}
	private class MonitorRequest {
		
	}
	public boolean addRequest(Request req) {
		return true;
	}
	public Elevator() {
		
	}
}
