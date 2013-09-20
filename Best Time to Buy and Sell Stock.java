public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices==null) return 0;
        int len=prices.length;
        if(len<=1) return 0;
        int result=0;
        int min=0;
        for(int i=1;i<len;i++){
            if(prices[i]<prices[min]) min=i;
            result=Math.max(result,prices[i]-prices[min]);
        }
        return result;
    }
}