package hanoi;

import java.util.Stack;

public class Hanoi {

	public class HanoiGoal {
		int n, s, d, m;
		public HanoiGoal(int n, int s, int d, int m) {
			this.n = n;
			this.s = s;
			this.d = d;
			this.m = m;
		}
	}
	private HanoiGoal goal = null;

	public Hanoi(int n, int s, int d, int m) {
		this.goal = new HanoiGoal(n, s, d, m);
	}

	private void setNextMove(Stack<HanoiGoal> st, int n, int s, int d, int m) {
		HanoiGoal goal = new HanoiGoal(n, s, d, m);
		st.push(goal);
	}

	private void move(Stack<HanoiGoal> st) {
		HanoiGoal goal = st.pop();
		if (goal.n != 1)
			System.exit(-1);
		System.out.printf("Move %d from Tower#%d to Tower#%d%n", goal.n, goal.s, goal.d);
		if (!st.isEmpty()) {
			goal = st.pop(); 
			System.out.printf("Move %d from Tower#%d to Tower#%d%n", goal.n, goal.s, goal.d);
			this.setNextMove(st, goal.n - 1, goal.m, goal.d, goal.s);
		}
	}

	public void solveHanoi() {
		Stack<HanoiGoal> st = new Stack<>();
		st.push(this.goal);
		while (!st.isEmpty()) {
			HanoiGoal goal = st.peek();
			if (goal.n == 1)
				this.move(st);
			else
				this.setNextMove(st, goal.n - 1, goal.s, goal.m, goal.d);
		}
	}

	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi(3, 1, 3, 2);
		hanoi.solveHanoi();
	}
}
