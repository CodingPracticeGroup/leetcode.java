public class Solution {
	public String multiply(String num1, String num2) {
		String num1r = new StringBuilder(num1).reverse().toString();
		String num2r = new StringBuilder(num2).reverse().toString();

		int sum[] = new int[num1.length() + num2.length()];
		for (int i = 0; i < num1r.length(); i++) {
			for (int j = 0; j < num2r.length(); j++) {
				sum[i + j] += (num1r.charAt(i) - '0') * (num2r.charAt(j) - '0'); // multiply insight
			}
		}
		for (int i = 0; i < sum.length; i++) {
			if (i + 1 < sum.length) {
				sum[i + 1] += sum[i] / 10;
			}
			sum[i] = sum[i] % 10;
		}

		int firstLoc = sum.length - 1;
		while (firstLoc > 0 && sum[firstLoc] == 0) {
			firstLoc--;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = firstLoc; i >= 0; i--) {
			sb.append(sum[i]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		new Solution().multiply("9133", "0");
	}
}