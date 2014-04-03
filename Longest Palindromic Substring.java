public class Solution {
	public String longestPalindrome(String s) {
		int start = 0;
		int end = 0;
		int length = 1;

		for (int i = 0; i < s.length(); i++) { // center [i,i] to grow j
			for (int j = 1; 0 <= i - j && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j); j++) {
				if (length < 1 + j * 2) {
					length = 1 + j * 2;
					start = i - j;
					end = i + j;
				}
			}
		}

		for (int i = 0; i + 1 < s.length(); i++) { // center [i,j] to grow k
			int j = i + 1;
			for (int k = 0; 0 <= i - k && j + k < s.length() && s.charAt(i - k) == s.charAt(j + k); k++) {
				if (length < 2 + k * 2) {
					length = 2 + k * 2;
					start = i - k;
					end = j + k;
				}
			}

		}

		return s.substring(start, end + 1);
	}
}