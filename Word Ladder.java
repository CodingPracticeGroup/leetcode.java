import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		int len = start.length();
		int length = 0;

		ArrayDeque<String> qBfs = new ArrayDeque<String>();
		// mark and enqueue
		qBfs.offer(start);
		// while queue is not empty
		while (!qBfs.isEmpty()) {
			// dequeue one level. this is variant of bfs
			ArrayList<String> level = new ArrayList<String>(qBfs);
			qBfs.clear();
			// process
			length++;
			// mark and enqueue neighbors
			for (String s : level) {
				for (int i = 0; i < len; i++) {
					char c = s.charAt(i);
					for (char n = 'a'; n <= 'z'; n++) {
						if (n != c) {
							StringBuilder sb = new StringBuilder(s);
							sb.setCharAt(i, n);
							String t = sb.toString();
							// t is neighbor. now, mark and enqueue t
							if (t.equals(end)) {
								return length + 1;
							}
							if (dict.contains(t)) {
								dict.remove(t);
								qBfs.offer(t);
							}
						}
					}
				}
			}
		}

		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		new Solution().ladderLength("a", "c", set);
	}

}
