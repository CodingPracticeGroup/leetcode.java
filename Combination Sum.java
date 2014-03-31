import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Solution {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		HashSet<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>();
		recursion(new ArrayDeque<Integer>(), target, ret, candidates);
		return new ArrayList<ArrayList<Integer>>(ret);
	}

	private void recursion(ArrayDeque<Integer> track, int target, HashSet<ArrayList<Integer>> ret, int[] candidates) {
		if (target == 0) { // if found then report
			ArrayList<Integer> solution = new ArrayList<Integer>(track);
			Collections.sort(solution);
			ret.add(solution);
		} else {
			for (int i = 0; i < candidates.length; i++) { // explore candidates
				if (candidates[i] <= target) {
					track.push(candidates[i]); // forward
					recursion(track, target - candidates[i], ret, candidates); // dfs
					track.pop(); // backward
				}
			}
		}
	}
}