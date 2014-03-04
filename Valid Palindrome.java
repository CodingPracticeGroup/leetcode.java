public class Solution {
	public boolean isPalindrome(String s) {
		s = s.replaceAll("[^a-zA-Z0-9]", "");
		s = s.toLowerCase();
		StringBuffer sb = new StringBuffer(s);
		return sb.reverse().toString().equals(s);
	}
}