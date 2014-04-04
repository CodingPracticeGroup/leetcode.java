import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		int limit = S.length() - L.length * L[0].length();
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i <= limit; i++) {
			if (window(S, i, L[0].length(), L) == true) {
				ret.add(i);
			}
		}
		return ret;
	}

	private boolean window(String S, int idx, int len, String[] L) {
		HashMap<String, Integer> map = resetMap(L);
		for (int i = 0; i < L.length; i++) {
			String str = S.substring(idx + i * len, idx + i * len + len);
			if (map.containsKey(str)) {
				int count = map.get(str);
				if (count > 0) {
					map.put(str, count - 1);
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}

	private HashMap<String, Integer> resetMap(String[] L) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String s : L) {
			if (map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}
		}
		return map;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] L = new String[] { "a" };
		new Solution().findSubstring("a", L);
	}

}
