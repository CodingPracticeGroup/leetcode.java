public class Solution {
	public String addBinary(String a, String b) {
		// Start typing your Java solution below
		// DO NOT write main() function
		String a_ = new StringBuilder(a).reverse().toString();
		String b_ = new StringBuilder(b).reverse().toString();
		StringBuilder sb = new StringBuilder();
		int t = 0;
		int len_a = a_.length();
		int len_b = b_.length();
		if (len_a < len_b) {
			int i = 0;
			while (i < len_a) {
				int sum = a_.charAt(i) - '0' + b_.charAt(i) - '0' + t;
				t = sum / 2;
				sb.append(sum % 2);
				i++;
			}
			while (i < len_b) {
				int sum = b_.charAt(i) - '0' + t;
				t = sum / 2;
				sb.append(sum % 2);
				i++;
			}
		} else if (len_a > len_b) {
			int i = 0;
			while (i < len_b) {
				int sum = a_.charAt(i) - '0' + b_.charAt(i) - '0' + t;
				t = sum / 2;
				sb.append(sum % 2);
				i++;
			}
			while (i < len_a) {
				int sum = a_.charAt(i) - '0' + t;
				t = sum / 2;
				sb.append(sum % 2);
				i++;
			}
		} else {
			int i = 0;
			while (i < len_b) {
				int sum = a_.charAt(i) - '0' + b_.charAt(i) - '0' + t;
				t = sum / 2;
				sb.append(sum % 2);
				i++;
			}
		}
		if (t == 1)
			sb.append(t);
		return sb.reverse().toString();
	}
}