public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] result = new int[2];
		if(null==A) return result;
		int len=A.length;
		if(len<1) return result;
		
		int start=0;
		int end=len-1;
		int mid=0;
		//find low bound
		while(start<end){
			mid=(start+end)/2;
			if(A[mid]<target){
				start=mid+1;
			}else{
				end=mid;
			}
		}
		result[0]=-1;
		result[1]=-1;
		if(A[start]==target) result[0]=start;
		else return result;
		
		//find upper bound
		end=len-1;
		while(start<end){
		    mid=(start+end)/2;
			if(A[mid]>target){
				end=mid;
			}else{
				start=mid+1;
			}
		}
		if(A[start]==target) result[1]=len-1;
		else result[1]=start-1;
		
		return result;
    }
}