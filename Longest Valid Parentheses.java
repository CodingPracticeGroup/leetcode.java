public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null) return 0;
        int len=s.length();
        if(len<2) return 0;
        int result1=0;
        int restemp=0;
        int temp=0;
        //ordinary
        for(int i=0;i<len;i++){
            if('('==s.charAt(i))
                temp++;
            else
                temp--;
            restemp++;
            if(temp<0) {restemp=0;temp=0;} 
            else if(temp==0)  result1=Math.max(result1,restemp);
        }
        //reverse
        int result2=0;
        restemp=0;
        temp=0;
        for(int i=len-1;i>=0;i--){
            if(')'==s.charAt(i))
                temp++;
            else
                temp--;
            restemp++;
            if(temp<0) {restemp=0;temp=0;} 
            else if(temp==0) result2=Math.max(result2,restemp);
        }
        return Math.max(result1,result2);
    }
}