public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(numbers==null) return null;
        int n=numbers.length;
        if(n==0) return null;
        int[] temp = (int[])numbers.clone();
        Arrays.sort(numbers);
        int[] result=new int[2];
        int i=0;
        int j=n-1;
        while(i<j){
            if(numbers[i]+numbers[j]>target){
                j--;
            }else if(numbers[i]+numbers[j]<target){
                i++;
            }else{
                break;
            }
        }
        if(numbers[i]+numbers[j] == target){
            for(int k=0;k<n;k++){
                if(temp[k]==numbers[i]) {
                    result[0]=k+1;break;
                }
            }
            int k=0;
            if(numbers[i]==numbers[j]){
            	k=result[0];
            }
            for(;k<n;k++){
                if(temp[k]==numbers[j]) {
                	result[1]=k+1;break;
                }
            }
        }
        Arrays.sort(result);
        return result;
    }
}
