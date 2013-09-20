public class Solution {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (prices == null || prices.length == 0) {
			return 0;
		}

		int len = prices.length;
		int z_i[] = new int[len];
		int i_n[] = new int[len];

		int min = prices[0];
		z_i[0] = 0;
		for (int i = 1; i < len; i++) {
			min = Math.min(prices[i], min);
			z_i[i] = Math.max(z_i[i - 1], prices[i] - min);

		}

		int max = prices[len - 1];
		i_n[len - 1] = 0;
		for (int i = len - 2; i >= 0; i--) {
			max = Math.max(prices[i], max);
			i_n[i] = Math.max(max - prices[i], i_n[i + 1]);
		}

		int max_profit = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			max_profit = Math.max(max_profit, z_i[i] + i_n[i]);
		}

		return max_profit;
	}
}