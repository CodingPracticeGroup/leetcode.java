import java.util.Arrays;

public class Solution {
	public String addBinary(String a, String b) {
		char[] aa = new StringBuilder(a).reverse().toString().toCharArray();
		char[] bb = new StringBuilder(b).reverse().toString().toCharArray();
		int aaa[] = new int[aa.length];
		int bbb[] = new int[bb.length];
		for (int i = 0; i < aa.length; i++) {
			aaa[i] = aa[i] - '0';
		}
		for (int i = 0; i < bb.length; i++) {
			bbb[i] = bb[i] - '0';
		}
		int len = Math.max(aaa.length, bbb.length);
		int ccc[] = new int[len + 1];
		int tmp = 0;
		for (int i = 0; i < len; i++) {
			int sum = 0;
			sum += tmp;
			if (i < aaa.length) {
				sum += aaa[i];
			}
			if (i < bbb.length) {
				sum += bbb[i];
			}
			ccc[i] = sum % 2;
			tmp = sum / 2;
		}
		if (tmp != 0) {
			ccc[len] = tmp;
		} else {
			ccc = Arrays.copyOfRange(ccc, 0, len);
		}
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < ccc.length; i++) {
			ret.append(ccc[i]);
		}
		return ret.reverse().toString();
	}
}