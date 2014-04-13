public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(null==strs) return null;
        int n = strs.length; 
        if(0==n) return ""; 
        StringBuilder sb = new StringBuilder();
        for(int j=0;j<strs[0].length();j++){
            char c = strs[0].charAt(j);
            int i=1;
            for(;i<n;i++){
                if(j>=strs[i].length()||strs[i].charAt(j)!=c) break;
            }
            if(i==n) sb.append(c);
            else break;
        }
        return sb.toString();
    }
}
