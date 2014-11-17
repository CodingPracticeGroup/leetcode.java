public class Solution {
    public int findMin(int[] num) {
        if(null == num || num.length == 0) return 0;
        int n = num.length;
        int left =0, right=n-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(num[left]>num[mid]){
                left++;
                right=mid;
            }else if(num[right]<num[mid]){
                mid++;
                left=mid;
            }else break;
            /*if(x>num[mid]){
                left=mid+1;
            }else if(x<num[mid]){
                right=mid-1;
            }else{
                return mid;
            }*/
        }
        return num[left];
    }
}