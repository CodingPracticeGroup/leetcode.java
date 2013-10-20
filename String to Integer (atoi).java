public class Solution {
	public int atoi(String str) {
		// Start typing your Java solution below
		// DO NOT write main() function
		String str2 = str.trim();
		if (str2.length() == 0)
			return 0;
		boolean minus = false;
		if (str2.charAt(0) == '-') {
			minus = true;
			str2 = str2.substring(1);
		} else if (str2.charAt(0) == '+') {
			str2 = str2.substring(1);
		}
		int sum = 0;
		for (int i = 0; i < str2.length(); i++) {
			if (str2.charAt(i) < '0' || str2.charAt(i) > '9')
				break;
			if (minus == false && sum > Integer.MAX_VALUE / 10) {
				return Integer.MAX_VALUE;
			} else if (minus && sum + Integer.MIN_VALUE / 10 > 0) {
				return Integer.MIN_VALUE;
			}
			sum *= 10;
			if (minus == false && str2.charAt(i) - '0' > Integer.MAX_VALUE - sum) {
				return Integer.MAX_VALUE;
			} else if (minus && -(str2.charAt(i) - '0') < Integer.MIN_VALUE + sum) {
				return Integer.MIN_VALUE;
			}
			sum += str2.charAt(i) - '0';
		}
		if (minus)
			return -sum;
		else
			return sum;
	}
}