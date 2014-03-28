public class Solution {
	public int sqrt(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x == 0)
			return 0;
		double r = 1;
		while (true) {
			double other = x / r;
			if (Math.abs(other - r) < 0.01)
				return (int) ((Math.min(r, other) + Math.max(r, other)) / 2);
			r = (r + other) / 2;
		}
	}
}