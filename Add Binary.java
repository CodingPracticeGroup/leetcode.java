public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a==null) return b;
        if(b==null) return a;
        int alen=a.length()-1;
        int blen=b.length()-1;
        String c="";
        int digit=0;int temp=0;
        while(alen>=0&&blen>=0){
            int tempa=a.charAt(alen)-'0';
            int tempb=b.charAt(blen)-'0';
            temp=(tempa+tempb+digit)%2;
            digit=(tempa+tempb+digit)/2;
            char tempc=(char) ('0'+temp);
            c=(tempc)+c;
            alen--;blen--;
        }
        while(alen>=0){
            int tempa=a.charAt(alen)-'0';
            temp=(tempa+digit)%2;
            digit=(tempa+digit)/2;
            char tempc=(char) ('0'+temp);
            c=(tempc)+c;
            alen--;
        }
        while(blen>=0){
            int tempb=b.charAt(blen)-'0';
            temp=(tempb+digit)%2;
            digit=(tempb+digit)/2;
            char tempc=(char) ('0'+temp);
            c=(tempc)+c;
            blen--;
        }
        if(digit>0){
            c='1'+c;
        }
        return c;
    }
}