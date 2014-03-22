public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
         if(digits==null) return null;
	        int l=digits.length();
	        if(l==0){result.add(digits);return result;}
	        char ctemp='\0'; int itemp=3;
	        switch(digits.charAt(0)){
	            case '2': ctemp='a';break;
	            case '3': ctemp='d';break;
	            case '4': ctemp='g';break;
	            case '5': ctemp='j';break;
	            case '6': ctemp='m';break;
	            case '7': ctemp='p';itemp=4;break;
	            case '8': ctemp='t';break;
	            case '9': ctemp='w';itemp=4;break;
	            default: ctemp='\0';itemp=0;
	        }
	        
	        if(l==1){
	            for(int i=0;i<itemp;i++){
	                result.add( String.valueOf((char)(ctemp+i)));
	            }
	        }else{
	            String rest = digits.substring(1);
	            ArrayList<String> rtemp =letterCombinations(rest);
	            for(int i=0;i<itemp;i++){
	                for(String restCom: rtemp){
	                    String onetemp = String.valueOf((char)(ctemp+i)) + restCom;
	                    result.add(onetemp);
	                }
	            }
	        }
	        
	        return result;
    }
}