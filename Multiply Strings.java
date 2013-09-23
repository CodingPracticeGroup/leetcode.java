public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(null==num1) return num2;
        if(null==num2) return num1;
        int len1=num1.length();
        int len2=num2.length();
        if(0==len1) return num2;
        if(0==len2) return num1;
        int[] num = new int[len1+len2];
        
        String result="";
        
        for(int i=0;i<len1;i++){
            int d=0;
            int a=num1.charAt(len1-1-i)-'0';
            for(int j=0;j<len2;j++){
                int b=num2.charAt(len2-1-j)-'0';
                int temp=num[i+j]+a*b+d;
                d=temp/10;
                num[i+j]=temp%10;
            }
            num[len2+i]+=d;
        }
        
        int i=num.length-1;
        while(i>0 && num[i]==0) i--;
        
        while(i>=0)
        	result+=(char)('0'+num[i--]);
        
        return result;
    }

}
