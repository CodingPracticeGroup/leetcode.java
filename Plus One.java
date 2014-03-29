import java.util.Arrays;

public class Solution {
	public int[] plusOne(int[] digits) {
		int[] ret = new int[digits.length + 1];
		int tmp = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = digits[i] + tmp;
			tmp = sum / 10;
			ret[i + 1] = sum % 10;
		}
		if (tmp == 0) {
			return Arrays.copyOfRange(ret, 1, ret.length);
		} else {
			ret[0] = tmp;
			return ret;
		}
	}
}