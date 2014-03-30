import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> ret = new ArrayList<String>();
		HashMap<String, String> memory = new HashMap<String, String>();
		for (String s : strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String sorted = new String(ca);
			if (memory.containsKey(sorted)) {
				if (memory.get(sorted) != null) {
					ret.add(memory.get(sorted));
					memory.put(sorted, null);
				}
				ret.add(s);
			} else {
				memory.put(sorted, s);
			}
		}
		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] strs = new String[] { "tea", "and", "ate", "eat", "dan" };
		new Solution().anagrams(strs);
	}

}
