public class Solution {
	public int reverse(int x) {
		if (x < 0) {
			return Integer.valueOf("-" + new StringBuilder().append(-x).reverse().toString());
		} else {
			return Integer.valueOf(new StringBuilder().append(x).reverse().toString());
		}
	}
}