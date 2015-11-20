package elevator;

public class Request {
	private Direction dir;
	private int target;
	
	public Request(Direction dir, int target) {
		this.dir = dir;
		this.target = target;
	}
	
	public Direction getDirection() {
		return this.dir;
	}
	
	public int getTarget() {
		return this.target;
	}
}
