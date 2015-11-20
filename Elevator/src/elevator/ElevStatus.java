package elevator;

public enum ElevStatus {
	RUN(0),
	IDLE(1),
	LOADING(2),
	UNLOADING(3),
	EMERGENCY(4);
	
	private int code;
	private ElevStatus(int code) {
		this.code = code;
	}
	public int getCode() {
		return this.code;
	}
}
