import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		HashSet<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>();
		Arrays.sort(num);
		ArrayList<Integer> source = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++) {
			source.add(num[i]);
		}
		recursion(new ArrayDeque<Integer>(), ret, source); // trigger explore
		return new ArrayList<ArrayList<Integer>>(ret);
	}

	private void recursion(ArrayDeque<Integer> track, HashSet<ArrayList<Integer>> ret, ArrayList<Integer> source) {
		if (source.isEmpty()) { // found
			ret.add(new ArrayList<Integer>(track)); // report
		} else { // explore
			int last = source.get(0) - 1;
			for (int i = 0; i < source.size(); i++) { // candidates
				if (source.get(i) != last) { // prune
					last = source.get(i);
					track.push(source.get(i)); // forward
					source.remove(i);
					recursion(track, ret, source); // recursion
					source.add(i, track.pop()); // backward
				}
			}
		}
	}
}