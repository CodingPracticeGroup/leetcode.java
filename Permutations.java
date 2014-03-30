import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> source = new ArrayList<Integer>();
		for (int i=0; i<num.length; i++) {
			source.add(num[i]);
		}
		recursion(new ArrayDeque<Integer>(), ret, source);
		return ret;
	}

	private void recursion(ArrayDeque<Integer> track, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> source) {
		if (source.isEmpty()) { // found solution
			ret.add(new ArrayList<Integer>(track)); // report it
		} else {
			for (int i = 0; i < source.size(); i++) { // candidate set
				// forward
				track.push(source.get(i));
				source.remove(i);
				// recursive explore
				recursion(track, ret, source);
				// backward
				source.add(i, track.pop());
			}
		}
	}
}