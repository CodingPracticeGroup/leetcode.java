import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
	public ArrayList<String> generateParenthesis(int n) {
		if (n == 1) {
			ArrayList<String> ret = new ArrayList<String>();
			ret.add("()");
			return ret;
		}
		ArrayList<String> tmp = generateParenthesis(n - 1);
		HashSet<String> ret = new HashSet<String>();
		for (String s : tmp) {
			for (int i = 0; i < s.length(); i++) {
				ret.add(new StringBuilder(s).insert(i, "()").toString());
			}
		}
		return new ArrayList<String>(ret);
	}
}