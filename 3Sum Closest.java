import java.util.Arrays;

public class Solution {
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int ret = num[0] + num[1] + num[2];
		for (int i = 0; i < num.length; i++) {
			int start = i + 1;
			int end = num.length - 1;
			while (start < end) {
				if (Math.abs(ret - target) > Math.abs(num[start] + num[end] + num[i] - target)) {
					ret = num[start] + num[end] + num[i];
				}
				if (num[start] + num[end] < target - num[i]) {
					start++;
				} else if (num[start] + num[end] > target - num[i]) {
					end--;
				} else {
					return target;
				}
			}
		}
		return ret;
	}
}