import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Solution {
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		ArrayList<Integer> source = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++) {
			source.add(num[i]);
		}
		HashSet<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>();
		recursion(new ArrayDeque<Integer>(), ret, target, source);
		return new ArrayList<ArrayList<Integer>>(ret);
	}

	private void recursion(ArrayDeque<Integer> track, HashSet<ArrayList<Integer>> ret, int target,
			ArrayList<Integer> source) {
		if (target == 0) { // if found then report
			ArrayList<Integer> solution = new ArrayList<Integer>(track);
			Collections.sort(solution);
			ret.add(solution);
		} else {
			for (int i = 0; i < source.size(); i++) { // explore candidates
				if (source.get(i) <= target) {
					track.push(source.remove(i)); // forward
					recursion(track, ret, target - track.peek(), source); // dfs
					source.add(i, track.pop()); // backward
				}
			}
		}
	}
}