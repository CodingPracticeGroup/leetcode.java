import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		int len = s.length();

		boolean[] dpCanDo = new boolean[len]; // substring i-n can be broken
		for (int i = 0; i < len; i++) { // ending len
			if (dict.contains(s.substring(i, len))) {
				dpCanDo[i] = true;
			}
		}
		for (int i = len - 1; i > 0; i--) { // ending i
			if (dpCanDo[i] == true) {
				for (int j = 0; j < i; j++) { // starting j
					if (dict.contains(s.substring(j, i))) {
						dpCanDo[j] = true;
					}
				}
			}
		}

		ArrayList<String> ret = new ArrayList<String>();
		dfs(dpCanDo, 0, len, ret, s, new ArrayDeque<String>(), dict);
		return ret;
	}

	private void dfs(boolean[] dpCanDo, int start, int end, ArrayList<String> ret, String s,
			ArrayDeque<String> root2leaf, Set<String> dict) {
		for (int i = start + 1; i < end; i++) { // ending i
			if (dict.contains(s.substring(start, i)) && dpCanDo[i]) {
				root2leaf.offerLast(s.substring(start, i));
				dfs(dpCanDo, i, end, ret, s, root2leaf, dict);
				root2leaf.pollLast();
			}
		}
		if (dpCanDo[start] && dict.contains(s.substring(start, end))) {
			root2leaf.offerLast(s.substring(start, end));
			ret.add(makeString(root2leaf));
			root2leaf.pollLast();
		}
	}

	private String makeString(ArrayDeque<String> root2leaf) {
		StringBuilder sb = new StringBuilder();
		for (String s : root2leaf) {
			sb.append(s);
			sb.append(" ");
		}
		return sb.substring(0, sb.length() - 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashSet<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		ArrayList<String> ret = new Solution().wordBreak("ab", dict);
		for (String s : ret) {
			System.out.println(s);
		}

	}

}
