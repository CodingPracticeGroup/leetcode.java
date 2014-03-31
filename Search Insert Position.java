import java.util.Arrays;

public class Solution {
	public int searchInsert(int[] A, int target) {
		int ret = Arrays.binarySearch(A, target);
		if (ret >= 0) {
			return ret;
		} else {
			return -ret - 1; // (-(insertion point) - 1) = ret
		}
	}
}