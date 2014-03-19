public class Solution {
    public int romanToInt(String s) {
        if(s==null||s.length()==0) return 0;
        int len=s.length();
        s=s.toUpperCase();
        int result=getValue(s.charAt(len-1));;
        for(int i=len-2;i>=0;i--){
            int value2=getValue(s.charAt(i+1));
            int value1=getValue(s.charAt(i));
            if(value2>value1){
                result-=value1;
            }else{
                result+=value1;
            }
        }
        return result;
    }
    
    public int getValue(char c){
        int value1=0;
            switch(c){
                case 'I':  value1 = 1; break;
                case 'V':  value1 = 5;  break;
                case 'X':  value1 = 10;  break;
                case 'L':  value1 = 50;  break;
                case 'C':  value1 = 100; break;
                case 'D':  value1 = 500;  break;
                case 'M':  value1 = 1000;  break;
                default:   value1 = 0;  break;
            };
            return value1;
    }
}