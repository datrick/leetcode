package leet218;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
	
	public static class Building {
		private int x, y, h;

		public Building(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
		public int getx() {
			return this.x;
		}
		public int gety() {
			return this.y;
		}
		public int geth() {
			return this.h;
		}
	}

	private int addBuilding(int[][] buildings, int i, PriorityQueue<Building> Qy, PriorityQueue<Building> Qh) {
		int num = 0, x0 = buildings[i][0];
		while (i < buildings.length && buildings[i][0] == x0) {
			Building b = new Building(buildings[i][0], buildings[i][1], buildings[i][2]);
			Qy.add(b);
			Qh.add(b);
			num ++;
			i ++;
		}
		return num;
	}

	private void removeBuilding(PriorityQueue<Building> Qy, PriorityQueue<Building> Qh) {
		int y0 = Qy.peek().y;
		while (! Qy.isEmpty() && Qy.peek().y == y0) {
			Qh.remove(Qy.poll());
		}
	}

	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> rslt = new ArrayList<>();
		PriorityQueue<Building> Qy = new PriorityQueue<>(100, Comparator.comparingInt(Building :: gety)),
				Qh = new PriorityQueue<>(100, Comparator.comparing(Building :: geth).reversed());
		int i = 0, n = buildings.length, h0 = 0;
		while (i < n) {
			if (Qy.isEmpty() || Qy.peek().y > buildings[i][0]) {
				int x0 = buildings[i][0];
				//int h0 = Qh.isEmpty() ? 0 : Qh.peek().h;
				i += this.addBuilding(buildings, i, Qy, Qh);
				int h1 = Qh.isEmpty() ? 0 : Qh.peek().h;
				if (h1 != h0){
					rslt.add(new int[] {x0, h1});
					h0 = h1;
				}
			} else if (Qy.peek().y < buildings[i][0]) {
				int y0 = Qy.peek().y;
				this.removeBuilding(Qy, Qh);
				int h1 = Qh.isEmpty() ? 0 : Qh.peek().h;
				if (h0 != h1) {
					rslt.add(new int[] {y0, h1});
					h0 = h1;
				}
			} else {
				int x0 = buildings[i][0];
				this.removeBuilding(Qy, Qh);
				i += this.addBuilding(buildings, i, Qy, Qh);
				int h1 = Qh.isEmpty() ? 0 : Qh.peek().h;
				if (h1 != h0){
					rslt.add(new int[] {x0, h1});
					h0 = h1;
				}
			}
		}

		while (! Qy.isEmpty()) {
			int y0 = Qy.peek().y;
			this.removeBuilding(Qy, Qh);
			int h1 = Qh.isEmpty() ? 0 : Qh.peek().h;
			if (h0 != h1) {
				rslt.add(new int[] {y0, h1});
				h0 = h1;
			}
		}

		return rslt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] buildings = { {2, 4, 1}, {2, 4, 2}, {2, 4, 1} };
		List<int[]> rslt = new Solution().getSkyline(buildings);
		for (int[] line : rslt){
			System.out.printf("[%d, %d], ", line[0], line[1]);
		}
	}
}
