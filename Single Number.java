public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = A.length;
        
        int result=0;
        for(int i=0;i<n;i++){
            result^=A[i];
        }
        return result;
    }
}
