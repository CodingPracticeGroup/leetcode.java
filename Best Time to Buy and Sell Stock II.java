public class Solution {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int sum = 0;
		if (prices == null || prices.length == 0)
			return sum;
		int[] delta = new int[prices.length - 1];
		for (int i = 1; i < prices.length; i++)
			delta[i - 1] = prices[i] - prices[i - 1];
		for (int i = 0; i < delta.length; i++)
			if (delta[i] > 0)
				sum += delta[i];
		return sum;
	}
}