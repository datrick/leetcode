package elevator;

import java.util.List;

public class ElevSystem {
	public static final void handleEmergency(int code) {
		
	}
	private List<Elevator> elevators;
	private List<Request> pendingRequests;
	private Thread dispatcher;
	public boolean addCommonRequest(Request req) {
		return true;
	}
	private void dispatchRequests() {
		
	}
	private class Dispatcher implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
