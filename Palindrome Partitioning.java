import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution {
	public ArrayList<ArrayList<String>> partition(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = s.length();
		boolean dpIsPalindrome[][] = new boolean[len + 1][len + 1];
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {
				if (isPalindrome(s.substring(i, j))) {
					dpIsPalindrome[i][j] = true;
				}
			}
		}
		ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
		dfs(s, 0, len, ret, new ArrayDeque<String>(), dpIsPalindrome);
		return ret;
	}

	private void dfs(String s, int start, int end, ArrayList<ArrayList<String>> ret, ArrayDeque<String> root2leaf,
			boolean dpIsPalindrome[][]) {
		if (dpIsPalindrome[start][end]) {
			ArrayList<String> al = new ArrayList<String>(root2leaf);
			al.add(s.substring(start, end));
			ret.add(al);
		}
		for (int i = start + 1; i < end; i++) {
			if (dpIsPalindrome[start][i]) {
				root2leaf.offerLast(s.substring(start, i));
				dfs(s, i, end, ret, root2leaf, dpIsPalindrome);
				root2leaf.pollLast();
			}
		}
	}

	private boolean isPalindrome(String s) {
		if (s.equals(new StringBuilder(s).reverse().toString())) {
			return true;
		}
		return false;
	}
}