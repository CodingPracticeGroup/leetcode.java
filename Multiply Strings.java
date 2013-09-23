public class Solution {
	public String multiply(String num1, String num2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len1 = num1.length();
		int len2 = num2.length();
		int[] num1_ = new int[len1];
		int[] num2_ = new int[len2];
		for (int i = 0; i < len1; i++)
			num1_[i] = num1.charAt(i) - '0';
		for (int i = 0; i < len2; i++)
			num2_[i] = num2.charAt(i) - '0';
		//
		int sum[] = new int[len1 + len2];
		for (int i = 0; i < len1 + len2; i++)
			sum[i] = 0;
		//
		for (int i = len2 - 1; i >= 0; i--) {
			int tmp[] = new int[len1 + len2];
			for (int k = 0; k < len1 + len2; k++)
				tmp[k] = 0;
			//
			for (int j = len1 - 1; j >= 0; j--) {
				int idx = (len1 + len2 - 1) - (len1 - j - 1) - (len2 - i - 1);
				tmp[idx] += num1_[j] * num2_[i];
				if (tmp[idx] / 10 > 0)
					tmp[idx - 1] += tmp[idx] / 10;
				tmp[idx] %= 10;
			}
			for (int k = len1 + len2 - 1; k >= 0; k--) {
				sum[k] += tmp[k];
				if (sum[k] / 10 > 0)
					sum[k - 1] += sum[k] / 10;
				sum[k] %= 10;
			}
		}
		//
		boolean flag = false;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len1 + len2; i++) {
			if (flag == false && sum[i] > 0)
				flag = true;
			if (flag)
				sb.append(sum[i]);
		}
		//
		if (flag)
			return sb.toString();
		else
			return "0";
	}
}