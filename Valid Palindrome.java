public class Solution {
    private boolean isPalindrome_alphanumeric (char c) {
        if ('a'<=c && c <= 'z') {
            return true;
        }
        if ('A'<=c && c <= 'Z') {
            return true;
        }
        if ('0'<=c && c <= '9') {
            return true;
        }
        return false;
    }
    
    private boolean isPalindrome_match (char c1, char c2) {
        if (c1==c2) {
            return true;
        }
        if (Character.toUpperCase(c1)== Character.toUpperCase(c2)) {
            return true;
        }
        return false;
    }
    public boolean isPalindrome(String s) {
        int low = 0; 
        int high = s.length()-1;
        while (low<high) {
            while (low<high && !isPalindrome_alphanumeric(s.charAt(low))) {
                low ++;
            }
            while (low<high && !isPalindrome_alphanumeric(s.charAt(high))) {
                high --;
            }
            if (low<high){
                if ( !isPalindrome_match(s.charAt(low),s.charAt(high))) {
                    return false;
                } else {
                    low++;
                    high--;
                }
            } 
        }
        return true;
    }
}