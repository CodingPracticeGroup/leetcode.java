public class Solution {
	public int minCut(String s) {
		int len = s.length();
		// System.out.println(System.currentTimeMillis());
		// sub string [i, j) where 0<=i<len and 0<j<=len
		boolean dpIsPalindrome[][] = new boolean[len + 1][len + 1];
		for (int i = 0; i < len; i++) {
			dpIsPalindrome[i][i + 1] = true;
			for (int j = 0; 0 < i - j && i + 1 + j < len; j++) {
				if (dpIsPalindrome[i - j][i + 1 + j] && s.charAt(i - j - 1) == s.charAt(i + 1 + j)) {
					dpIsPalindrome[i - j - 1][i + 1 + j + 1] = true;
				} else {
					break;
				}
			}
		}
		for (int i = 0; i < len - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dpIsPalindrome[i][i + 2] = true;
				for (int j = 0; 0 < i - j && i + 2 + j < len; j++) {
					if (dpIsPalindrome[i - j][i + 2 + j] && s.charAt(i - j - 1) == s.charAt(i + 2 + j)) {
						dpIsPalindrome[i - j - 1][i + 2 + j + 1] = true;
					} else {
						break;
					}
				}
			}
		}
		// System.out.println(System.currentTimeMillis());
		// sub string [i, len)
		int dpMinCut[] = new int[len];
		dpMinCut[len - 1] = 0;
		for (int i = len - 2; i >= 0; i--) {
			if (dpIsPalindrome[i][len]) {
				dpMinCut[i] = 0;
			} else {
				int min = len;
				for (int j = i + 1; j < len; j++) {
					if (dpIsPalindrome[i][j] && min > dpMinCut[j]) {
						min = dpMinCut[j];
					}
				}
				dpMinCut[i] = 1 + min;
			}
		}
		// System.out.println(System.currentTimeMillis());
		//
		return dpMinCut[0];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Solution().minCut("a");
	}

}
