public class Solution {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int priceLowest = prices[0];
		int profitMax = 0;
		for (int i = 1; i < prices.length; i++) {
			if (priceLowest > prices[i]) {
				priceLowest = prices[i];
			} else {
				profitMax = Math.max(profitMax, prices[i] - priceLowest);
			}
		}
		return profitMax;
	}
}