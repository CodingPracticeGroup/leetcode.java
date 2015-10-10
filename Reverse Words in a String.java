public class Solution {
    public String reverseWords(String s) {
        if(null==s) return null;
        s=s.trim();
        int len = s.length();
        if(len==0) return "";
        String result="";
        s=reverse(s,0,len);
        for(int i=0;i<len; i++){
            int start = i;
            int end = i;
            while(end<len&&s.charAt(end)!=' ') end++;
            result+=reverse(s,start,end);
            result+=" ";
            
            i=end;
            while(end<len&&s.charAt(end)==' ') i=end++;
        }
        return result.trim();
    }
    public String reverse(String s, int start, int end){
        StringBuilder sb = new StringBuilder(s.substring(start,end));
        sb.reverse();
        return sb.toString();
    }
}
