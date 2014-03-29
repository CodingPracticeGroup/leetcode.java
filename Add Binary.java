public class Solution {
	public String addBinary(String a, String b) {
		// Start typing your Java solution below
		// DO NOT write main() function
		String a_ = new StringBuilder(a).reverse().toString();
		String b_ = new StringBuilder(b).reverse().toString();
		String[] a_arr = a_.split("");
		String[] b_arr = b_.split("");
		int i = 1;
		int tmp = 0;
		StringBuilder sb = new StringBuilder();
		while (i < a_arr.length || i < b_arr.length) {
			int sum = tmp;
			if (i < a_arr.length)
				sum += Integer.valueOf(a_arr[i]);
			if (i < b_arr.length)
				sum += Integer.valueOf(b_arr[i]);
			tmp = sum / 2;
			sb.append(sum % 2);
			i++;
		}
		if (tmp > 0)
			sb.append(tmp);
		return sb.reverse().toString();
	}
}