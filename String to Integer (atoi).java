public class Solution {
    public int atoi(String str) {
        if(null==str) return 0;
        str=str.trim();
        int len=str.length();
        if(len==0) return 0;
        
        int index=0;
        boolean positive=true;
        if(str.charAt(index)=='-'){
            positive=false; index++;
        }
        else if(str.charAt(index)=='+'){
            positive=true; index++;
        }
        int result=0;
        while(index<len){
            if(!Character.isDigit(str.charAt(index))){break;}
            int temp= str.charAt(index)-'0';
            //check large number
            if(positive&&result>(Integer.MAX_VALUE-temp)/10){
                return Integer.MAX_VALUE;
            }
            if(!positive&&((-1)*result<(Integer.MIN_VALUE+temp)/10)){
                return Integer.MIN_VALUE;
            }
            //basic case
            result=result*10+temp;
            index++;
        }
        if(positive) return result;
        return (-1)*result;
    }
}
