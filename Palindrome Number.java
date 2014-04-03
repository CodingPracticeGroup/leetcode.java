public class Solution {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int left2right = 1;
		while (left2right <= x / 10) {
			left2right *= 10;
		}
		int right2left = 10;
		int left = x;
		int right = x;
		while (left2right >= right2left) {
			if (left / left2right != right % right2left) {
				return false;
			}
			left = left % left2right;
			right = right / 10;
			left2right /= 10;
			right2left = 10;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Solution().isPalindrome(10);
	}

}
