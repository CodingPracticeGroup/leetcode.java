public class Solution {
	public double pow(double x, int n) {
		if (n >= 0) {
			return powPositive(x, n);
		} else {
			return 1 / powPositive(x, -n);
		}
	}

	private double powPositive(double x, int n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return x;
		}

		int half = n / 2;
		double halfRet = powPositive(x, half);
		double ret = halfRet * halfRet;

		int remainder = n % 2;
		if (remainder == 1) {
			ret *= x;
		}

		return ret;
	}
}