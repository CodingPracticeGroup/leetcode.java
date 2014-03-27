import java.util.ArrayList;

public class Solution {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		recursion(n, k, 1, ret, new ArrayList<Integer>());
		return ret;
	}

	// recursion & backtracking
	// the return should be void because the track is the acutal return
	// the final return is passed as well
	private void recursion(int n, int k, int curInt, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> track) {
		if (track.size() == k) {
			ret.add(new ArrayList<Integer>(track));
			return;
		}

		if (curInt <= n) {
			recursion(n, k, curInt + 1, ret, track);

			track.add(curInt);
			recursion(n, k, curInt + 1, ret, track);
			track.remove(track.size() - 1);
		}
	}
}