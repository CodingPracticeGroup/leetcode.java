import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		Arrays.sort(num); // Elements in a subset must be in non-descending order.
		HashSet<ArrayList<Integer>> ret = recursion(num, num.length);
		ret.add(new ArrayList<Integer>());
		return new ArrayList<ArrayList<Integer>>(ret);
	}

	private HashSet<ArrayList<Integer>> recursion(int[] num, int length) {
		if (length <= 1) {
			HashSet<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>();
			ArrayList<Integer> ret2 = new ArrayList<Integer>();
			ret2.add(num[0]);
			ret.add(ret2);
			return ret;
		}

		HashSet<ArrayList<Integer>> ret = recursion(num, length - 1);

		HashSet<ArrayList<Integer>> ret2 = new HashSet<ArrayList<Integer>>();
		for (ArrayList<Integer> al : ret) {
			ArrayList<Integer> al2 = new ArrayList<Integer>(al);
			al2.add(num[length - 1]);
			ret2.add(al2); // The solution set must not contain duplicate subsets.
		}
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(num[length - 1]);
		ret2.add(al2); // The solution set must not contain duplicate subsets.

		ret.addAll(ret2);
		return ret;
	}
}