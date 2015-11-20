package elevator;

public enum Direction {
	UP(0),
	DOWN(1);	
	private int code;
	private Direction(int code) {
		this.code = code;
	}
	public int getCode() {
		return this.code;
	}
}
