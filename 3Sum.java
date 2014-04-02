import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		HashSet<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>();
		for (int i = 0; i < num.length; i++) {
			ArrayList<ArrayList<Integer>> two = twoSum(num, i + 1, num.length, 0 - num[i]);
			for (ArrayList<Integer> al : two) {
				ArrayList<Integer> three = new ArrayList<Integer>();
				three.add(num[i]);
				three.addAll(al);
				ret.add(three);
			}
		}
		return new ArrayList<ArrayList<Integer>>(ret);
	}

	private ArrayList<ArrayList<Integer>> twoSum(int[] num, int start, int end, int target) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		int i = start;
		int j = end - 1;
		while (i < j) {
			if (num[i] + num[j] < target) {
				i++;
			} else if (target < num[i] + num[j]) {
				j--;
			} else {
				ArrayList<Integer> two = new ArrayList<Integer>();
				two.add(num[i]);
				two.add(num[j]);
				ret.add(two);
				i++;
				j--;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] num = new int[] { 0, 0, 0 };
		new Solution().threeSum(num);
	}
}