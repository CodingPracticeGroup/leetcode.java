public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        str=str.trim();
        if(str.length()<=0) return 0;
        int sign=1;
        int i=0;
        if(str.charAt(0)=='-'){
            sign=-1;
            i++;
        }else if(str.charAt(0)=='+'){
            i++;
        }
        
        if(!Character.isDigit(str.charAt(i))){
            return 0;
        }
        
        int result=0;
        int temp=0;
        
        while(i<str.length()){
            temp=str.charAt(i)-'0';
            if(temp<0||temp>9) break;
            if((sign==-1)&&(Integer.MIN_VALUE+temp)/10+result>0){
                return Integer.MIN_VALUE;
            }else if(sign==1&&result>(Integer.MAX_VALUE-temp)/10){
              result=Integer.MAX_VALUE;
              break;
            } 
            result=result*10+temp;
            i++;
        }
        
        return sign*result;
    }
}
