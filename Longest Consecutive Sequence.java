import java.util.HashSet;

public class Solution {
	public int longestConsecutive(int[] num) {
		HashSet<Integer> set = new HashSet<Integer>(num.length);
		for (int i = 0; i < num.length; i++) {
			set.add(num[i]);
		}
		int longestLength = 0;
		while (!set.isEmpty()) {
			int cur = set.iterator().next();
			set.remove(cur);
			int left = cur, right = cur;
			while (set.contains(--left)) {
				set.remove(left);
			}
			while (set.contains(++right)) {
				set.remove(right);
			}
			if (right - left - 1 > longestLength) {
				longestLength = right - left - 1;
			}
		}
		return longestLength;
	}
}