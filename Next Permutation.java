import java.util.Arrays;

public class Solution {
	public void nextPermutation(int[] num) {
		// step 1, from right to left, find the first digit which violates the increase trend
		int swap1 = num.length - 2;
		while (swap1 >= 0) {
			if (num[swap1] < num[swap1 + 1]) {
				break;
			} else {
				swap1--;
			}
		}
		if (swap1 < 0) {
			for (int i = 0; i < num.length / 2; i++) {
				swap(num, i, num.length - i - 1);
			}
			return;
		}
		// step 2, from right to left, find the first digit which is larger than the one picked from step 1
		int swap2 = num.length - 1;
		while (swap2 > swap1) {
			if (num[swap2] <= num[swap1]) {
				swap2--;
			} else {
				break;
			}
		}
		// step 3, swap numbers of the above two steps
		swap(num, swap1, swap2);
		// step 4, reverse all the digits on the right of step 1
		Arrays.sort(num, swap1 + 1, num.length);
	}

	private void swap(int[] num, int swap1, int swap2) {
		int tmp = num[swap1];
		num[swap1] = num[swap2];
		num[swap2] = tmp;
	}
}