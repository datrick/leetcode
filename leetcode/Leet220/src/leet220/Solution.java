package leet220;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k <= 0)
			return false;
		if (k <= t) {
			for (int i = 0; i < nums.length; i ++) {
				for (int j = Math.max(0, i - k); j < i; j ++) {
					if (Math.abs((long)nums[i] - (long)nums[j]) <= (long)t)
						return true;
				}
			}
		} else {
			Map<Long, Long> map = new HashMap<>();
			for (int i = 0; i < nums.length; i ++) {
				for (long n = (long)nums[i] - (long)t; n <= (long)nums[i] + t; n ++)
					if (map.containsKey((long)n) && map.get((long)n) > 0)
						return true;
				if (i - k >= 0)
					map.put((long)nums[i - k], map.get((long)(nums[i - k]) - 1));
				if (map.containsKey((long)nums[i]))
					map.put((long)nums[i], map.get((long)nums[i]) + 1);
				else
					map.put((long)nums[i], (long) 1);
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		try(Scanner scanner = new Scanner(new File("data.txt"))) {
			List<Integer> list = new ArrayList<>();
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				String[] numbers = line.split(",");
				for (String s : numbers)
					list.add(Integer.parseInt(s));
			}
			int[] nums = new int[list.size()];
			for (int i = 0; i < nums.length; i ++)
				nums[i] = list.get(i);
			System.out.println(nums[nums.length - 1]);
			System.out.println(new SolutionIII().containsNearbyAlmostDuplicate(nums, 2, 3));
		}
	}
}
