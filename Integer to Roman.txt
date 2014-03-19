public class Solution {
    public String intToRoman(int num) {
        String result="";
        String symbol[]= new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};    
        int value[]=    new int[]{1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1};
        int index=0;
        while(num>0){
            while(num>=value[index]){
                num-=value[index];
                result=result+symbol[index];
            }
            index++;
        }
        return result;
    }
}