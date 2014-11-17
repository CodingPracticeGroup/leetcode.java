public class Solution {
    public int findMin(int[] num) {
        if(null == num || num.length == 0) return Integer.MAX_VALUE;
        int n = num.length;
        int left =0, right=n-1;
        if(n<=2) return Math.min(num[left],num[right]);
        int mid = (left+right)/2;
            if(num[left]<num[mid] && num[right]>num[mid])
                ;
            else if(num[left]<num[mid]){
                return Math.min(num[left],findMin(Arrays.copyOfRange(num,mid+1,right+1)));
            }else if(num[right]>num[mid]){
                return Math.min(num[mid],findMin(Arrays.copyOfRange(num,left,mid)));
            }else{
                return Math.min(findMin(Arrays.copyOfRange(num,left,mid)),findMin(Arrays.copyOfRange(num,mid,right+1)));
            }
        return num[left];
    }
}