package leetcode;

public class PhoneDirectory {

	private int[] pool;
	private boolean[] occupied;
	private int tail;
	private int head;
	/** Initialize your data structure here
    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
	public PhoneDirectory(int maxNumbers) {
		this.pool = new int[maxNumbers];
		this.occupied = new boolean[maxNumbers];
		this.tail = maxNumbers - 1;
		for (int i = 0; i < maxNumbers; i ++)
			this.pool[i] = i + 1;
		this.pool[tail] = -1;
		this.head = 0;
	}

	/** Provide a number which is not assigned to anyone.
    @return - Return an available number. Return -1 if none is available. */
	public int get() {
		if (this.head == -1)
			return -1;
		int res = this.head;
		this.occupied[res] = true;
		this.head = this.pool[res];
		return res;
	}

	/** Check if a number is available or not. */
	public boolean check(int number) {
		if (number < 0 || number >= this.pool.length)
			return false;
		return !this.occupied[number];
	}

	/** Recycle or release a number. */
	public void release(int number) {
		if (number < 0 || number >= this.pool.length || this.occupied[number] == false)
			return;
		this.occupied[number] = false;
		this.pool[this.tail] = number;
		this.pool[number] = -1;
		this.tail = number;
		if (this.head == -1)
			this.head = number;
	}
	public static void main(String[] args) {
		// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
		PhoneDirectory directory = new PhoneDirectory(3);

		// It can return any available phone number. Here we assume it returns 0.
		System.out.println(directory.get());

		// Assume it returns 1.
		System.out.println(directory.get());

		// The number 2 is available, so return true.
		System.out.println(directory.check(2));

		// It returns 2, the only number that is left.
		System.out.println(directory.get());

		// The number 2 is no longer available, so return false.
		System.out.println(directory.check(2));

		// Release number 2 back to the pool.
		directory.release(2);

		// Number 2 is available again, return true.
		System.out.println(directory.check(2));

		// It returns 2, the only number that is left.
		System.out.println(directory.get());
		System.out.println(directory.get());
		directory.release(1);
		System.out.println(directory.get());
	}

}
