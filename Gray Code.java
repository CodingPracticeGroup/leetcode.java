import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	// http://en.wikipedia.org/wiki/Gray_code#Constructing_an_n-bit_Gray_code
	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ret.add(0);
		for (int i = 1; i <= n; i++) {
			ArrayList<Integer> ret2 = new ArrayList<Integer>(ret);
			Collections.reverse(ret2);
			for (Integer i2 : ret2) {
				i2 |= 1 << i - 1;
				ret.add(i2);
			}
		}
		return ret;
	}
}