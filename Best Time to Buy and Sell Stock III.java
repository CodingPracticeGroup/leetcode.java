public class Solution {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (prices == null || prices.length == 0) {
			return 0;
		}

		int dp0i[] = new int[prices.length]; // max profit in [0, i)
		dp0i[0] = 0;
		int priceLastMin = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (priceLastMin > prices[i]) {
				priceLastMin = prices[i];
			}
			dp0i[i] = Math.max(dp0i[i - 1], prices[i] - priceLastMin);
		}

		int dpin[] = new int[prices.length]; // max profit in [i, n)
		dpin[prices.length - 1] = 0;
		int priceLastMax = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			if (prices[i] > priceLastMax) {
				priceLastMax = prices[i];
			}
			dpin[i] = Math.max(dpin[i + 1], priceLastMax - prices[i]);
		}

		int profitMax = 0;
		for (int i = 0; i < prices.length; i++) {
			profitMax = Math.max(profitMax, dp0i[i] + dpin[i]);
		}
		return profitMax;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] test = new int[] { 1, 2, 4 };
		new Solution().maxProfit(test);
	}

}
