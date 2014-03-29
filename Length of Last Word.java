public class Solution {
	public int lengthOfLastWord(String s) {
		s = s.trim();
		int lenTotoal = s.length();
		int lastSpaceLoc = -1;
		for (int i = 0; i < lenTotoal; i++) {
			if (s.charAt(i) == ' ') {
				lastSpaceLoc = i;
			}
		}
		if (lastSpaceLoc == -1) {
			return lenTotoal;
		} else {
			return lenTotoal - lastSpaceLoc - 1;
		}
	}
}