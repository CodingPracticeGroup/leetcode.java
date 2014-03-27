public class Solution {
	public static int size = 260;

	public String minWindow(String S, String T) {
		// use array to replace hash map. char is integer
		int validLen = 0;
		int[] charCountT = new int[size];
		for (int i = 0; i < T.length(); i++) {
			if (charCountT[T.charAt(i)] == 0) {
				validLen++;
			}
			charCountT[T.charAt(i)]++;
		}

		// use (validCount == validLen) to check.
		// if check every time instead of tracking validCount, cannot pass large test
		int bestLeft = 0, bestRight = S.length() - 1; // [bestLeft, bestRight]
		int[] charCountS = new int[size];
		int left = 0, right = 0; // [left, right]
		int validCount = 0;
		boolean exist = false;
		for (right = 0; right < S.length(); right++) {
			charCountS[S.charAt(right)]++;
			if (charCountS[S.charAt(right)] == charCountT[S.charAt(right)]) {
				validCount++;
			}

			if (validCount == validLen) {
				exist = true;
				while (validCount == validLen) {
					if (charCountS[S.charAt(left)] == charCountT[S.charAt(left)]) {
						validCount--;
					}
					charCountS[S.charAt(left)]--;
					left++;
				}
				left--;
				charCountS[S.charAt(left)]++;
				if (charCountS[S.charAt(left)] == charCountT[S.charAt(left)]) {
					validCount++;
				}

				if (right - left < bestRight - bestLeft) {
					bestLeft = left;
					bestRight = right;
				}
			}
		}

		if (!exist) {
			return "";
		}

		return S.substring(bestLeft, bestRight + 1);
	}

}