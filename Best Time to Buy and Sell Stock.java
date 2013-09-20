public class Solution {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (prices == null || prices.length == 0) {
			return 0;
		}

		int len = prices.length;
		int z_i[] = new int[len];

		int min = prices[0];
		z_i[0] = 0;
		for (int i = 1; i < len; i++) {
			min = Math.min(prices[i], min);
			z_i[i] = Math.max(z_i[i - 1], prices[i] - min);
		}

		return z_i[len - 1];
	}
}