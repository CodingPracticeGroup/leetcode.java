import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		HashSet<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>();
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int start = j + 1;
				int end = num.length - 1;
				while (start < end) {
					if (num[i] + num[j] + num[start] + num[end] < target) {
						start++;
					} else if (num[i] + num[j] + num[start] + num[end] > target) {
						end--;
					} else {
						ArrayList<Integer> solution = new ArrayList<Integer>();
						solution.add(num[i]);
						solution.add(num[j]);
						solution.add(num[start]);
						solution.add(num[end]);
						ret.add(solution);
						start++;
						end--;
					}
				}
			}
		}
		return new ArrayList<ArrayList<Integer>>(ret);
	}
}