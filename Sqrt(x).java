public class Solution {
	public int sqrt(int x) {
		int left = 1;
		int right = x;
		int mid = (left + right) / 2;
		while (mid != left && mid != right) {
			if (x / mid > mid) { // cannot use mid*mid because it could be greater than
				left = mid;
			} else if (x / mid < mid) {
				right = mid;
			} else {
				return mid;
			}
			mid = (left + right) / 2;
		}
		return mid;
	}

	public static void main(String[] args) {
		new Solution().sqrt(2147395599);
	}
}