public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices==null) return 0;
        int len=prices.length;
        if(len<=1) return 0;
        int[] max_pro_ord = new int[len];
        int min=0;
        for(int i=1;i<len;i++){
            if(prices[i]<prices[min]) min=i;
            max_pro_ord[i]=Math.max(max_pro_ord[i-1],prices[i]-prices[min]);
        }
        int[] max_pro_rev = new int[len];
        int max=len-1;
        for(int i=len-2;i>=0;i--){
            if(prices[i]>prices[max]) max=i;
            max_pro_rev[i]=Math.max(max_pro_rev[i+1],prices[max]-prices[i]);
        }
        int result=0;
        for(int i=0;i<len;i++){
            result=Math.max(result,max_pro_ord[i]+max_pro_rev[i]);
        }
        return result;
    }
}
