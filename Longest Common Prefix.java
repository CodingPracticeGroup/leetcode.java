public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) {
            return "";
        }
        String sample = strs[0];
        int smapleLen = sample.length();
        while (smapleLen>0) {
            String prefix = sample.substring(0, smapleLen);
            if (Stream.of(strs).filter(s->s.startsWith(prefix)).count()==strs.length) {
                break;
            }
            smapleLen--;
        }
        if (smapleLen==0) {
            return "";
        }
        return strs[0].substring(0, smapleLen);
    }
}