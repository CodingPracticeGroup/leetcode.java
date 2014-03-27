import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		ret.add(new ArrayList<Integer>()); // []
		for (int i = 0; i < S.length; i++) {
			int len = ret.size();
			for (int j = 0; j < len; j++) { // double
				ArrayList<Integer> newone = new ArrayList<Integer>(ret.get(j));
				newone.add(S[i]);
				ret.add(newone);
			}
		}
		return ret;
	}
}