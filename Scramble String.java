import java.util.HashMap;

public class Solution {
	public boolean isScramble(String s1, String s2) {
		return recursion(s1, 0, s1.length(), s2, 0, s2.length());
	}

	// 4 point recursion can pass large test
	// String.substring(x,y)/isScramble cannot pass large test
	private boolean recursion(String s1, int startS1, int endS1, String s2, int startS2, int endS2) {
		if (prune(s1, startS1, endS1, s2, startS2, endS2) == false) {
			return false;
		}

		if (s1.substring(startS1, endS1).equals(s2.substring(startS2, endS2))) {
			return true;
		}

		int lenS1 = endS1 - startS1;
		for (int i = 1; i < lenS1; i++) { // left sub string length
			boolean check1 = recursion(s1, startS1, startS1 + i, s2, startS2, startS2 + i)
					&& recursion(s1, startS1 + i, endS1, s2, startS2 + i, endS2);
			boolean check2 = recursion(s1, startS1, startS1 + i, s2, endS2 - i, endS2)
					&& recursion(s1, startS1 + i, endS1, s2, startS2, endS2 - i);
			if (check1 || check2) {
				return true;
			}
		}

		return false;
	}

	HashMap<Character, Integer> hmS1 = new HashMap<Character, Integer>();

	private boolean prune(String s1, int startS1, int endS1, String s2, int startS2, int endS2) {
		if (endS1 - startS1 != endS2 - startS2) {
			return false;
		}

		hmS1.clear();
		for (int i = startS1; i < endS1; i++) {
			char character = s1.charAt(i);
			int count = 0;
			if (hmS1.containsKey(character)) {
				count = hmS1.get(character);
			}
			hmS1.put(character, count + 1);
		}
		for (int i = startS2; i < endS2; i++) {
			char character = s2.charAt(i);
			if (hmS1.containsKey(character)) {
				int count = hmS1.get(character);
				if (count == 1) {
					hmS1.remove(character);
				} else {
					hmS1.put(character, count - 1);
				}
			} else {
				return false;
			}
		}
		return hmS1.size() == 0;
	}

	public static void main(String[] args) {
		boolean ret = new Solution().isScramble("ab", "ba");
		System.out.println(ret);
	}
}